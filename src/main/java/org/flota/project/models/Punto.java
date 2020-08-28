package org.flota.project.models;

import com.esri.arcgisruntime.geometry.Point;
import org.flota.project.patterns.Visitor;

public abstract class Punto {

    private double latitud;
    private double longitud;
    private Point point;

    public Punto(double lon, double lat){
        latitud = lat;
        longitud = lon;
        point = new Point(lon, lat);
    }

    public Point getPoint(){
        return point;
    }

    public abstract void accept(Visitor visitor);

}
