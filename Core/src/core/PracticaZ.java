/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 *
 * @author dark
 */
public class PracticaZ {
    static ZipFile zf;
    static String FILE_NAME;
    static String OUTPUT_DIR ;
    static  int BUFFER_SIZE ;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        zf = new ZipFile("/home/dark/Escritorio/archivo1.zip");
        FILE_NAME = "/home/dark/Escritorio/archivo1.zip";
        OUTPUT_DIR = "/home/dark/Escritorio/Desde-Java/";
        BUFFER_SIZE = 8192;
        ZipFile file = new ZipFile(FILE_NAME);
        System.out.println("Iterating over zip file : " + FILE_NAME);
        System.err.println("elementos en el ");
        System.err.println("Nombre directo desde el archivo : "+zf.getName());
        try {
            final Enumeration<? extends ZipEntry> entries = file.entries();
            System.err.println("Tamaño de los archivos en el zip "+file.stream().count());
            while (entries.hasMoreElements()) {
                final ZipEntry entry = entries.nextElement();
                System.out.printf("File: %s Size %d  Modified on %TD %n", entry.getName(), entry.getSize(), new Date(entry.getTime()));
                System.err.println("La extencion del archivo es "+(entry.getName().split("\\.")[1]));
                extractEntry(entry, file.getInputStream(entry));
            }
            System.out.printf("Zip file  extracted successfully in %s",  OUTPUT_DIR);
        } finally {
            file.close();
        } 
    }
    
    private static void extractEntry(ZipEntry entry, InputStream is) throws IOException {
        String exractedFile = OUTPUT_DIR + entry.getName();
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(exractedFile);
            final byte[] buf = new byte[BUFFER_SIZE];
            int read = 0;
            int length;

            while ((length = is.read(buf, 0, buf.length)) >= 0) {
                fos.write(buf, 0, length);
            }

        } catch (IOException ioex) {
            fos.close();
        }

    }

}
