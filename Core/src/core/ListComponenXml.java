/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author dark
 */
public class ListComponenXml extends ComponenXml {

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
                Element tem = (Element) object;
                this.setXml(new Xml());
                for (Element ob : tem.getChildren()) {
                    //System.out.println(ob.getName());
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
                    } else if (ob.getName().equalsIgnoreCase("status")) {
                        try {
                            this.getXml().getStatus().setActive(Boolean.valueOf(ob.getAttribute("active").getValue()));
                        } catch (Exception e) {
                            this.getXml().getStatus().setActive(true);
                        }
                    } else if (ob.getName().equalsIgnoreCase("cuerpo")) {
                        try {
                            Element tipo = ob.getChild("tipo");
                            this.getXml().getCuerpo().setColumnas(Integer.parseInt(tipo.getAttribute("columnas").getValue()));
                            this.getXml().getCuerpo().setTipo_datos(tipo.getAttribute("tipodatocolumna").getValue().split(","));
                        } catch (NullPointerException r) {
                            this.getXml().getCuerpo().setColumnas(0);
                            this.getXml().getCuerpo().setTipo_datos(new String[]{});
                        } catch (NumberFormatException n) {
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
                            //System.out.println("***************  " + ob.getChild("parametro"));
                            Element param = ob.getChild("parametro");
                            for (Element e : param.getChildren()) {
                                //System.out.println(e.getName());
                                try {
                                    //System.out.println(e.getName());
                                    parametros.add(e.getName());
                                } catch (NullPointerException r) {
                                    System.err.println("Se exploto");
                                }
                            }
                        } catch (NullPointerException r) {

                        } finally {
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
    public void readFile(Xml xml) {
        try {
            this.setDocument((Document) this.getBuilder().build(this.getFile()));
            this.setRootNode(this.getDocument().getRootElement());
            List list = (List) this.getRootNode().getChildren();
            for (Object object : list) {
                Element tem = (Element) object;
                this.setXml(new Xml());
                for (Element ob : tem.getChildren()) {
                   // System.out.println(ob.getName());
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
                    } else if (ob.getName().equalsIgnoreCase("status")) {
                        try {
                            this.getXml().getStatus().setActive(Boolean.valueOf(ob.getAttribute("active").getValue()));
                        } catch (Exception e) {
                            this.getXml().getStatus().setActive(true);
                        }
                    } else if (ob.getName().equalsIgnoreCase("cuerpo")) {
                        try {
                            Element tipo = ob.getChild("tipo");
                            this.getXml().getCuerpo().setColumnas(Integer.parseInt(tipo.getAttribute("columnas").getValue()));
                            this.getXml().getCuerpo().setTipo_datos(tipo.getAttribute("tipodatocolumna").getValue().split(","));
                        } catch (NullPointerException r) {
                            this.getXml().getCuerpo().setColumnas(0);
                            this.getXml().getCuerpo().setTipo_datos(new String[]{});
                        } catch (NumberFormatException n) {
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
                            //System.out.println("***************  " + ob.getChild("parametro"));
                            Element param = ob.getChild("parametro");
                            for (Element e : param.getChildren()) {
                                //System.out.println(e.getName());
                                try {
                                   // System.out.println(e.getName());
                                    parametros.add(e.getName());
                                } catch (NullPointerException r) {
                                    System.err.println("Se exploto");
                                }
                            }
                        } catch (NullPointerException r) {

                        } finally {
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

    @Override
    public Xml getXmlById(int id) {
        for (Xml x : this.getXmls()) {
            if (x.getId() == id) {
                return x;
            }
        }
        return null;
    }
    
    @Override
    public int getPositionXmlById(int id) {
        int i=0;
        for (Xml x : this.getXmls()) {
            if (x.getId() == id) {
                return i;
            }
            i++;
        }
        return -1;
    }
    
    @Override
    public boolean xmlExist(int id) {
        for (Xml x : this.getXmls()) {
            if (x.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeXml(Xml xml) {
        this.getXmls().remove(xml);
        this.updateFile();
    }

    @Override
    public void removeXml() {
        this.updateFile();
    }

    @Override
    public void updateFile(ArrayList<Xml> xmls) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void updateFile(int position, Xml xml){
        this.getXmls().set(position, xml);
        this.updateFile();
    }


    @Override
    public void updateFile() {
        try {
            Element root = new Element("listado");
            Document document = new Document();
            for (Xml xml : this.getXmls()) {
                Element autor = new Element("autor");
                autor.addContent(new Element("nombre").setText(xml.getAutor().getNombre()));
                autor.addContent(new Element("descripcion").setText(xml.getAutor().getDescripcion()));
                autor.addContent(new Element("version").setText(xml.getAutor().getVersion()));
                Element cuerpo = new Element("cuerpo");
                Element tipo = new Element("tipo");
                Element status = new Element("status");
                tipo.setAttribute("columnas", "" + xml.getCuerpo().getColumnas());
                tipo.setAttribute("tipodatocolumna", String.join(",", xml.getCuerpo().getTipo_datos()));
                cuerpo.addContent(tipo);
                tipo.addContent(new Element("claseprincipal").setText(xml.getCuerpo().getMain()));
                status.setAttribute("active", String.valueOf(xml.getStatus().getActive()));
                Element parametro = new Element("parametro");
                for (String dato : xml.getCuerpo().getParametros()) {
                    parametro.addContent(new Element(dato));
                }
                cuerpo.addContent(parametro);
                Element pluguin = new Element("pluguin");
                pluguin.addContent(autor);
                pluguin.addContent(cuerpo);
                pluguin.addContent(status);
                root.addContent(pluguin);
            };
            document.setRootElement(root);
            XMLOutputter outter = new XMLOutputter();
            outter.setFormat(Format.getPrettyFormat());
            String basePath = new File("").getAbsolutePath();
            String ruta = basePath + "/src/configuracion/xml_configuracion.xml";
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                ruta = basePath + "\\src\\configuracion\\xml_configuracion.xml";
            }
            outter.output(document, new FileWriter(new File(ruta)));
        } catch (IOException ex) {
            Logger.getLogger(ListComponenXml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
