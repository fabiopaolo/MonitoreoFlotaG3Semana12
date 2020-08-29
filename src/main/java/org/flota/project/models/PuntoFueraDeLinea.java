package org.flota.project.models;

import org.flota.project.patterns.Visitor;

public class PuntoFueraDeLinea extends Punto {

    String motivo;

    public PuntoFueraDeLinea(double lon, double lat) {
        super(lon, lat);
        // TODO Auto-generated constructor stub
    }
    public PuntoFueraDeLinea(double lon, double lat,String motivo){
        super(lon, lat);
        this.motivo=motivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public String getFuera(){
        return "fuera de linea";
    }
   
    @Override
    public void accept(Visitor visitor) {
        visitor.visitFueraDeLinea(this);

    }
    @Override
    public String getUbicacion() {
        return super.getUbicacion();
    }
}