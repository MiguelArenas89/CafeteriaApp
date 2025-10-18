package com.project.cafeteria.cafeteriaapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders") // "order" es una palabra reservada en SQL, por eso usamos "orders".
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campo para guardar el total a pagar.
    private double total;

    // Campo para guardar el estado del pedido ("PENDIENTE", "EN PREPARACIÓN", "LISTO").
    private String estado;

    // Campo para registrar la fecha y hora del pedido.
    private LocalDateTime fechaCreacion;

    // Constructor vacío requerido por JPA.
    public Order() {
        // Inicialicion del estado y la fecha al crear la orden.
        this.estado = "PENDIENTE";
        this.fechaCreacion = LocalDateTime.now();
    }

    // Constructor simple para inicializar el total.
    public Order(double total) {
        this(); // Llamada al constructor por defecto para inicializar estado y fecha.
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }


}
