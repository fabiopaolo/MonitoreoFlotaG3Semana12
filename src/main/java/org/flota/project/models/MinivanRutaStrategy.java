package org.flota.project.models;

import org.flota.project.patterns.RutaStrategy;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MinivanRutaStrategy implements RutaStrategy {
    @Override
    public Ruta crearRuta(double maxPesos, int maxPuntos) {
        
        
        Ruta ruta = new Ruta(maxPesos,maxPuntos);
        ruta.addPunto(new Recojo(-77.067183 , -12.057869, "Av. Alborada", "Urgente",7.5));
        ruta.addPunto(new Despacho(-77.068311, -12.057683, "Av. Venezuela", "Normal", "1234111", 6));
        ruta.addPunto(new Despacho(-77.071208, -12.058061, "Leonardo Arrieta", "Normal", "7879888", 6.5));
        ruta.addPunto(new Despacho(-77.075666, -12.058895, "Aurelio Garcia Garcia", "Urgente", "7869777", 5.5));
        ruta.addPunto(new Despacho(-77.086166, -12.061350, "Av. Venezuela Huaca san Marcos", "Normal", "9043999", 7));
   
        return ruta;
    }


    @Override
    public Integer maximosPuntosParada() {

        return 5;
    }

    @Override
    public Double maximoPesoPermitido() {

        return 7.5;
    }
}