/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author dark
 */
public class Xml implements Cloneable{
    private Autor autor;
    private Cuerpo cuerpo;

    public Xml(Autor autor, Cuerpo cuerpo) {
        this.autor = autor;
        this.cuerpo = cuerpo;
    }
    
    public Xml() {
        this.autor = new Autor();
        this.cuerpo = new Cuerpo();
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Cuerpo getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(Cuerpo cuerpo) {
        this.cuerpo = cuerpo;
    }
    
    public ArrayList<String> getParametros(){
        return this.getCuerpo().getParametros();
    }
    public void addParametro(String parametro){
        this.getCuerpo().getParametros().add(parametro);
    }
    
    public class Autor{
        private String nombre;
        private String descripcion;
        private String version;

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public Autor(String nombre, String descripcion, String version) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.version = version;
        }
        
        public Autor() {
            this.nombre = "";
            this.descripcion = "";
            this.version = "";
        }
        

        @Override
        public String toString() {
            return "Autor{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", version=" + version + '}';
        }
        
        

    }
    
    public class Cuerpo{
        private String[] tipo_datos;
        private int columnas;
        private ArrayList<String> parametros;
        private String main;

        public Cuerpo(String[] tipo_datos, int columnas, ArrayList<String> parametros, String main) {
            this.tipo_datos = tipo_datos;
            this.columnas = columnas;
            this.parametros = parametros;
            this.main = main;
        }
        
        public Cuerpo() {
            this.tipo_datos = new String[10];
            this.columnas = 0;
            this.parametros = new ArrayList<>();
            this.main = "";
        }

        public String[] getTipo_datos() {
            return tipo_datos;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public void setTipo_datos(String[] tipo_datos) {
            this.tipo_datos = tipo_datos;
        }

        public int getColumnas() {
            return columnas;
        }

        public void setColumnas(int columnas) {
            this.columnas = columnas;
        }

        public ArrayList<String> getParametros() {
            return parametros;
        }

        public void setParametros(ArrayList<String> parametros) {
            this.parametros = parametros;
        }

        @Override
        public String toString() {
            return "Cuerpo{" + "tipo_datos=" + tipo_datos + ", columnas=" + columnas + ", parametros=" + parametros + '}';
        } 
        
    }

    @Override
    public String toString() {
        return "Xml{" + "autor=" + autor + ", cuerpo=" + cuerpo + '}';
    }
    
    
}
