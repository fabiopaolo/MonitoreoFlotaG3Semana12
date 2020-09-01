package org.flota.project.models;

import com.esri.arcgisruntime.geometry.Point;

import org.flota.project.patterns.RutaStrategy;

import java.util.ArrayList;

import org.flota.project.patterns.Context;

public class Ruta {

    private ArrayList<Punto> puntos = new ArrayList<Punto>();

    private double maxPesos;
    private int maxPuntos;

    public Ruta(double maxPesos, int maxPuntos){
        this.maxPesos = maxPesos;
        this.maxPuntos = maxPuntos;
    }
/*
    public void elegirEstrategiaRuta(RutaStrategy strategy){
        context = new Context(strategy);
    }
*/
    public void addPunto(Punto punto){
        if(punto.getPeso() > this.maxPesos){
            System.out.println("El peso " + punto.getPeso()+ " " + "excede lo maximo permitido que es " + this.maxPesos + " " + "por lo tanto no se puede realizar la acción");
        }else{
            puntos.add(punto);
            System.out.println("El peso " + punto.getPeso()+ " " + "es correcto que es menor o igual a " + this.maxPesos);
        }
        System.out.println("La cantidad de puntos de parada de este envío son " + this.maxPuntos);
        
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