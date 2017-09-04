/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.data;

import java.io.File;
import java.util.Arrays;
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
        ZipUtils.extract(new File("/home/dark/proyectos/Modulos_test/Modulo1.zip") , new File("/home/dark/Escritorio/Desde-Java"));
//        Vector<Integer> t = new Vector<>();
//        t.add(1);
//        t.add(1);
//        t.add(1);
//        t.add(1);
//        t.add(1);
//        t.add(1);
//        t.add(1);
//        Object v[] = getvector(3);
//        System.err.println(Arrays.asList(t).get(0).toArray());
//        if (v instanceof String[]){
//            System.err.println("Es una cadena "+((String[])v));
//            String r[] = (String[])v;
//            for (String r1 : r) {
//                System.err.println(r1);
//            }
//        }else if (v instanceof Integer[]){
//            System.err.println("Es un entero"+((Integer[])v));
//            Integer r[] = (Integer[])v;
//            for (int r1 : r) {
//                System.err.println(r1);
//            }
//        }else if (v instanceof Boolean[]){
//            System.err.println("Es una boleano  "+((Boolean[])v));
//            Boolean r[] = (Boolean[])v;
//            for (boolean r1 : r) {
//                System.err.println(r1);
//            }
//        }
    }
    
    
    public static Object[] getvector(int x){
        if (x== 1){
            return new String[]{"dssdsd","dssdsd","dssdsd","dssdsd","dssdsd","dssdsd"};
        }else  if (x== 2){
            System.err.println("entro en 2");
            return new Integer[]{1,1,1,1,1,1,2,1,1};
        }else  if (x== 3){
            return new Boolean[]{true,false,true,false,true};
        }
        return null;
    }
}
