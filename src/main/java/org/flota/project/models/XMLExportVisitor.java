package org.flota.project.models;

import java.util.HashMap;
import java.util.Map;
// import com.github.underscore.lodash.U;
// import com.github.underscore.lodash.*;

import org.flota.project.patterns.Visitor;

public class XMLExportVisitor implements Visitor {

    @Override
    public Map<String, String> visitRecojo(Recojo recojo) {
        Map<String, String> xml = new HashMap <>();
        xml.put("comentarios", recojo.getComentarios());
        xml.put("direccion", recojo.getDireccion());
        // System.out.println(xml);
        
        for (String i : xml.keySet()) {
            System.out.print( "\t<" + i + ">" + " " + xml.get(i) + " </" + i + ">\n" );
            // System.out.println( "<" + i + ">\n" + "\t" + xml.get(i) + "\n</" + i + ">\n" );
        }
        
        return xml;
    }
    
    @Override
    public Map<String, String> visitDespacho(Despacho despacho) {
        Map<String, String> xml = new HashMap <>();
        xml.put("comentarios", despacho.getComentarios());
        xml.put("direccion", despacho.getDireccion());
        xml.put("documento", despacho.getDocumento());
        xml.put("visitDespacho", "visitDespacho");
        // System.out.println(xml);
        
        System.out.println("\n");
        for (String i : xml.keySet()) {
            System.out.print( "\t<" + i + ">" + " " + xml.get(i) + " </" + i + ">\n" );
            // System.out.println( "<" + i + ">\n" + "\t" + xml.get(i) + "\n</" + i + ">\n" );
        }

        return xml;
    }

}