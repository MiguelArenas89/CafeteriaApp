package com.project.cafeteria.cafeteriaapp.repository;

import com.project.cafeteria.cafeteriaapp.entity.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// La anotación @Repository indica que esta interfaz es un componente de la capa de datos.
@Repository
// JpaRepository nos da acceso a métodos CRUD (Crear, Leer, Actualizar, Borrar).
public interface CafeRepository extends JpaRepository<Cafe, Long> {
    // Spring Data JPA ya proporciona métodos como save(), findAll(), findById(), etc.
    // No necesitas escribir código para ellos.
}
