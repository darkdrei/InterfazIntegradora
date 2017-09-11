/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;

/**
 *
 * @author dark
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Zip z = new Zip();
        //Object[] r = z.validarArchivoGrup(new File("/home/dark/Documentos/Elion_unificados.zip"));
        Object[] r = z.validarArchivoGrup(new File("/home/dark/proyectos/Modulos_test/Modulo1.zip"));
        System.out.println(r[0]+"    ");
        
    }

}
