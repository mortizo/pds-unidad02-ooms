package p69.composite.mvc.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import p69.composite.Circulo;
import p69.composite.Dibujo;
import p69.composite.FiguraComponent;
import p69.composite.Linea;
import p69.composite.Texto;
import p69.composite.mvc.modelo.ModeloComposite.TipoComponente;

/** Vista Swing interactiva del ejemplo MVC del patron Composite. */
public class VistaComposite extends JFrame {

    private static final Color AZUL = new Color(25, 55, 92);
    private static final Color DORADO = new Color(224, 168, 54);
    private static final Color FONDO = new Color(239, 243, 249);

    private final JTree arbol = new JTree(new DefaultMutableTreeNode("Composite"));
    private final LienzoComposite lienzo = new LienzoComposite();
    private final JTextArea salida = new JTextArea();
    private final JComboBox<String> tipo = new JComboBox<>(new String[]{
        "Linea", "Circulo", "Texto", "Dibujo"
    });
    private final JTextField detalle = new JTextField();
    private final JSpinner peso = new JSpinner(
            new SpinnerNumberModel(100, 0, 100000, 10));
    private final JLabel etiquetaDetalle = new JLabel("Detalle");
    private final JLabel etiquetaPesoCampo = new JLabel("Peso (bytes)");
    private final JButton botonAgregar = crearBoton("Agregar", AZUL);
    private final JButton botonEliminar = crearBoton("Eliminar seleccionado",
            new Color(174, 63, 63));
    private final JLabel etiquetaPeso = new JLabel("--- bytes", SwingConstants.CENTER);
    private final JLabel estado = new JLabel("Editor preparado");

    public VistaComposite() {
        super("Patron Composite | Editor MVC interactivo");
        configurarVentana();
        construirInterfaz();
        configurarFormularioPorTipo();
    }

    public void alAgregar(ActionListener listener) {
        botonAgregar.addActionListener(listener);
    }

    public void alEliminar(ActionListener listener) {
        botonEliminar.addActionListener(listener);
    }

    public void alSeleccionar(TreeSelectionListener listener) {
        arbol.addTreeSelectionListener(listener);
    }

    public FiguraComponent getComponenteSeleccionado() {
        Object ultimo = arbol.getLastSelectedPathComponent();
        if (!(ultimo instanceof DefaultMutableTreeNode)) {
            return null;
        }
        Object valor = ((DefaultMutableTreeNode) ultimo).getUserObject();
        return valor instanceof FiguraComponent ? (FiguraComponent) valor : null;
    }

    public TipoComponente getTipoSeleccionado() {
        return TipoComponente.values()[tipo.getSelectedIndex()];
    }

    public String getDetalle() {
        return detalle.getText().trim();
    }

    public int getPeso() {
        return (Integer) peso.getValue();
    }

    public void mostrarComposicion(Dibujo dibujo, String descripcion,
            int pesoTotal, FiguraComponent seleccionar) {
        DefaultMutableTreeNode raiz = crearNodo(dibujo);
        arbol.setModel(new DefaultTreeModel(raiz));
        expandirArbol();
        seleccionarNodo(raiz, seleccionar);
        lienzo.setDibujo(dibujo);
        salida.setText(descripcion);
        salida.setCaretPosition(0);
        etiquetaPeso.setText(pesoTotal + " bytes");
    }

    public void configurarAcciones(boolean puedeAgregar, boolean puedeEliminar) {
        botonAgregar.setEnabled(puedeAgregar);
        botonEliminar.setEnabled(puedeEliminar);
    }

    public void limpiarFormulario() {
        detalle.setText("");
    }

    public void mostrarEstado(String mensaje) {
        estado.setText(mensaje);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Revise la operacion",
                JOptionPane.WARNING_MESSAGE);
    }

    public boolean confirmarEliminacion() {
        return JOptionPane.showConfirmDialog(this,
                "Se eliminara el componente seleccionado y todos sus hijos.\n"
                + "¿Desea continuar?", "Confirmar eliminacion",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)
                == JOptionPane.YES_OPTION;
    }

    private void configurarVentana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1080, 680));
        setSize(1220, 760);
        setLocationRelativeTo(null);
    }

    private void construirInterfaz() {
        JPanel contenido = new JPanel(new BorderLayout());
        contenido.setBackground(FONDO);
        contenido.add(crearEncabezado(), BorderLayout.NORTH);
        contenido.add(crearZonaCentral(), BorderLayout.CENTER);
        contenido.add(crearBarraInferior(), BorderLayout.SOUTH);
        setContentPane(contenido);
    }

    private JPanel crearEncabezado() {
        JPanel encabezado = new JPanel(new BorderLayout());
        encabezado.setBackground(AZUL);
        encabezado.setBorder(new EmptyBorder(18, 24, 18, 24));

        JPanel textos = new JPanel(new GridLayout(2, 1, 0, 4));
        textos.setOpaque(false);
        JLabel titulo = new JLabel("EDITOR INTERACTIVO - PATRON COMPOSITE");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 23));
        JLabel subtitulo = new JLabel(
                "Seleccione un dibujo, agregue componentes y observe la actualizacion recursiva");
        subtitulo.setForeground(new Color(205, 218, 236));
        subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        textos.add(titulo);
        textos.add(subtitulo);

        JPanel tarjetaPeso = new JPanel(new GridLayout(2, 1));
        tarjetaPeso.setBackground(new Color(38, 72, 111));
        tarjetaPeso.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(75, 111, 151)),
                new EmptyBorder(8, 18, 8, 18)));
        JLabel leyenda = new JLabel("PESO TOTAL", SwingConstants.CENTER);
        leyenda.setForeground(new Color(205, 218, 236));
        leyenda.setFont(new Font("SansSerif", Font.BOLD, 10));
        etiquetaPeso.setForeground(Color.WHITE);
        etiquetaPeso.setFont(new Font("SansSerif", Font.BOLD, 18));
        tarjetaPeso.add(leyenda);
        tarjetaPeso.add(etiquetaPeso);

        encabezado.add(textos, BorderLayout.CENTER);
        encabezado.add(tarjetaPeso, BorderLayout.EAST);
        return encabezado;
    }

    private Component crearZonaCentral() {
        JPanel zona = new JPanel(new BorderLayout());
        zona.setBackground(FONDO);
        zona.setBorder(new EmptyBorder(16, 16, 10, 16));

        JPanel lateral = new JPanel(new BorderLayout(0, 12));
        lateral.setOpaque(false);
        lateral.add(crearFormulario(), BorderLayout.NORTH);

        configurarArbol();
        JScrollPane panelArbol = new JScrollPane(arbol);
        panelArbol.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(205, 214, 226)),
                " Seleccione el dibujo destino "));
        lateral.add(panelArbol, BorderLayout.CENTER);
        lateral.setMinimumSize(new Dimension(315, 500));

        salida.setEditable(false);
        salida.setFont(new Font("Monospaced", Font.PLAIN, 14));
        salida.setBackground(new Color(250, 251, 253));
        salida.setBorder(new EmptyBorder(16, 16, 16, 16));

        JTabbedPane pestanas = new JTabbedPane();
        pestanas.setFont(new Font("SansSerif", Font.BOLD, 13));
        pestanas.addTab("Lienzo grafico", new JScrollPane(lienzo));
        pestanas.addTab("Salida textual", new JScrollPane(salida));

        JSplitPane divisor = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                lateral, pestanas);
        divisor.setDividerLocation(345);
        divisor.setResizeWeight(0.28);
        divisor.setBorder(null);
        zona.add(divisor, BorderLayout.CENTER);
        return zona;
    }

    private JPanel crearFormulario() {
        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setBackground(Color.WHITE);
        formulario.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(205, 214, 226)),
                new EmptyBorder(12, 14, 12, 14)));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(3, 3, 5, 3);

        JLabel titulo = new JLabel("NUEVO COMPONENTE");
        titulo.setForeground(AZUL);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 13));
        c.gridy = 0;
        formulario.add(titulo, c);

        c.gridy = 1;
        formulario.add(new JLabel("Tipo"), c);
        c.gridy = 2;
        formulario.add(tipo, c);
        c.gridy = 3;
        formulario.add(etiquetaDetalle, c);
        c.gridy = 4;
        formulario.add(detalle, c);
        c.gridy = 5;
        formulario.add(etiquetaPesoCampo, c);
        c.gridy = 6;
        formulario.add(peso, c);

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        botones.setOpaque(false);
        botones.add(botonEliminar);
        botones.add(botonAgregar);
        c.gridy = 7;
        c.insets = new Insets(9, 3, 1, 3);
        formulario.add(botones, c);

        tipo.addActionListener(evento -> configurarFormularioPorTipo());
        return formulario;
    }

    private JPanel crearBarraInferior() {
        JPanel barra = new JPanel(new BorderLayout());
        barra.setBackground(Color.WHITE);
        barra.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0,
                        new Color(210, 217, 228)),
                new EmptyBorder(10, 18, 10, 18)));
        estado.setForeground(new Color(80, 91, 108));
        estado.setFont(new Font("SansSerif", Font.PLAIN, 12));
        JLabel ayuda = new JLabel(
                "Los dibujos pueden contener hojas u otros dibujos");
        ayuda.setForeground(new Color(110, 119, 133));
        barra.add(estado, BorderLayout.WEST);
        barra.add(ayuda, BorderLayout.EAST);
        return barra;
    }

    private void configurarFormularioPorTipo() {
        TipoComponente seleccionado = getTipoSeleccionado();
        boolean usaDetalle = seleccionado == TipoComponente.TEXTO
                || seleccionado == TipoComponente.DIBUJO;
        boolean usaPeso = seleccionado != TipoComponente.DIBUJO;
        detalle.setEnabled(usaDetalle);
        etiquetaDetalle.setEnabled(usaDetalle);
        detalle.setToolTipText(seleccionado == TipoComponente.TEXTO
                ? "Contenido que se mostrara en el lienzo"
                : "Nombre del nuevo dibujo");
        etiquetaDetalle.setText(seleccionado == TipoComponente.TEXTO
                ? "Contenido" : seleccionado == TipoComponente.DIBUJO
                        ? "Nombre del dibujo" : "Detalle (no requerido)");
        peso.setEnabled(usaPeso);
        etiquetaPesoCampo.setEnabled(usaPeso);
        if (seleccionado == TipoComponente.LINEA) {
            peso.setValue(Linea.PESO_PREDETERMINADO);
        } else if (seleccionado == TipoComponente.CIRCULO) {
            peso.setValue(Circulo.PESO_PREDETERMINADO);
        } else if (seleccionado == TipoComponente.TEXTO) {
            peso.setValue(Texto.PESO_PREDETERMINADO);
        } else {
            peso.setValue(0);
        }
    }

    private void configurarArbol() {
        arbol.setRootVisible(true);
        arbol.setShowsRootHandles(true);
        arbol.setRowHeight(27);
        arbol.setBorder(new EmptyBorder(8, 8, 8, 8));
        arbol.setFont(new Font("SansSerif", Font.PLAIN, 13));
        arbol.setCellRenderer(new DefaultTreeCellRenderer() {
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value,
                    boolean selected, boolean expanded, boolean leaf, int row,
                    boolean hasFocus) {
                super.getTreeCellRendererComponent(tree, value, selected, expanded,
                        leaf, row, hasFocus);
                DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) value;
                Object objeto = nodo.getUserObject();
                if (objeto instanceof FiguraComponent) {
                    setText(formatear((FiguraComponent) objeto));
                }
                setIcon(null);
                setBorder(new EmptyBorder(2, 4, 2, 4));
                return this;
            }
        });
    }

    private DefaultMutableTreeNode crearNodo(FiguraComponent componente) {
        DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(componente);
        if (componente instanceof Dibujo) {
            for (FiguraComponent hijo : ((Dibujo) componente).getHijos()) {
                nodo.add(crearNodo(hijo));
            }
        }
        return nodo;
    }

    private String formatear(FiguraComponent componente) {
        if (componente instanceof Dibujo) {
            Dibujo dibujo = (Dibujo) componente;
            return "Dibujo: " + dibujo.getNombre() + " [" + dibujo.getPeso() + "]";
        }
        if (componente instanceof Linea) {
            return "Linea [" + componente.getPeso() + "]";
        }
        if (componente instanceof Circulo) {
            return "Circulo [" + componente.getPeso() + "]";
        }
        return "Texto: " + ((Texto) componente).getContenido()
                + " [" + componente.getPeso() + "]";
    }

    private void expandirArbol() {
        for (int fila = 0; fila < arbol.getRowCount(); fila++) {
            arbol.expandRow(fila);
        }
    }

    private void seleccionarNodo(DefaultMutableTreeNode raiz,
            FiguraComponent componente) {
        Enumeration<?> nodos = raiz.depthFirstEnumeration();
        while (nodos.hasMoreElements()) {
            DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) nodos.nextElement();
            if (nodo.getUserObject() == componente) {
                arbol.setSelectionPath(new TreePath(nodo.getPath()));
                arbol.scrollPathToVisible(new TreePath(nodo.getPath()));
                return;
            }
        }
        arbol.setSelectionRow(0);
    }

    private static JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setFocusPainted(false);
        boton.setForeground(Color.WHITE);
        boton.setBackground(color);
        boton.setFont(new Font("SansSerif", Font.BOLD, 12));
        boton.setBorder(new EmptyBorder(9, 13, 9, 13));
        boton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        return boton;
    }
}
