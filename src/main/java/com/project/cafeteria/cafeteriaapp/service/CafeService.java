package com.project.cafeteria.cafeteriaapp.service;

import com.project.cafeteria.cafeteriaapp.entity.Cafe;
import com.project.cafeteria.cafeteriaapp.repository.CafeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// La anotación @Service indica que esta clase contiene la lógica de negocio.
@Service
public class CafeService {

    // Inyectamos el Repository para poder acceder a los datos de la BD.
    private final CafeRepository cafeRepository;

    // Constructor para inyección de dependencias (Autowired es implícito desde Spring 4.3).
    public CafeService(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }
    /**
     * Lógica de Negocio: Obtencion de la lista completa del menú de cafés.
     * @return Lista de objetos Cafe.
     */
    public List<Cafe> obtenerMenu() {
        // Usamos el método findAll() proporcionado por JpaRepository.
        return cafeRepository.findAll();
    }

    /**
     * Lógica de Negocio: Guardar un nuevo café en el menú.
     * @param cafe El objeto Cafe a guardar.
     * @return El objeto Cafe guardado con su ID generado.
     */
    public Cafe guardarCafe(Cafe cafe) {
        // Podrías añadir validaciones aquí antes de guardar.
        return cafeRepository.save(cafe);
    }
}
