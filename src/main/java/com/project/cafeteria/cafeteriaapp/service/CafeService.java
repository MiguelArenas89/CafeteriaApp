package com.project.cafeteria.cafeteriaapp.service;

import com.project.cafeteria.cafeteriaapp.entity.Cafe;
import com.project.cafeteria.cafeteriaapp.repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CafeService {

    private final CafeRepository cafeRepository;
    public CafeService(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }
    public List<Cafe> obtenerMenu() {
        return cafeRepository.findAll();
    }

    public Cafe guardarCafe(Cafe cafe) {
        return cafeRepository.save(cafe);
    }
}
