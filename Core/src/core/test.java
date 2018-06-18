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
        System.out.println(vxml.exisFile("src/configuracion/xml_integracion.xml"));
        System.out.println(vxml.validExtencion("src/configuracion/xml_integracion.xml"));
        l.loadingFile("src/configuracion/xml_integracion.xml");
        l.readNodeFile();
        System.out.println(l.getXml().toString());
        WriteComponenXml componen = new WriteComponenXml();
        //componen.writeFile("src/configuracion/xml_configuracion.xml",l.getXml());
        ListComponenXml list = new ListComponenXml();
        list.loadingFile("src/configuracion/xml_configuracion.xml");
        list.readNodeFile();
        System.out.println(list.getXmls().size());
        for(Xml xml:list.getXmls()){
            System.out.println(xml.toString());
        }//Test 7
        Xml get_xml = list.getXmlById(10);
        System.out.println("---------------////////////////---------------");
        System.out.println("Total element --> "+list.getXmls().size());
        list.removeXml(get_xml);
        System.out.println("Total element --> "+list.getXmls().size());
        list.removeXml();
    }
    
}
