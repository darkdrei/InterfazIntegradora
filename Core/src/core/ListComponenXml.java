/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;

/**
 *
 * @author dark
 */
public class ListComponenXml extends ComponenXml{
    
    private ArrayList<Xml> xmls;
    
     public ListComponenXml() {
        super();
        xmls = new ArrayList<>();
    }

    @Override
    public void readNodeFile() {
        try {
            this.setDocument((Document) this.getBuilder().build(this.getFile()));
            this.setRootNode(this.getDocument().getRootElement());
            List list = (List) this.getRootNode().getChildren();
            for (Object object : list) {
                Element tem = (Element)object;
                this.setXml(new Xml());
                for(Element ob:tem.getChildren()){
                    System.out.println(ob.getName());
                    if (ob.getName().equalsIgnoreCase("autor")) {
                        try {
                            this.getXml().getAutor().setNombre(ob.getChild("nombre").getText());
                        } catch (NullPointerException r) {
                            this.getXml().getAutor().setNombre("");
                        }
                        try {
                            this.getXml().getAutor().setDescripcion(ob.getChild("descripcion").getText());
                        } catch (NullPointerException r) {
                            this.getXml().getAutor().setDescripcion("");
                        }
                        try {
                            this.getXml().getAutor().setVersion(ob.getChild("version").getText());
                        } catch (NullPointerException r) {
                            this.getXml().getAutor().setVersion("");
                        }
                    } else if (ob.getName().equalsIgnoreCase("cuerpo")) {
                        try {
                            Element tipo = ob.getChild("tipo");
                            this.getXml().getCuerpo().setColumnas(Integer.parseInt(tipo.getAttribute("columnas").getValue()));
                            this.getXml().getCuerpo().setTipo_datos(tipo.getAttribute("tipodatocolumna").getValue().split(","));
                        } catch (NullPointerException r) {
                            this.getXml().getCuerpo().setColumnas(0);
                            this.getXml().getCuerpo().setTipo_datos(new String[]{});
                        }catch(NumberFormatException n){
                            this.getXml().getCuerpo().setColumnas(0);
                            this.getXml().getCuerpo().setTipo_datos(new String[]{});
                        }
                        try {
                            Element tipo = ob.getChild("claseprincipal");
                            this.getXml().getCuerpo().setMain(ob.getChild("claseprincipal").getValue());
                        } catch (NullPointerException r) {
                            this.getXml().getCuerpo().setMain("");
                        }
                        ArrayList<String> parametros = new ArrayList<>();
                        try {
                            System.out.println("***************  "+ob.getChild("parametro"));
                            Element param= ob.getChild("parametro");
                            for (Element e : param.getChildren()) {
                                System.out.println(e.getName());
                                try {
                                    System.out.println(e.getName());
                                    parametros.add(e.getName());
                                } catch (NullPointerException r) {
                                    System.err.println("Se exploto");
                                }
                            }
                        } catch (NullPointerException r) {

                        }finally{
                            this.getXml().getCuerpo().setParametros(parametros);
                        }
                    }
                }
                this.getXmls().add(this.getXml());
            }

        } catch (JDOMException ex) {
            Logger.getLogger(LectorXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LectorXml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void readFile(Xml xml){
        try {
            this.setDocument((Document) this.getBuilder().build(this.getFile()));
            this.setRootNode(this.getDocument().getRootElement());
            List list = (List) this.getRootNode().getChildren();
            for (Object object : list) {
                Element tem = (Element)object;
                this.setXml(new Xml());
                for(Element ob:tem.getChildren()){
                    System.out.println(ob.getName());
                    if (ob.getName().equalsIgnoreCase("autor")) {
                        try {
                            this.getXml().getAutor().setNombre(ob.getChild("nombre").getText());
                        } catch (NullPointerException r) {
                            this.getXml().getAutor().setNombre("");
                        }
                        try {
                            this.getXml().getAutor().setDescripcion(ob.getChild("descripcion").getText());
                        } catch (NullPointerException r) {
                            this.getXml().getAutor().setDescripcion("");
                        }
                        try {
                            this.getXml().getAutor().setVersion(ob.getChild("version").getText());
                        } catch (NullPointerException r) {
                            this.getXml().getAutor().setVersion("");
                        }
                    } else if (ob.getName().equalsIgnoreCase("cuerpo")) {
                        try {
                            Element tipo = ob.getChild("tipo");
                            this.getXml().getCuerpo().setColumnas(Integer.parseInt(tipo.getAttribute("columnas").getValue()));
                            this.getXml().getCuerpo().setTipo_datos(tipo.getAttribute("tipodatocolumna").getValue().split(","));
                        } catch (NullPointerException r) {
                            this.getXml().getCuerpo().setColumnas(0);
                            this.getXml().getCuerpo().setTipo_datos(new String[]{});
                        }catch(NumberFormatException n){
                            this.getXml().getCuerpo().setColumnas(0);
                            this.getXml().getCuerpo().setTipo_datos(new String[]{});
                        }
                        try {
                            Element tipo = ob.getChild("claseprincipal");
                            this.getXml().getCuerpo().setMain(ob.getChild("claseprincipal").getValue());
                        } catch (NullPointerException r) {
                            this.getXml().getCuerpo().setMain("");
                        }
                        ArrayList<String> parametros = new ArrayList<>();
                        try {
                            System.out.println("***************  "+ob.getChild("parametro"));
                            Element param= ob.getChild("parametro");
                            for (Element e : param.getChildren()) {
                                System.out.println(e.getName());
                                try {
                                    System.out.println(e.getName());
                                    parametros.add(e.getName());
                                } catch (NullPointerException r) {
                                    System.err.println("Se exploto");
                                }
                            }
                        } catch (NullPointerException r) {

                        }finally{
                            this.getXml().getCuerpo().setParametros(parametros);
                        }
                    }
                }
                this.xmls.add(this.getXml());
            }

        } catch (JDOMException ex) {
            Logger.getLogger(LectorXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LectorXml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void extraerInformacion() {
        
    }

    public ArrayList<Xml> getXmls() {
        return xmls;
    }

    public void setXmls(ArrayList<Xml> xmls) {
        this.xmls = xmls;
    }
    
    
}
