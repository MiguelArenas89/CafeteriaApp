package com.project.cafeteria.cafeteriaapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

// La anotación @Entity le indica al JPA (Java Persistence API) que la clase es una tabla en la base de datos
@Entity
public class Cafe {
    // @Id indica que este campo es la clave primaria de la tabla.
    @Id
    // @GeneratedValue configura cómo se genera automáticamente el valor del ID.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;

    // JPA requiere un constructor por defecto sin argumentos.
    public Cafe() {}

    // Constructor para crear objetos Cafe con valores iniciales.
    public Cafe(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Métodos (Get,Set) para acceder y modificar los atributos.
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
