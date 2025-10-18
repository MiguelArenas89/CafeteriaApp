package com.project.cafeteria.cafeteriaapp.service;

import com.project.cafeteria.cafeteriaapp.entity.Cafe;
import com.project.cafeteria.cafeteriaapp.repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// La anotación @Service indica que esta clase contiene la lógica de negocio.
@Service
public class CafeService {

    // Inyectamos el Repository para poder acceder a los datos de la BD.
    private final CafeRepository cafeRepository;

    // Constructor para inyección de dependencias (del Repository).
    public CafeService(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }

    //Lógica de Negocio: Obtencion de la lista completa del menú de cafés.
    public List<Cafe> obtenerMenu() {
        // Usamos el método findAll() proporcionado por JpaRepository.
        return cafeRepository.findAll();
    }

    //Lógica de Negocio: Guardar un nuevo café en el menú.
    public Cafe guardarCafe(Cafe cafe) {
        return cafeRepository.save(cafe);
    }
}
