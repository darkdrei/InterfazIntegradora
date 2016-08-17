/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author dark
 */
public class Ventana2 extends JFrame {

    private JTextArea areaTexto;

    public Ventana2() {
        super("Ventana de layout");
        this.getContentPane().setLayout(new GridBagLayout());
        JLabel titulo = new JLabel() {
            @Override
            public void updateUI() {
                setFont(null);
                super.updateUI();
                setFont(getFont().deriveFont(32f));
            }
        };
        titulo.setText("Cargado de Componentes");
        GridBagConstraints constrain = new GridBagConstraints();
        //this.getContentPane().add(titulo, new GridBagConstraints(1, 0, 4, 1, 0, 0, 0, 0, null, 0, 0));
        // El titulo de la pantalla
        GridBagConstraints constraints = new GridBagConstraints();
        // JButton boton1 = new JButton("Boton 1");
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        /*constraints.weighty=1;
        constraints.anchor =GridBagConstraints.NORTH;*/
        constraints.fill =GridBagConstraints.NONE;
        this.getContentPane().add(titulo, constraints);
        constraints.weighty=0;
        constraints.weightx=0;
        constraints.anchor =GridBagConstraints.NORTH;
        constraints.fill =GridBagConstraints.NONE;
        
        //Label para q no se desborde
        // El titulo contenido de area
        JLabel desborde = new JLabel("              ");
        //JScrollPane scrollPane = new JScrollPane(area); 
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 3;
        constraints.weightx = 0;
        constraints.weighty =0;
        //constraints.weighty=1;
        constraints.anchor =GridBagConstraints.NORTH;
        constraints.fill =GridBagConstraints.NONE;
        this.getContentPane().add(desborde, constraints);
        constraints.weighty=0;
        constraints.weightx=1;
        constraints.anchor =GridBagConstraints.NORTH;
        constraints.fill =GridBagConstraints.NONE;
        
        // El titulo contenido de area
        JTextArea area = new JTextArea("Area de cargado del archivo");
        area.setSize(30,30);
        JScrollPane scrollPane = new JScrollPane(area); 
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 2;
        constraints.weighty =2;
        /*constraints.weighty=1;
        constraints.anchor =GridBagConstraints.NORTH;*/
        constraints.fill =GridBagConstraints.BOTH;
        this.getContentPane().add(area, constraints);
        constraints.weighty=0;
        constraints.weightx=0;
        constraints.anchor =GridBagConstraints.NORTH;
        constraints.fill =GridBagConstraints.NONE;
        
        //Boton de cargar archivo
        JButton cargar = new JButton("Cargar Archivo");
        constraints.gridx = 4;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        /*constraints.weighty=1;
        constraints.anchor =GridBagConstraints.NORTH;*/
        constraints.fill =GridBagConstraints.FIRST_LINE_END;
        constraints.anchor = GridBagConstraints.NORTHEAST;
        this.getContentPane().add(cargar, constraints);
        constraints.weighty=0;
        constraints.weightx=0;
        constraints.anchor =GridBagConstraints.NORTH;
        constraints.fill =GridBagConstraints.NONE;
        
        
        //Boton de cargar archivo
        JButton cancelar = new JButton("Cancelar");
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx=1;
        constraints.anchor =GridBagConstraints.LINE_END;
        constraints.fill =GridBagConstraints.NONE;
        this.getContentPane().add(cancelar, constraints);
        constraints.weighty=0;
        constraints.weightx=0;
        constraints.anchor =GridBagConstraints.NORTH;
        constraints.fill =GridBagConstraints.NONE;
        
        
        //Boton de cargar archivo
        JButton aceptar = new JButton("Aceptar");
        constraints.gridx = 3;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        //constraints.weighty=1;
        constraints.anchor =GridBagConstraints.EAST;
        constraints.fill =GridBagConstraints.NONE;
        this.getContentPane().add(aceptar, constraints);
        constraints.weighty=0;
        constraints.weightx=0;
        constraints.anchor =GridBagConstraints.NORTH;
        constraints.fill =GridBagConstraints.NONE;
        
        //areaTexto = new JTextArea("Area de texto");
        //this.getContentPane().add(areaTexto);
        /*Se define la posicion en las filas que se requieren para colocar el elemento*/
        /*GridBagConstraints constrain = new GridBagConstraints();
        constrain.gridx = 0; // El área de texto empieza en la columna cero.
        constrain.gridy = 0; // El área de texto empieza en la fila cero
        constrain.gridwidth = 2; // El área de texto ocupa dos columnas.
        constrain.gridheight = 2; // El área de texto ocupa 2 filas.
        constrain.weighty =1;
        constrain.fill = GridBagConstraints.BOTH;
        this.getContentPane().add(areaTexto, constrain);
        GridBagConstraints constraints = new GridBagConstraints();
        JButton boton1 = new JButton("Boton 1");
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty=1;
        constraints.anchor =GridBagConstraints.NORTH;
        constraints.fill =GridBagConstraints.NONE;
        this.getContentPane().add(boton1, constraints);
        constraints.weighty=0;
        constraints.anchor = GridBagConstraints.CENTER;
        
        JButton boton2 = new JButton("Boton 2");
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty=1;
        constraints.anchor = GridBagConstraints.NORTH;
        this.getContentPane().add(boton2, constraints);
        constraints.weighty=0;
        constraints.anchor = GridBagConstraints.CENTER;
        
        
        JButton boton3 = new JButton("Boton 3");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.getContentPane().add(boton3, constraints);

        
        JButton boton4 = new JButton("Boton 4");
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.getContentPane().add(boton4, constraints);

        
        JTextField campoTexto = new JTextField("Campo texto");
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx=1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        th-is.getContentPane().add(campoTexto, constraints);*/
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        JFrame.setDefaultLookAndFeelDecorated(true);
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Ventana2 p = new Ventana2();
                p.setSize(300, 300);
                p.setLocationRelativeTo(null);
                p.setVisible(true);
            }
        });
    }

}

