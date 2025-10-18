package com.project.cafeteria.cafeteriaapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //  guardar el total a pagar
    private double total;

    // estado del pedido ("PENDIENTE", "PREPARANDO", "LISTO")
    private String estado;

    // registra la fecha y hora del pedido
    private LocalDateTime fechaCreacion;

    // constructo vacio requerido por JPA
    public Order() {
        // inicialicion del estado y la fecha al crear la orden
        this.estado = "PENDIENTE";
        this.fechaCreacion = LocalDateTime.now();
    }

    // constructo simple para inicializar el total
    public Order(double total) {
        this(); // llamada al constructoo por defecto para inicializar estado y fecha
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
