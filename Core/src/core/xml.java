/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.Element;
import org.jdom2.Document;

/**
 *
 * @author dark
 */
public class xml {

    static Vector<String> atributos = new Vector<>();
    static Vector<String> parametros = new Vector<>();
    static Vector<String> descripcion = new Vector<>();
    static Vector<String> cabecera = new Vector<>();
    static String num_columnas = "";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JDOMException {
        // TODO code application logic here
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("/home/dark/Escritorio/Desde-Java/estructura.xml");
        System.err.println(xmlFile);
        System.err.println(xmlFile.exists());
        try {
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List list = (List) rootNode.getChildren("configuracion");
            extraerInformacion(list);
            System.err.println(descripcion);
            System.err.println(atributos);
            System.out.println(num_columnas);
            System.err.println(parametros);
            System.err.println(cabecera);
            
        } catch (IOException io) {
            System.err.println("Se exploto 1");
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.err.println("Se exploto 2");
            System.out.println(jdomex.getMessage());
        }
    }

    public static void extraerInformacion(List l) {
        for (int i = 0; i < l.size(); i++) {
            Element e = (Element) l.get(i);
            if (e.getChildren().size() > 0) {
                extraerInformacion(e.getChildren());
            }else if (e.getName().equals("nombre") || e.getName().equals("descripcion") || e.getName().equals("version")){
                System.err.println("valor de la etiqueta : "+e.getName());
                descripcion.add(e.getText());
            }else if(e.getName().equals("columnas")){
                num_columnas = e.getText();
            }else if(e.getName().equals("atributo")){
                atributos.add(e.getText());
            }else if(e.getName().equals("tipo")){
                parametros.add(e.getText());
            }else if(e.getName().equals("columna")){
                cabecera.add(e.getText());
            }
        }

    }

}
