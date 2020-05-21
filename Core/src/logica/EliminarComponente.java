/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import core.LectorXml;
import core.ListComponenXml;
import core.ValidXml;
import core.WriteComponenXml;
import core.Xml;
import core.Xml.Status;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.text.TabableView;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author exile
 */
public class EliminarComponente extends javax.swing.JDialog implements ActionListener, TableModelListener{
    
    Object [][] data = null;
    String[] columNames = new String[3];
    LectorXml l = new LectorXml();
    ValidXml vxml = new ValidXml();
    OSValidator os;
    ListComponenXml list = new ListComponenXml();
    String path = "";
    String image_path = "";

    /**
     * Creates new form NewJDialog
     */
    public EliminarComponente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        listaDeComponentes();
        TextInformacion.setEditable(false);
    }
    
    private void listaDeComponentes(){
        columNames = new String[] {"Activado", "Nombre", "Descripción", "Versión", ""};
        if (os.getOS().equals("win")) {
            path = "src\\configuracion\\xml_configuracion.xml";
            image_path = "src\\ima\\delete.png";
        }else{
            path = "src/configuracion/xml_configuracion.xml";
            image_path = "/home/dark/Documents/Tesis-Plinio/InterfazIntegradora/Core/src/ima/delete.png";
            //jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ejemplo/delete.png"))); // NOI18N
        }
        System.out.println(image_path);
        boolean exisFile = vxml.exisFile(path);
        boolean validExtencion = vxml.validExtencion(path);
        TablaComponentes.setDefaultRenderer(Object.class, new Render());
        JButton btn_eliminar = new JButton("Eliminar");
        if (exisFile & validExtencion) {
            //WriteComponenXml componen = new WriteComponenXml();
            //componen.writeFile(path,l.getXml());
            list.loadingFile(path);
            list.readNodeFile();
            data = new Object[list.getXmls().size()][5];
            int i = 0;
            for (Xml x : list.getXmls()) {
                data[list.getXmls().indexOf(x)][0] = x.getStatus().getActive();
                data[list.getXmls().indexOf(x)][1] = x.getAutor().getNombre();
                data[list.getXmls().indexOf(x)][2] = x.getAutor().getDescripcion();
                data[list.getXmls().indexOf(x)][3] = x.getAutor().getVersion();
                data[list.getXmls().indexOf(x)][4] = btn_eliminar;
            }

        }else{
            JDialog d = new JDialog();
            d.setTitle("El archivo de configuracion ha sido alterado");
            d.setVisible(true);
        }
        TablaComponentes.setModel(new DefaultTableModel(data, columNames){
            @Override
            public boolean isCellEditable(int row, int column){
                if(column == 0){
                    return true;
                }
                return false;  
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return getValueAt(0, columnIndex).getClass();
            }
        });
        
        TablaComponentes.getModel().addTableModelListener(this);
        TablaComponentes.setRowHeight(20);
    }
    
    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        System.out.println(" x "+row+"  y "+column);
        TableModel model;
        model = (TableModel)e.getSource();
        Object response = model.getValueAt(row, column);
        Xml x =  list.getXmls().get(row);
        x.getStatus().setActive(Boolean.valueOf(response.toString()));
        WriteComponenXml wXml = new WriteComponenXml();
        wXml.writeFile(path, x);
        //JOptionPane.showMessageDialog(TablaComponentes, list.getXmls().get(row).getStatus());
//        ...// Do something with the data...
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaComponentes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextInformacion = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(254, 254, 254));

        jPanel2.setBackground(new java.awt.Color(228, 228, 228));

        TablaComponentes.setBorder(null);
        TablaComponentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Aplicado", "Nombre", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaComponentes.setToolTipText("");
        TablaComponentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaComponentesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaComponentes);

        TextInformacion.setColumns(20);
        TextInformacion.setRows(5);
        jScrollPane2.setViewportView(TextInformacion);

        jLabel1.setText("Información");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void TablaComponentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaComponentesMouseClicked
        // TODO add your handling code here:
        int selectedRow = TablaComponentes.getSelectedRow();
        int selectedColum = TablaComponentes.getSelectedColumn();
        String t = "Nombre: "+ list.getXmls().get(selectedRow).getAutor().getNombre() + "\n" 
                + "Descripción: " + list.getXmls().get(selectedRow).getAutor().getDescripcion() + "\n"
                + "Versión: " + list.getXmls().get(selectedRow).getAutor().getVersion() + "\n"
                + "Parametros: " + list.getXmls().get(selectedRow).getParametros().toString();
        TextInformacion.setText(t);
        
        Object[] opciones = {"NO", "YES, PLEASE"};
        
        if(selectedColum == 4){
            Object value = TablaComponentes.getValueAt(selectedRow, selectedColum);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                //int op_eliminar = JOptionPane.showConfirmDialog(this,"seguro que desea eliminar?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                int op_eliminar;
                op_eliminar = JOptionPane.showOptionDialog(null, 
                        "¿está seguro que desea eliminar el componente "+list.getXmls().get(selectedRow).getAutor().getNombre()+"?",
                        "Eliminacion de componente",
                        JOptionPane.YES_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, //do not use a custom Icon
                        opciones, //the titles of buttons
                        opciones[0]); //default button title
                if (JOptionPane.OK_OPTION != op_eliminar){
                    System.out.println("confirmado");
                    System.out.println("eliminando ---> " + list.getXmls().get(selectedRow));
                    list.removeXml(list.getXmls().get(selectedRow));
                    TextInformacion.setText("");
                    listaDeComponentes();
                }else{
                    System.out.println("cncelado");
                }
            }
        }        
    }//GEN-LAST:event_TablaComponentesMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaComponentes;
    private javax.swing.JTextArea TextInformacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public class Render extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        if(value instanceof JButton){
            JButton btn = (JButton)value;
            if(isSelected){
                btn.setForeground(table.getSelectionForeground());
        
      btn.setBackground(table.getSelectionBackground());
            }else{
                btn.setForeground(table.getForeground());
      btn.setBackground(UIManager.getColor("Button.background"));
            }
            return btn;
        }
        
        
        if(value instanceof JCheckBox){
            JCheckBox ch = (JCheckBox)value;
            return ch;
        }
        
        return super.getTableCellRendererComponent(table, value, isSelected, 
                hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }   
}
}