package com.project.cafeteria.cafeteriaapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

//DTO (Data Transfer Object) para la comunicación entre el cliente y el servidor.
// Este DTO representa un solo artículo dentro del pedido del cliente.
public class ItemOrderDTO {

    // Uso del ID del café para buscarlo en la base de datos y obtener el precio
    @NotNull (message = "El ID del café no puede ser nulo")
    private Long cafeId;

    @NotNull(message = "La cantidad no puede ser 0")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private int cantidad;

    public ItemOrderDTO(Long cafeId, int cantidad) {
        this.cafeId = cafeId;
        this.cantidad = cantidad;
    }

    public Long getCafeId() {
        return cafeId;
    }

    public void setCafeId(Long cafeId) {
        this.cafeId = cafeId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
