package com.josspepf.doniadulzura.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int pUnidad;
    private int pTotal;
    private int cantidad;

    @OneToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    private Producto producto;

    @OneToOne
    @JoinColumn(name = "factura_id", referencedColumnName = "id")
    private Factura factura;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getpUnidad() {
        return pUnidad;
    }

    public void setpUnidad(int pUnidad) {
        this.pUnidad = pUnidad;
    }

    public int getpTotal() {
        return pTotal;
    }

    public void setpTotal(int pTotal) {
        this.pTotal = pTotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
