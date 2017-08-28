/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author dark
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LectorXml l = new LectorXml();
        ValidXml vxml = new ValidXml();
        System.out.println(vxml.exisFile("/home/dark/proyectos/xml_integracion.xml"));
        System.out.println(vxml.validExtencion("/home/dark/proyectos/xml_integracion.xml"));
        l.loadingFile("/home/dark/proyectos/xml_integracion.xml");
        l.readNodeFile();
        System.out.println(l.getXml().toString());
        WriteComponenXml componen = new WriteComponenXml();
        componen.writeFile("/home/dark/proyectos/xml_configuracion.xml",l.getXml());
        ListComponenXml list = new ListComponenXml();
        list.loadingFile("/home/dark/proyectos/xml_configuracion.xml");
        list.readNodeFile();
        System.out.println(list.getXmls().size());
    }
    
}
