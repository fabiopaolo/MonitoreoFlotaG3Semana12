package org.flota.project.models;

import javafx.scene.layout.StackPane;

public class FachadaMapa {
    
    public Mapa mostrarMapa(StackPane stackPane)  {

        Mapa mapaBase = new Mapa();
        mapaBase.imprimeCoordenadasActual();
        stackPane.getChildren().add(mapaBase.getMapView());
        return mapaBase;
    }
}