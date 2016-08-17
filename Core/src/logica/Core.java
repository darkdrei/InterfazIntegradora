/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author dark
 */
import bibliothek.gui.DockController;
import bibliothek.gui.dock.common.CContentArea;
import bibliothek.gui.dock.common.CControl;
import bibliothek.gui.dock.common.CGrid;
import bibliothek.gui.dock.common.DefaultSingleCDockable;
import bibliothek.gui.dock.common.action.CAction;
import bibliothek.gui.dock.common.intern.CDockable;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class Core
        extends JFrame {

    private BasePanel currentSelection;
    private CodePanel currentCode;
    private LectorArchivo lector_archivo;
    private JTree tree;
    public CargarArchivoArbol cargador_de_archivo;

    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException {
        DockController.disableCoreWarning();

        Core readme = new Core();
        readme.setDefaultCloseOperation(3);
        readme.setBounds(20, 20, 800, 600);
        readme.setVisible(true);
    }

    public Core()
            throws InstantiationException, IllegalAccessException {
        setTitle("Interfaz - Integradora");

        CControl control = new CControl(this);
        control.setTheme("eclipse");
        add(control.getContentArea());

        /*
         Agregar Menu
         */
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Archivo");
        menubar.add(menu);
        JMenuItem addComponente = new JMenuItem("Agregar Componente");
        menu.add(addComponente);
        JMenuItem deleteComponentes = new JMenuItem("Eliminar Componente");
        menu.add(deleteComponentes);

        JMenu componente = new JMenu("Componentes");
        menubar.add(componente);

        JMenu help = new JMenu("Help");
        menubar.add(help);
        JMenuItem acercade = new JMenuItem("Acerca de");
        help.add(acercade);

        setJMenuBar(menubar);
        addComponente.addActionListener(new ActionListener() {
            private int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });
        /**
         * **************************************
         */

        CGrid layout = new CGrid(control);

        /**
         * **********************************************************************
         */
        /*                  CODIGFO DE CARGADO DE ARCHIVO                        */
        lector_archivo = new LectorArchivo();
        DefaultSingleCDockable lectorSeleccionDockable = new DefaultSingleCDockable("selection", "Selection");
        lectorSeleccionDockable.setLayout(new BorderLayout());
        lectorSeleccionDockable.add(lector_archivo, BorderLayout.CENTER);
        lectorSeleccionDockable.setCloseable(false);
        layout.add(30, 0, 70, 100, lectorSeleccionDockable);
        /**
         * **********************************************************************
         */
        this.currentSelection = new BasePanel();
        DefaultSingleCDockable currentSelectionDockable = new DefaultSingleCDockable("selection", "Seleccion", new CAction[0]);
        currentSelectionDockable.setLayout(new BorderLayout());
        currentSelectionDockable.add(this.currentSelection, "Center");
        currentSelectionDockable.setCloseable(false);
        //layout.add(30.0D, 0.0D, 70.0D, 100.0D, new CDockable[] { currentSelectionDockable });

        this.currentCode = new CodePanel();
        DefaultSingleCDockable currentCodeDockable = new DefaultSingleCDockable("code", "Code", new CAction[0]);
        currentCodeDockable.setLayout(new BorderLayout());
        currentCodeDockable.add(this.currentCode.toComponent(), "Center");
        currentCodeDockable.setCloseable(false);
        if (!control.getController().isRestrictedEnvironment()) {
            currentCodeDockable.addAction(new CopyCodeAction(this.currentCode));
        }
        layout.add(30.0D, 0.0D, 70.0D, 100.0D, new CDockable[]{currentCodeDockable});
        //layout.select(30.0D, 0.0D, 70.0D, 100.0D, currentSelectionDockable);
        /**
         * **********************************************************************
         */
        // Construccion del arbol
        DefaultMutableTreeNode abuelo = new DefaultMutableTreeNode("Archivo");
        DefaultTreeModel modelo = new DefaultTreeModel(abuelo);
        tree = new JTree(modelo);
        // Construccion de los datos del arbol
        /**
         * **********************************************************************
         */

        /*final JTree tutorialsTree = new JTree(new ModelTree(RootSet.class, loadExtensions()));
         tutorialsTree.getSelectionModel().setSelectionMode(0);
         tutorialsTree.setShowsRootHandles(true);
         tutorialsTree.setRootVisible(false);
         tutorialsTree.addTreeSelectionListener(new TreeSelectionListener()
         {
         public void valueChanged(TreeSelectionEvent e)
         {
         TreePath path = tutorialsTree.getSelectionPath();
         if (path == null) {
         Core.this.select(null);
         } else {
         Core.this.select((ModelTree.Node)path.getLastPathComponent());
         }
         }
         });
         tutorialsTree.setSelectionRow(0);*/
        DefaultSingleCDockable listDockable = new DefaultSingleCDockable("list", "Tutorials", new CAction[0]);
        listDockable.setLayout(new BorderLayout());
        //listDockable.add(new JScrollPane(tutorialsTree), "Center");
        listDockable.add(new JScrollPane(tree), "Center");

        listDockable.setCloseable(false);
        //listDockable.addAction(new CopyCodeAction(this.currentCode));
        cargador_de_archivo = new CargarArchivoArbol(this);
        listDockable.addAction(cargador_de_archivo);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                TreePath path = tree.getSelectionPath();
                System.err.println(path.toString());
                System.err.println(path.getPathComponent(path.getPath().length - 1).toString());
                System.out.println("COnponente es .... " + path.getPathComponent(path.getPath().length - 1).toString());
                DesArbol desc = cargador_de_archivo.getNodo(path.getPathComponent(path.getPath().length - 1).toString());
                try {
                    if (cargador_de_archivo.validarExistencia(desc.getNombre())) {
                        currentCode.setCode(cargador_de_archivo.producirContenido(desc));
                    }
                } catch (NullPointerException er) {
                    currentCode.setCode("");
                }
            }
        });
        layout.add(0.0D, 0.0D, 30.0D, 100.0D, new CDockable[]{listDockable});

        control.getContentArea().deploy(layout);
        /**
         * * CARGAR EN CODE **
         */

    }

    public JTree getTree() {
        return tree;
    }

    public void setTree(JTree tree) {
        this.tree = tree;
    }

    private Set<Extension> loadExtensions() {
        Set<Extension> set = new HashSet();
        try {
            Class<?> clazz = Class.forName("TutorialToolbarExtension");
            set.add((Extension) clazz.newInstance());
        } catch (Exception e) {
        }
        return set;
    }

    private void select(ModelTree.Node node) {
        if (node == null) {
            this.currentSelection.set(null, null, null, null);
        } else {
            try {
                this.currentSelection.set(node.getTitle(), node.getDescription(), node.getImage(), node.getMainClass());
                this.currentCode.setCode(node.getCode());
            } catch (IOException e) {
                e.printStackTrace();
                this.currentCode.setCode("");
            }
        }
    }
}
