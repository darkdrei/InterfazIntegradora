/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import logica.ModelTree.Node;
import org.jdom2.Document;
import org.jdom2.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author dark
 */
public class Core {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SAXException {
        try {
            String basePath = new File("").getAbsolutePath();
    System.out.println(basePath);
            System.out.println(System.getProperty("os.name").toLowerCase());
            String ruta = basePath+"/src/configuracion/xml_configuracion.xml";
            if (System.getProperty("os.name").toLowerCase().contains("windows")){
                ruta = basePath+"\\src\\configuracion\\xml_configuracion.xml";
            }
            // TODO code application logic here
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true); 
            factory.setExpandEntityReferences(false);
             factory.newDocumentBuilder().parse(new File(ruta));
            System.out.println(factory.newDocumentBuilder().parse(new File(ruta)));
            
        } catch (ParserConfigurationException ex) {
            System.err.println(ex);
        }
    }

}
