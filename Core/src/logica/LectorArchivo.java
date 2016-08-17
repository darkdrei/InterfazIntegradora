/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author dark
 */
public class LectorArchivo extends JPanel implements ActionListener {

    private JLabel titulo;
    private JTextPane descripcion;
    private JButton cargar;
    private JButton cancelar ;
    private JButton aceptar;
    private JTextArea area ;

    public LectorArchivo() {
        this.setLayout(new GridBagLayout());
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
        this.add(titulo, constraints);
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
        this.add(desborde, constraints);
        constraints.weighty=0;
        constraints.weightx=1;
        constraints.anchor =GridBagConstraints.NORTH;
        constraints.fill =GridBagConstraints.NONE;
        
        // El titulo contenido de area
        area = new JTextArea("Area de cargado del archivo");
        area.setSize(30,30);
        JScrollPane scrollPane = new JScrollPane(area); 
        constraints.fill =GridBagConstraints.BOTH;
        //this.add(area, constraints);
        add( area, new GridBagConstraints( 2, 1, 2, 1, 1.0, 1.0, 
				GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,
				new Insets( 0, 0, 0, 0 ), 0, 0 ));
        
        constraints.weighty=0;
        constraints.weightx=0;
        constraints.anchor =GridBagConstraints.NORTH;
        constraints.fill =GridBagConstraints.NONE;
        
        //Boton de cargar archivo
        cargar = new JButton("Cargar Archivo");
        cargar.addActionListener(this);
        constraints.gridx = 4;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        /*constraints.weighty=1;
        constraints.anchor =GridBagConstraints.NORTH;*/
        constraints.fill =GridBagConstraints.FIRST_LINE_END;
        constraints.anchor = GridBagConstraints.NORTHEAST;
        //this.add(cargar, constraints);
        constraints.weighty=0;
        constraints.weightx=0;
        constraints.anchor =GridBagConstraints.NORTH;
        constraints.fill =GridBagConstraints.NONE;
        add( cargar, new GridBagConstraints( 4, 1, 1, 1, 0, 0, 
				GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NORTHEAST,
				new Insets( 0, 0, 0, 0 ), 0, 0 ));
        
        //Boton de cargar archivo
        cancelar = new JButton("Cancelar");
        cancelar.addActionListener(this);
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx=1;
        constraints.anchor =GridBagConstraints.LINE_END;
        constraints.fill =GridBagConstraints.NONE;
        this.add(cancelar,constraints);
        constraints.weighty=0;
        constraints.weightx=0;
        constraints.anchor =GridBagConstraints.NORTH;
        constraints.fill =GridBagConstraints.NONE;
        JLabel desborde2 = new JLabel("              ");
        add( desborde2, new GridBagConstraints( 4, 2, 1, 1, 0, 0, 
				GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NORTH,
				new Insets( 0, 0, 0, 0 ), 0, 0 ));
        
        //Boton de cargar archivo
        aceptar = new JButton("Aceptar");
        aceptar.addActionListener(this);
        constraints.gridx = 3;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        //constraints.weighty=1;
        constraints.anchor =GridBagConstraints.EAST;
        constraints.fill =GridBagConstraints.NONE;
        constraints.weighty=0;
        constraints.weightx=0;
        constraints.anchor =GridBagConstraints.NORTH;
        constraints.fill =GridBagConstraints.NONE;
        this.add(aceptar,constraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == aceptar){
            System.err.println("precionar aceptar");
        }else if(e.getSource() == cancelar){
            System.err.println("precionar cancelar");
        }else if(e.getSource() == cargar){
            System.err.println("precionar Cargar");
            JFileChooser f = new JFileChooser();     
            FileNameExtensionFilter filter = new FileNameExtensionFilter("zip & ZIP", "zip");
            f.setFileFilter(filter); 
            int op = f.showOpenDialog(f);      
            if(op == JFileChooser.APPROVE_OPTION){
                System.err.println("El archivo es aceptado");
                Zip z = new Zip();
                Object []r =z.validarArchivoGrup(f.getSelectedFile());
                if (((boolean)r[0])){
                    area.setText(((String)r[1]));
                }else{
                    z.getsFiles(f.getSelectedFile());
                    File xml = z.getContenidoTipo(1);
                    for (int i = 0; i < z.getFiles().size(); i++) {
                        System.out.println(z.getFiles().get(i).toString());
                    }
                    System.out.println(xml);
                }
                
            }else{
                JOptionPane.showMessageDialog(null,"Cargado de archivo","La extensión debe ser ZIP.",JOptionPane.INFORMATION_MESSAGE);
           }
        }
    }

}
