package org.flota.project.models;

import com.esri.arcgisruntime.geometry.Point;

import java.util.ArrayList;

public class Ruta {

    private ArrayList<Punto> puntos = new ArrayList<Punto>();
    //private Conductor conductor;

    public void addPunto(Punto punto){
        puntos.add(punto);
    }

    public ArrayList<Point> getPoints(){
        ArrayList<Point> points = new ArrayList<Point>();
        for (Punto punto : puntos){
            points.add(punto.getPoint());
        }
        return points;
    }

    public ArrayList<Punto> getPuntos(){
        return puntos;
    }

}