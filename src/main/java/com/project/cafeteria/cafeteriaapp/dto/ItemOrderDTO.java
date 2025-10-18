package com.project.cafeteria.cafeteriaapp.dto;

//DTO (Data Transfer Object) para la comunicación entre el cliente y el servidor.
// Este DTO representa un solo artículo dentro del pedido del cliente.
public class ItemOrderDTO {
    // Uso del ID del café para buscarlo en la base de datos y obtener el precio
    private Long cafeId;
    private int cantidad;

    public ItemOrderDTO() {}

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
