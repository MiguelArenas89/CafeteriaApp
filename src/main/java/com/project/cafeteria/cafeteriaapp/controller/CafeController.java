package com.project.cafeteria.cafeteriaapp.controller;

import com.project.cafeteria.cafeteriaapp.entity.Cafe;
import com.project.cafeteria.cafeteriaapp.service.CafeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController es una combinación de @Controller y @ResponseBody.
// Indica que la clase maneja peticiones HTTP y que los métodos devuelven datos (no vistas).
@RestController
// @RequestMapping define la ruta base para todos los métodos de este controlador.
@RequestMapping("/api/menu")
public class CafeController {

    // Inyectamos el servicio para acceder a la lógica de negocio.
    private final CafeService cafeService;

    // Inyección de dependencias a través del constructor.
    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    /**
     * Endpoint: GET /api/menu
     * Propósito: Permite al cliente obtener la lista completa del menú.
     * @return ResponseEntity con la lista de Cafes y un estado HTTP 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<Cafe>> obtenerMenuCompleto() {
        List<Cafe> menu = cafeService.obtenerMenu();
        // Devolvemos el menú con un estado HTTP 200 (OK).
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    /**
     * Endpoint: POST /api/menu
     * Propósito: Permite al Gerente agregar un nuevo café al menú.
     * @param cafe El objeto Cafe recibido en el cuerpo de la petición JSON.
     * @return ResponseEntity con el objeto Cafe guardado y un estado HTTP 201 (Created).
     */
    @PostMapping
    public ResponseEntity<Cafe> agregarCafe(@RequestBody Cafe cafe) {
        // Llamamos al servicio para guardar el nuevo café.
        Cafe nuevoCafe = cafeService.guardarCafe(cafe);
        // Devolvemos el café guardado con un estado HTTP 201 (Created).
        return new ResponseEntity<>(nuevoCafe, HttpStatus.CREATED);
    }
}
