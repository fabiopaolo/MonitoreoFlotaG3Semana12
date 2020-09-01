package org.flota.project.models;

import com.google.gson.JsonObject;
import org.flota.project.patterns.Visitor;

import java.util.HashMap;
import java.util.Map;

public class JSONExportVisitor implements Visitor {

    @Override
    public Map<String, String> visitRecojo(Recojo recojo) {
        Map<String, String> json = new HashMap <>();
        json.put("comentarios", recojo.getComentarios());
        json.put("direccion", recojo.getDireccion());
        json.put("visitRecojo", "visitRecojo");
        json.put("peso", String.valueOf(recojo.getPesoPaquete()));
        System.out.println(json);
        return json;
    }

    @Override
    public Map<String, String> visitDespacho(Despacho despacho) {
        Map<String, String> json = new HashMap <>();
        json.put("comentarios", despacho.getComentarios());
        json.put("direccion", despacho.getDireccion());
        json.put("documento", despacho.getDocumento());
        json.put("visitDespacho", "visitDespacho");
        json.put("peso", String.valueOf(despacho.getPesoPaquete()));
        System.out.println(json);
        return json;
    }
}
