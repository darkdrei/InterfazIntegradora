/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.File;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author dark
 */
public class ComponenXml implements OperacionFIle{
    private SAXBuilder builder;
    private File file;
    private Document document;
    private Element rootNode;
    private Xml xml;

    public ComponenXml() {
        this.builder = new SAXBuilder();
        this.file = null;
        this.document = null;
        this.rootNode = null;
        xml = new Xml();
    }

    @Override
    public File loadFile(String ruta) {
        return (new File(ruta));
    }

    @Override
    public void loadingFile(String ruta) {
        this.setFile(loadFile(ruta));
    }

    public SAXBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(SAXBuilder builder) {
        this.builder = builder;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Element getRootNode() {
        return rootNode;
    }

    public void setRootNode(Element rootNode) {
        this.rootNode = rootNode;
    }

    @Override
    public void readNodeFile(File f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Xml getXml() {
        return xml;
    }

    public void setXml(Xml xml) {
        this.xml = xml;
    }

    @Override
    public void readNodeFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void extraerInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeFile(String ruta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeFile(String ruta, Xml xml) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}