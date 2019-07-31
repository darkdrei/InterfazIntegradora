/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import core.LectorXml;
import core.WriteComponenXml;
import core.Xml;
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
import logica.data.ZipUtils;

/**
 *
 * @author dark
 */
public class LectorArchivo extends JPanel implements ActionListener {

    private JLabel titulo;
    private JTextPane descripcion;
    private JButton cargar;
    private JButton cancelar;
    private JButton aceptar;
    private JTextArea area;
    private Xml xml;
    private File file_zip;

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
        constraints.fill = GridBagConstraints.NONE;
        this.add(titulo, constraints);
        constraints.weighty = 0;
        constraints.weightx = 0;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.NONE;

        //Label para q no se desborde
        // El titulo contenido de area
        JLabel desborde = new JLabel("              ");
        //JScrollPane scrollPane = new JScrollPane(area); 
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 3;
        constraints.weightx = 0;
        constraints.weighty = 0;
        //constraints.weighty=1;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.NONE;
        this.add(desborde, constraints);
        constraints.weighty = 0;
        constraints.weightx = 1;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.NONE;

        // El titulo contenido de area
        area = new JTextArea("Area de cargado del archivo");
        area.setSize(30, 30);
        JScrollPane scrollPane = new JScrollPane(area);
        constraints.fill = GridBagConstraints.BOTH;
        //this.add(area, constraints);
        add(area, new GridBagConstraints(2, 1, 2, 1, 1.0, 1.0,
                GridBagConstraints.FIRST_LINE_START, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

        constraints.weighty = 0;
        constraints.weightx = 0;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.NONE;

        //Boton de cargar archivo
        cargar = new JButton("Cargar Archivo");
        cargar.addActionListener(this);
        constraints.gridx = 4;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        /*constraints.weighty=1;
        constraints.anchor =GridBagConstraints.NORTH;*/
        constraints.fill = GridBagConstraints.FIRST_LINE_END;
        constraints.anchor = GridBagConstraints.NORTHEAST;
        //this.add(cargar, constraints);
        constraints.weighty = 0;
        constraints.weightx = 0;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.NONE;
        add(cargar, new GridBagConstraints(4, 1, 1, 1, 0, 0,
                GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NORTHEAST,
                new Insets(0, 0, 0, 0), 0, 0));

        //Boton de cargar archivo
        cancelar = new JButton("Cancelar");
        cancelar.addActionListener(this);
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.fill = GridBagConstraints.NONE;
        this.add(cancelar, constraints);
        constraints.weighty = 0;
        constraints.weightx = 0;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.NONE;
        JLabel desborde2 = new JLabel("              ");
        add(desborde2, new GridBagConstraints(4, 2, 1, 1, 0, 0,
                GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NORTH,
                new Insets(0, 0, 0, 0), 0, 0));

        //Boton de cargar archivo
        aceptar = new JButton("Aceptar");
        aceptar.addActionListener(this);
        constraints.gridx = 3;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        //constraints.weighty=1;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weighty = 0;
        constraints.weightx = 0;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.NONE;
        this.add(aceptar, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aceptar) {
            area.setText("precionar aceptar");
            if (xml != null) {
                WriteComponenXml write_xml = new WriteComponenXml();
//                OSValidator os = new OSValidator();
                String path = "../../temporal/";
//                if (os.getOS().equals("win")) {
//                    path = "/temporal/";
//                } else {
//                    path = "/temporal/";
//                }
                ZipUtils.extract(file_zip,new File(path));
                write_xml.writeFile("src/configuracion/xml_configuracion.xml", xml);
            } else {
                JOptionPane.showMessageDialog(this, "Debe cargar un modulo.", "Cargar Modulo", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == cancelar) {
            area.setText("precionar cancelar");
        } else if (e.getSource() == cargar) {
            area.setText("precionar Cargar");
            JFileChooser f = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("zip & ZIP", "zip");
            f.setFileFilter(filter);
            int op = f.showOpenDialog(f);
            if (op == JFileChooser.APPROVE_OPTION) {
                System.err.println("El archivo es aceptado");
                Zip z = new Zip();
                Object[] r = z.validarArchivoGrup(f.getSelectedFile());
                if (!((boolean) r[0])) {
                    area.setText(((String) r[1]));
                } else {
                    file_zip = f.getSelectedFile();
                    File[] files = z.getFiles(f.getSelectedFile());
                    System.out.println("Cantidad de archios --> " + files.length);
                    stop:
                    for (File arc : files) {
                        System.out.println("Nombre del archivo " + arc.getName() + "  " + arc.getName().split("\\.")[1].equals("xml"));
                        if (arc.getName().split("\\.")[1].equals("xml")) {
                            LectorXml read_xml = new LectorXml();
                            read_xml.setFile(arc);
                            read_xml.readNodeFile();
                            area.setText(read_xml.toString());
                            xml = read_xml.getXml();
                            break stop;
                        }
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Cargado de archivo", "La extensión debe ser ZIP.", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

}
