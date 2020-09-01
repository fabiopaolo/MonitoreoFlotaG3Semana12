package org.flota.project.patterns;

import org.flota.project.models.Ruta;


public interface RutaStrategy {
    Ruta crearRuta(double maxPesos, int maxPuntos);

    public Integer maximosPuntosParada();

    public Double maximoPesoPermitido();
}
