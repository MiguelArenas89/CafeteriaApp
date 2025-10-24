package com.project.cafeteria.cafeteriaapp.service;

import com.project.cafeteria.cafeteriaapp.dto.ItemOrderDTO;
import com.project.cafeteria.cafeteriaapp.entity.Cafe;
import com.project.cafeteria.cafeteriaapp.entity.Order;
import com.project.cafeteria.cafeteriaapp.exceptions.NotFoundException;
import com.project.cafeteria.cafeteriaapp.repository.CafeRepository;
import com.project.cafeteria.cafeteriaapp.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CafeRepository cafeRepository;

    public OrderService(OrderRepository orderRepository, CafeRepository cafeRepository) {
        this.orderRepository = orderRepository;
        this.cafeRepository = cafeRepository;
    }

    public Order crearOrden(List<ItemOrderDTO> items) {
        double totalPedido = 0.0;

        for (ItemOrderDTO item : items) {

            Optional<Cafe> cafeOptional = cafeRepository.findById(item.getCafeId());

            if (cafeOptional.isEmpty()) {
                throw new NotFoundException("El café con ID " + item.getCafeId() + " no existe en el menú.");
            }
            Cafe cafe = cafeOptional.get();

            totalPedido += cafe.getPrecio() * item.getCantidad();
        }

        Order nuevaOrden = new Order(totalPedido);
        return orderRepository.save(nuevaOrden);
    }
    //obtencion de una orden por su ID
    public Order GetOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Orden con ID " + id + " no encontrada."));
    }

    //actualizar el estado de una orden
    public Order updateStateOrder(Long id, String nuevoEstado) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Orden con ID " + id + " no encontrada para actualizar estado."));
        order.setEstado(nuevoEstado);
        return orderRepository.save(order);
    }

    //obtencion de todas las ordenes del sistema
    public List<Order> obtenerTodasLasOrdenes() {
        return orderRepository.findAll();
    }
}
