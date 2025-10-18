package com.project.cafeteria.cafeteriaapp.service;

import com.project.cafeteria.cafeteriaapp.dto.ItemOrderDTO;
import com.project.cafeteria.cafeteriaapp.entity.Cafe;
import com.project.cafeteria.cafeteriaapp.entity.Order;
import com.project.cafeteria.cafeteriaapp.repository.CafeRepository;
import com.project.cafeteria.cafeteriaapp.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CafeRepository cafeRepository;

    // Inyección de dependencias para los repositorios
    public OrderService(OrderRepository orderRepository, CafeRepository cafeRepository) {
        this.orderRepository = orderRepository;
        this.cafeRepository = cafeRepository;
    }

    //Procesa una lista de ItemsOrderDTO, calcula el total y guarda la nueva Orden.
    public Order crearOrden(List<ItemOrderDTO> items) {
        double totalPedido = 0.0;
        // Itera sobre cada ítem en el pedido para calcular el total.
        for (ItemOrderDTO item : items) {
            // Busca el café en la base de datos usando el ID del DTO.
            Optional<Cafe> cafeOptional = cafeRepository.findById(item.getCafeId());
            // Validación de existencia del café.
            if (cafeOptional.isEmpty()) {
                throw new RuntimeException("El café con ID " + item.getCafeId() + " no existe en el menú.");
            }
            Cafe cafe = cafeOptional.get();
            // Suma el total del precio por la cantidad solicitada.
            totalPedido += cafe.getPrecio() * item.getCantidad();
        }

        // Crea y guarda la entidad Order con el total calculado.
        Order nuevaOrden = new Order(totalPedido);
        return orderRepository.save(nuevaOrden);
    }

    //Obtencion de todas las órdenes del sistema (para el rol de Gerente/Barista).
    public List<Order> obtenerTodasLasOrdenes() {
        return orderRepository.findAll();
    }
}
