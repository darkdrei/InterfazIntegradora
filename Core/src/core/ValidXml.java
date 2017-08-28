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
public class ValidXml implements Validacion {

    @Override
    public boolean exisFile(String ruta) {
        File xml_file = new File(ruta);
        return xml_file.isFile();
    }

    @Override
    public boolean validExtencion(File f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean validExtencion(String f){
        String[] dir = f.split("\\.");
        if (dir.length <2)
            return false;
        return dir[1].equalsIgnoreCase("xml")?true:false;
    }
    
}
