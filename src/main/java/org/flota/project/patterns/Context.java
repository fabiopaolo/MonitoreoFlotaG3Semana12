package org.flota.project.patterns;

import org.flota.project.models.Ruta;

public class Context {
    private RutaStrategy strategy;

    public void setStrategy(RutaStrategy strategy) {
        this.strategy = strategy;
    }

    public Ruta crearRuta(){
        return this.strategy.crearRuta();
    }
}
