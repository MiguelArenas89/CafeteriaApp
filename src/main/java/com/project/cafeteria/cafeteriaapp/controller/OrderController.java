package com.project.cafeteria.cafeteriaapp.controller;

import com.project.cafeteria.cafeteriaapp.dto.ItemOrderDTO;
import com.project.cafeteria.cafeteriaapp.entity.Order;
import com.project.cafeteria.cafeteriaapp.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
// ruta base para todos los métodos de este controlador
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Endpoint: POST /api/ordenes
     * Permitira al cliente realizar un nuevo pedido.
     * El cuerpo de la petición espera una lista de ItemPedidoDTO.
     */

    @PostMapping
    public ResponseEntity<Order> realizarPedido(@RequestBody List<ItemOrderDTO> items) {
        try {
            Order ordenCreada = orderService.crearOrden(items);
            // Si la orden se crea exitosamente.
            return new ResponseEntity<>(ordenCreada, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // Manejo de errores si no se encuentra un café.
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    /**
     * Endpoint: GET /api/ordenes
     * Permitira al gerente/barista obtener todas las órdenes realizadas
     */
    @GetMapping
    public ResponseEntity<List<Order>> obtenerTodasLasOrdenes() {
        List<Order> ordenes = orderService.obtenerTodasLasOrdenes();
        return new ResponseEntity<>(ordenes, HttpStatus.OK);
    }
}
