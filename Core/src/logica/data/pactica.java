/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.data;

import java.util.Vector;

/**
 *
 * @author dark
 */
public class pactica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vector<Object> t = new Vector<>();
        t.add(1);
        t.add(1);
        t.add(1);
        t.add(1);
        t.add(1);
        t.add(1);
        t.add(1);
        Object v[] = getvector(1);
        if (v instanceof String[]){
            System.err.println("Es una cadena");
        }else if (v instanceof Integer[]){
            System.err.println("Es un entero");
        }else if (v instanceof Boolean[]){
            System.err.println("Es una boleano");
        }
    }
    
    
    public static Object[] getvector(int x){
        if (x== 1){
            return new String[]{};
        }else  if (x== 2){
            return new Integer[]{};
        }else  if (x== 3){
            return new Boolean[]{};
        }
        return null;
    }
}
