package org.flota.project.models;

public class EntregaProgramada implements Entrega   {

    private String rangoHora;
    private String fecha;
    private Double costo = 99.90;

    public EntregaProgramada(String rangoHora, String fecha)  {

        this.rangoHora = rangoHora;
        this.fecha = fecha;
    }

    @Override
    public void listarEntrega() {
        
        System.out.println("Entrega planificada: " + this.fecha + " - " + this.rangoHora );
    }

    @Override
    public Double calcularCosto() {
        
        return this.costo;
    }


    
}