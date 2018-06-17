/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author dark
 */
public class utileria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
//        File archivo = new File("/home/dark/Escritorio/aaaaaaaaaaa/a3");
//        if (!archivo.exists())
//            archivo.mkdir();
        ListComponenXml l = new ListComponenXml();
        String basePath = new File("").getAbsolutePath();
        System.out.println(basePath);
        System.out.println(System.getProperty("os.name").toLowerCase());
        String ruta = basePath + "/src/configuracion/xml_configuracion.xml";
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            ruta = basePath + "\\src\\configuracion\\xml_configuracion.xml";
        }
        l.loadingFile(ruta);
        l.readNodeFile();
//        for(Xml x : l.getXmls()){
//            System.out.println(x.toString());
//        }

        Element root = new Element("CONFIGURATION");
        Document doc = new Document();

        Element child1 = new Element("BROWSER");
        child1.addContent("chrome");
        Element child2 = new Element("BASE");
        child1.addContent("http:fut");
        Element child3 = new Element("EMPLOYEE");
        child3.addContent(new Element("EMP_NAME").addContent("Anhorn, Irene"));

        root.addContent(child1);
        doc.setRootElement(root);

        XMLOutputter outter = new XMLOutputter();
        outter.setFormat(Format.getPrettyFormat());
        outter.output(doc, new FileWriter(new File(basePath + "\\src\\configuracion\\xml_configuracion2.xml")));
    }

}
