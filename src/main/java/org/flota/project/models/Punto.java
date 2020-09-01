package org.flota.project.models;

import com.esri.arcgisruntime.geometry.Point;
import org.flota.project.patterns.Visitor;

public abstract class Punto {

    private double latitud;
    private double longitud;
    private Point point;
    private double pesoPaq;

    public Punto(double lon, double lat, double pesoPaquete){
        latitud = lat;
        longitud = lon;
        point = new Point(lon, lat);
        pesoPaq = pesoPaquete;
    }

    public Point getPoint(){
        return point;
    }

    public double getPeso(){
        return pesoPaq;
    }

    public abstract void accept(Visitor visitor);

}
