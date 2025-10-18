package com.project.cafeteria.cafeteriaapp;

import com.project.cafeteria.cafeteriaapp.entity.Cafe;
import com.project.cafeteria.cafeteriaapp.repository.CafeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CafeteriaAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CafeteriaAppApplication.class, args);
    }
    @Bean
    public CommandLineRunner inicializarMenu(CafeRepository cafeRepository) {
        return args -> {
            // objetos Cafe del menú inicial
            List<Cafe> menuInicial = Arrays.asList(
                    new Cafe("Espresso", 5000.00),
                    new Cafe("Americano", 6000.00),
                    new Cafe("Capuchino", 8500.00),
                    new Cafe("Latte", 9000.00),
                    new Cafe("Mocaccino", 10000.00)
            );

            cafeRepository.saveAll(menuInicial);
            System.out.println("--- MENU CARGADO EN LA BASE DE DATOS ---");
        };
    }
}
