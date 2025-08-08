package com.tapiceria.union.model;

public class Trabajo {
    private int id;
    private String cliente;
    private String tipoMueble;
    private String fechaEntrega; // YYYY-MM-DD
    private String estado; // Pendiente | En proceso | Terminado

    public Trabajo(int id, String cliente, String tipoMueble, String fechaEntrega, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.tipoMueble = tipoMueble;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
    }

    public int getId() { return id; }
    public String getCliente() { return cliente; }
    public String getTipoMueble() { return tipoMueble; }
    public String getFechaEntrega() { return fechaEntrega; }
    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }
}
