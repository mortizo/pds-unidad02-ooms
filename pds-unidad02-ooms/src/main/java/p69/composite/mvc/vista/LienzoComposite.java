package p69.composite.mvc.vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;
import p69.composite.Circulo;
import p69.composite.Dibujo;
import p69.composite.FiguraComponent;
import p69.composite.Linea;
import p69.composite.Texto;

/** Panel que representa graficamente la jerarquia Composite. */
public class LienzoComposite extends JPanel {

    private static final Color AZUL = new Color(25, 55, 92);
    private static final Color CELESTE = new Color(53, 126, 189);
    private static final Color DORADO = new Color(224, 168, 54);
    private static final Color CORAL = new Color(230, 111, 81);
    private static final Color FONDO = new Color(246, 248, 252);

    private Dibujo dibujo;

    public LienzoComposite() {
        setBackground(FONDO);
        setPreferredSize(new Dimension(760, 480));
    }

    public void setDibujo(Dibujo dibujo) {
        this.dibujo = dibujo;
        if (dibujo != null) {
            int ancho = Math.max(760, calcularAncho(dibujo) + 56);
            int alto = Math.max(480, calcularProfundidad(dibujo) * 150 + 130);
            setPreferredSize(new Dimension(ancho, alto));
            revalidate();
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2 = (Graphics2D) graphics.create();
        try {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            dibujarCuadricula(g2);
            if (dibujo == null) {
                dibujarMensajeInicial(g2);
                return;
            }

            int margen = 28;
            dibujarComponente(g2, dibujo, margen, 34,
                    Math.max(300, getWidth() - margen * 2),
                    Math.max(260, getHeight() - 68), 0);
        } finally {
            g2.dispose();
        }
    }

    private void dibujarCuadricula(Graphics2D g2) {
        g2.setColor(new Color(228, 233, 241));
        g2.setStroke(new BasicStroke(1f));
        for (int x = 0; x < getWidth(); x += 24) {
            g2.drawLine(x, 0, x, getHeight());
        }
        for (int y = 0; y < getHeight(); y += 24) {
            g2.drawLine(0, y, getWidth(), y);
        }
    }

    private void dibujarMensajeInicial(Graphics2D g2) {
        String mensaje = "Presione Dibujar composicion para iniciar";
        g2.setFont(new Font("SansSerif", Font.BOLD, 16));
        FontMetrics metrics = g2.getFontMetrics();
        int x = (getWidth() - metrics.stringWidth(mensaje)) / 2;
        int y = getHeight() / 2;
        g2.setColor(AZUL);
        g2.drawString(mensaje, Math.max(20, x), y);
    }

    private void dibujarComponente(Graphics2D g2, FiguraComponent componente,
            int x, int y, int ancho, int alto, int nivel) {
        if (componente instanceof Dibujo) {
            dibujarComposite(g2, (Dibujo) componente, x, y, ancho, alto, nivel);
        } else {
            dibujarHoja(g2, componente, x, y, ancho, alto);
        }
    }

    private void dibujarComposite(Graphics2D g2, Dibujo composite,
            int x, int y, int ancho, int alto, int nivel) {
        Color borde = nivel == 0 ? AZUL : CELESTE;
        g2.setColor(new Color(255, 255, 255, 225));
        g2.fill(new RoundRectangle2D.Double(x, y, ancho, alto, 20, 20));
        g2.setColor(borde);
        g2.setStroke(new BasicStroke(nivel == 0 ? 3f : 2f));
        g2.draw(new RoundRectangle2D.Double(x, y, ancho, alto, 20, 20));

        g2.setFont(new Font("SansSerif", Font.BOLD, nivel == 0 ? 16 : 13));
        g2.drawString(composite.getNombre() + " - " + composite.getPeso() + " bytes",
                x + 16, y + 24);

        int cantidad = composite.getHijos().size();
        if (cantidad == 0) {
            return;
        }

        int espacio = 10;
        int interiorX = x + 14;
        int interiorY = y + 38;
        int interiorAncho = ancho - 28;
        int interiorAlto = alto - 52;
        int anchoHijo = Math.max(90,
                (interiorAncho - espacio * (cantidad - 1)) / cantidad);

        for (int i = 0; i < cantidad; i++) {
            int hijoX = interiorX + i * (anchoHijo + espacio);
            int anchoDisponible = i == cantidad - 1
                    ? x + ancho - 14 - hijoX : anchoHijo;
            dibujarComponente(g2, composite.getHijos().get(i), hijoX,
                    interiorY, anchoDisponible, interiorAlto, nivel + 1);
        }
    }

    private void dibujarHoja(Graphics2D g2, FiguraComponent componente,
            int x, int y, int ancho, int alto) {
        int centroX = x + ancho / 2;
        int centroY = y + alto / 2;
        g2.setStroke(new BasicStroke(4f, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND));

        if (componente instanceof Linea) {
            g2.setColor(CELESTE);
            g2.draw(new Line2D.Double(x + 16, centroY, x + ancho - 16, centroY));
        } else if (componente instanceof Circulo) {
            int diametro = Math.max(24, Math.min(ancho - 28, alto - 54));
            g2.setColor(new Color(230, 111, 81, 65));
            g2.fill(new Ellipse2D.Double(centroX - diametro / 2.0,
                    centroY - diametro / 2.0, diametro, diametro));
            g2.setColor(CORAL);
            g2.draw(new Ellipse2D.Double(centroX - diametro / 2.0,
                    centroY - diametro / 2.0, diametro, diametro));
        } else if (componente instanceof Texto) {
            String texto = ((Texto) componente).getContenido();
            g2.setColor(AZUL);
            g2.setFont(new Font("SansSerif", Font.BOLD, 14));
            dibujarTextoCentrado(g2, texto, centroX, centroY);
        }

        g2.setColor(DORADO.darker());
        g2.setFont(new Font("SansSerif", Font.PLAIN, 11));
        dibujarTextoCentrado(g2, componente.getPeso() + " bytes",
                centroX, y + alto - 12);
    }

    private void dibujarTextoCentrado(Graphics2D g2, String texto, int x, int y) {
        FontMetrics metrics = g2.getFontMetrics();
        g2.drawString(texto, x - metrics.stringWidth(texto) / 2,
                y + metrics.getAscent() / 2);
    }

    private int calcularAncho(FiguraComponent componente) {
        if (!(componente instanceof Dibujo)) {
            return 150;
        }
        Dibujo composite = (Dibujo) componente;
        if (composite.getHijos().isEmpty()) {
            return 180;
        }
        int ancho = 28;
        for (FiguraComponent hijo : composite.getHijos()) {
            ancho += calcularAncho(hijo) + 10;
        }
        return ancho;
    }

    private int calcularProfundidad(FiguraComponent componente) {
        if (!(componente instanceof Dibujo)
                || ((Dibujo) componente).getHijos().isEmpty()) {
            return 1;
        }
        int profundidad = 0;
        for (FiguraComponent hijo : ((Dibujo) componente).getHijos()) {
            profundidad = Math.max(profundidad, calcularProfundidad(hijo));
        }
        return profundidad + 1;
    }
}
