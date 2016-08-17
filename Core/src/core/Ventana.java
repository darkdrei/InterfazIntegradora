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
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author dark
 */
public class Ventana extends JFrame {

    private JTextArea areaTexto;

    public Ventana() {
        super("Ventana de layout");
        this.getContentPane().setLayout(new GridBagLayout());
        areaTexto = new JTextArea("Area de texto");
        this.getContentPane().add(areaTexto);
        /*Se define la posicion en las filas que se requieren para colocar el elemento*/
        GridBagConstraints constrain = new GridBagConstraints();
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
        this.getContentPane().add(campoTexto, constraints);
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
                Ventana p = new Ventana();
                p.setSize(600, 600);
                p.setLocationRelativeTo(null);
                p.setVisible(true);
            }
        });
    }

}
