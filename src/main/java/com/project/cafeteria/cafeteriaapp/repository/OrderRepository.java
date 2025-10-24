package com.project.cafeteria.cafeteriaapp.repository;

import com.project.cafeteria.cafeteriaapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // para agregar metodos personalizados en el futuro,
    // ejm; buscar todas las ordenes "PENDIENTES".
}