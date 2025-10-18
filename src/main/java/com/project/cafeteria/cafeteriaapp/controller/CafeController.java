package com.project.cafeteria.cafeteriaapp.controller;

import com.project.cafeteria.cafeteriaapp.entity.Cafe;
import com.project.cafeteria.cafeteriaapp.service.CafeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @RestController es una combinación de @Controller y @ResponseBody.
@RequestMapping("/api/menu") // @RequestMapping define la ruta base para todos los métodos de este controlador.
public class CafeController {

    // Inyectamos el servicio para acceder a la lógica de negocio.
    private final CafeService cafeService;

    // Inyección de dependencias a través del constructor.
    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    /**
     * Endpoint: GET /api/menu
     * Permite al cliente obtener la lista completa del menú.
     */
    @GetMapping
    public ResponseEntity<List<Cafe>> obtenerMenuCompleto() {
        List<Cafe> menu = cafeService.obtenerMenu();
        // Devolvemos el menú con un estado HTTP 200 (OK).
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    /**
     * Endpoint: POST /api/menu
     * Permite al Gerente agregar un nuevo café al menú.
     */

    @PostMapping
    public ResponseEntity<Cafe> agregarCafe(@RequestBody Cafe cafe) {
        // Llamamos al servicio para guardar el nuevo café.
        Cafe nuevoCafe = cafeService.guardarCafe(cafe);
        // Devolvemos el café guardado con un estado HTTP 201 (Created).
        return new ResponseEntity<>(nuevoCafe, HttpStatus.CREATED);
    }
}
