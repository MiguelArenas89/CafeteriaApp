package com.project.cafeteria.cafeteriaapp.repository;

import com.project.cafeteria.cafeteriaapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Hereda de JpaRepository para obtener las funcionalidades CRUD para la entidad Order.
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // para agregar métodos personalizados en el futuro,
    // ejm; buscar todas las órdenes "PENDIENTES".
}