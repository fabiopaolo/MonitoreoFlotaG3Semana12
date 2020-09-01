package org.flota.project.models;

import org.flota.project.patterns.Visitor;

public class Despacho extends Punto {
    private String direccion;
    private String comentarios;
    private String documento;
    private double pesoPaq;

    public Despacho(double lon, double lat, double pesoPaquete) {
        super(lon, lat, pesoPaquete);
    }

    public Despacho(double lon, double lat, String direccion, String comentarios, String documento, double pesoPaquete) {
        super(lon, lat, pesoPaquete);
        this.direccion = direccion;
        this.comentarios = comentarios;
        this.documento = documento;
        this.pesoPaq = pesoPaquete;
    }

    public String getDireccion(){
        return direccion;
    }

    public String getComentarios(){
        return comentarios;
    }

    public String getDocumento(){
        return documento;
    }

    public double getPesoPaquete(){
        return pesoPaq;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitDespacho(this);
    }
}
