package org.flota.project.models;

import java.util.ArrayList;
import java.util.List;

public class GuiaEntrega implements Entrega {
    
    private List<Entrega> entregas;

    public GuiaEntrega()    {
        entregas = new ArrayList<Entrega>();
    }

    public void agregarEntrega(Entrega entrega)    {

        if (entrega != null)
            this.entregas.add(entrega);
    }

    public void quitarEntrega(int posicion)    {

        this.entregas.remove(posicion);
    }

    public List<Entrega> getEntregas()   {

        return this.entregas;
    }

    @Override
    public void listarEntrega() {
        
        for (Entrega entregaProgramada : entregas) {
            
            entregaProgramada.listarEntrega();
        }
    }

    @Override
    public Double calcularCosto() {

        Double costoTotal = 0.0;
        for (Entrega entregaProgramada : entregas) {
            
            costoTotal = costoTotal + entregaProgramada.calcularCosto();
        }
        return costoTotal;
    }

}