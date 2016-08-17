/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.File;

/**
 *
 * @author dark
 */
public class utileria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File archivo = new File("/home/dark/Escritorio/aaaaaaaaaaa/a3");
        if (!archivo.exists())
            archivo.mkdir();
    }
    
}
