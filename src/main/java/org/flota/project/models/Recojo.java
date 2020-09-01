package org.flota.project.models;

import org.flota.project.patterns.Visitor;

public class Recojo extends Punto {

    private String direccion;
    private String comentarios;
    private double pesoPaq;

    public Recojo(double lon, double lat, double pesoPaquete) {
        super(lon, lat, pesoPaquete);
    }

    public Recojo(double lon, double lat, String direccion, String comentarios, double pesoPaquete) {
        super(lon, lat, pesoPaquete);
        this.direccion = direccion;
        this.comentarios = comentarios;
        this.pesoPaq = pesoPaquete;
    }

    public String getDireccion(){
        return direccion;
    }

    public String getComentarios(){
        return comentarios;
    }

    public double getPesoPaquete(){
        return pesoPaq;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitRecojo(this);
    }



}
