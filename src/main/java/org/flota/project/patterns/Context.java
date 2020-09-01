package org.flota.project.patterns;

import org.flota.project.models.Ruta;

public class Context {
    private RutaStrategy strategy;

    public Context(){    
    }

    public Context(RutaStrategy strategy){
        this.strategy = strategy;
    }

    public void setStrategy(RutaStrategy strategy) {
        this.strategy = strategy;
    }

    public Ruta crearRuta(double maxPesos, int maxPuntos){
        return this.strategy.crearRuta(maxPesos, maxPuntos);
    }

    public double validarPeso(){
        return this.strategy.maximoPesoPermitido();
    }

    public Integer maxPuntos(){
        return this.strategy.maximosPuntosParada();
    }
}
