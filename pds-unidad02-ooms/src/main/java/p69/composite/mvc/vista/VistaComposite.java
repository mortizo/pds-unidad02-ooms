package p69.composite.mvc.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import p69.composite.Circulo;
import p69.composite.Dibujo;
import p69.composite.FiguraComponent;
import p69.composite.Linea;
import p69.composite.Texto;

/** Vista Swing del ejemplo MVC del patron Composite. */
public class VistaComposite extends JFrame {

    private static final Color AZUL = new Color(25, 55, 92);
    private static final Color DORADO = new Color(224, 168, 54);
    private static final Color FONDO = new Color(239, 243, 249);

    private final JTree arbol = new JTree(new DefaultMutableTreeNode("Composite"));
    private final LienzoComposite lienzo = new LienzoComposite();
    private final JTextArea salida = new JTextArea();
    private final JButton botonDibujar = crearBoton("Dibujar composicion", AZUL);
    private final JButton botonPeso = crearBoton("Calcular peso", DORADO.darker());
    private final JLabel etiquetaPeso = new JLabel("--- bytes", SwingConstants.CENTER);
    private final JLabel estado = new JLabel("Demostracion preparada");

    public VistaComposite() {
        super("Patron Composite | Demostracion MVC");
        configurarVentana();
        construirInterfaz();
    }

    public void alDibujar(ActionListener listener) {
        botonDibujar.addActionListener(listener);
    }

    public void alCalcularPeso(ActionListener listener) {
        botonPeso.addActionListener(listener);
    }

    public void mostrarComposicion(Dibujo dibujo, String descripcion) {
        arbol.setModel(new DefaultTreeModel(crearNodo(dibujo)));
        expandirArbol();
        lienzo.setDibujo(dibujo);
        salida.setText(descripcion);
        salida.setCaretPosition(0);
        estado.setText("Composicion dibujada correctamente");
    }

    public void mostrarPeso(int peso) {
        etiquetaPeso.setText(peso + " bytes");
        estado.setText("Peso calculado recursivamente: " + peso + " bytes");
    }

    private void configurarVentana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(980, 650));
        setSize(1120, 720);
        setLocationRelativeTo(null);
    }

    private void construirInterfaz() {
        JPanel contenido = new JPanel(new BorderLayout(0, 0));
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
        JLabel titulo = new JLabel("PATRON COMPOSITE");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 24));
        JLabel subtitulo = new JLabel(
                "Una jerarquia parte-todo tratada mediante una interfaz comun");
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
        zona.setBorder(new EmptyBorder(18, 18, 12, 18));

        configurarArbol();
        JScrollPane panelArbol = new JScrollPane(arbol);
        panelArbol.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(205, 214, 226)),
                " Jerarquia de componentes "));
        panelArbol.setMinimumSize(new Dimension(250, 400));

        salida.setEditable(false);
        salida.setFont(new Font("Monospaced", Font.PLAIN, 14));
        salida.setBackground(new Color(250, 251, 253));
        salida.setBorder(new EmptyBorder(16, 16, 16, 16));
        salida.setText("La salida textual aparecera al dibujar la composicion.");

        JTabbedPane pestanas = new JTabbedPane();
        pestanas.setFont(new Font("SansSerif", Font.BOLD, 13));
        pestanas.addTab("Lienzo grafico", new JScrollPane(lienzo));
        pestanas.addTab("Salida textual", new JScrollPane(salida));

        JSplitPane divisor = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                panelArbol, pestanas);
        divisor.setDividerLocation(285);
        divisor.setResizeWeight(0.25);
        divisor.setBorder(null);
        zona.add(divisor, BorderLayout.CENTER);
        return zona;
    }

    private JPanel crearBarraInferior() {
        JPanel barra = new JPanel(new BorderLayout());
        barra.setBackground(Color.WHITE);
        barra.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0,
                        new Color(210, 217, 228)),
                new EmptyBorder(12, 18, 12, 18)));

        estado.setForeground(new Color(80, 91, 108));
        estado.setFont(new Font("SansSerif", Font.PLAIN, 12));
        JPanel acciones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        acciones.setOpaque(false);
        acciones.add(botonPeso);
        acciones.add(botonDibujar);

        barra.add(estado, BorderLayout.CENTER);
        barra.add(acciones, BorderLayout.EAST);
        return barra;
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
                setIcon(null);
                setBorder(new EmptyBorder(2, 4, 2, 4));
                return this;
            }
        });
    }

    private DefaultMutableTreeNode crearNodo(FiguraComponent componente) {
        String tipo;
        if (componente instanceof Dibujo) {
            Dibujo dibujo = (Dibujo) componente;
            tipo = "Dibujo: " + dibujo.getNombre() + " [" + dibujo.getPeso() + "]";
        } else if (componente instanceof Linea) {
            tipo = "Linea [" + componente.getPeso() + "]";
        } else if (componente instanceof Circulo) {
            tipo = "Circulo [" + componente.getPeso() + "]";
        } else {
            tipo = "Texto: " + ((Texto) componente).getContenido()
                    + " [" + componente.getPeso() + "]";
        }

        DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(tipo);
        if (componente instanceof Dibujo) {
            for (FiguraComponent hijo : ((Dibujo) componente).getHijos()) {
                nodo.add(crearNodo(hijo));
            }
        }
        return nodo;
    }

    private void expandirArbol() {
        for (int fila = 0; fila < arbol.getRowCount(); fila++) {
            arbol.expandRow(fila);
        }
    }

    private static JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setFocusPainted(false);
        boton.setForeground(Color.WHITE);
        boton.setBackground(color);
        boton.setFont(new Font("SansSerif", Font.BOLD, 12));
        boton.setBorder(new EmptyBorder(10, 18, 10, 18));
        boton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        return boton;
    }
}
