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
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.text.TabableView;

/**
 *
 * @author exile
 */
public class ListaComponentes extends javax.swing.JDialog implements  TableModelListener {

    Object[][] data = null;
    String[] columNames = new String[4];
    LectorXml l = new LectorXml();
    ValidXml vxml = new ValidXml();
    OSValidator os;
    ListComponenXml list = new ListComponenXml();
    String path = "";

    /**
     * Creates new form NewJDialog
     */
    public ListaComponentes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        listaDeComponentes();
        TextInformacion.setEditable(false);
        TablaComponentes.getModel().addTableModelListener(this);
    }

    private void listaDeComponentes() {
        columNames = new String[]{"Activado", "Nombre", "Descripción", "Versión"};
        if (os.getOS().equals("win")) {
            path = "src\\configuracion\\xml_configuracion.xml";
        } else {
            path = "src/configuracion/xml_configuracion.xml";
        }
        boolean exisFile = vxml.exisFile(path);
        boolean validExtencion = vxml.validExtencion(path);

        if (exisFile & validExtencion) {
            //WriteComponenXml componen = new WriteComponenXml();
            //componen.writeFile(path,l.getXml());
            list.loadingFile(path);
            list.readNodeFile();
            data = new Object[list.getXmls().size()][5];

            for (Xml x : list.getXmls()) {
                data[list.getXmls().indexOf(x)][0] = x.getStatus().getActive();
                data[list.getXmls().indexOf(x)][1] = x.getAutor().getNombre();
                data[list.getXmls().indexOf(x)][2] = x.getAutor().getDescripcion();
                data[list.getXmls().indexOf(x)][3] = x.getAutor().getVersion();
            }

        } else {
            JDialog d = new JDialog();
            d.setTitle("El archivo de configuracion ha sido alterado");
            d.setVisible(true);
        }

        TablaComponentes.setModel(new DefaultTableModel(data, columNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0;
            }
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return getValueAt(0, columnIndex).getClass();
            }

        });
        

        TablaComponentes.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            // do some actions here, for example
            // print first column value from selected row
            
            int selectedRow = TablaComponentes.getSelectedRow();
            
            String t = "Nombre: " + list.getXmls().get(selectedRow).getAutor().getNombre() + "\n"
                    + "Descripción: " + list.getXmls().get(selectedRow).getAutor().getDescripcion() + "\n"
                    + "Versión: " + list.getXmls().get(selectedRow).getAutor().getVersion() + "\n"
                    + "Parametros: " + list.getXmls().get(selectedRow).getParametros().toString();
            TextInformacion.setText(t);
        });
        
     
//        ButtonColumn buttonColumn = new ButtonColumn(TablaComponentes, 4);
        TableButton buttonEditor = new TableButton("Eliminar");
        buttonEditor.addTableButtonListener((int row, int col) -> {
            // do something
            System.out.println(col+".tableButtonClicked()"+row);
        });

        TableColumn col = new TableColumn(1, 80);
        col.setCellRenderer(buttonEditor);
        col.setCellEditor(buttonEditor);
        col.setHeaderValue("");
     
        TablaComponentes.addColumn(col);
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();

        TableModel model;
        model = (TableModel) e.getSource();
        Object response = model.getValueAt(row, column);
        Xml x = list.getXmls().get(row);
        x.getStatus().setActive(Boolean.valueOf(response.toString()));
        list.updateFile(row, x);
        String status = x.getStatus().getActive() ? "Activado" : "Desactivadado";
        JOptionPane.showMessageDialog(TablaComponentes,  "Componente "+status);
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

}

