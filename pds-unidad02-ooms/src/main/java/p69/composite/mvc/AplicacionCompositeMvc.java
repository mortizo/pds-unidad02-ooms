package p69.composite.mvc;

import java.awt.EventQueue;
import javax.swing.UIManager;
import p69.composite.mvc.controlador.ControladorComposite;
import p69.composite.mvc.modelo.ModeloComposite;
import p69.composite.mvc.vista.VistaComposite;

/** Punto de entrada de la demostracion grafica MVC. */
public class AplicacionCompositeMvc {

    public static void main(String[] args) {
        configurarApariencia();
        EventQueue.invokeLater(() -> {
            ModeloComposite modelo = new ModeloComposite();
            VistaComposite vista = new VistaComposite();
            new ControladorComposite(modelo, vista).iniciar();
        });
    }

    private static void configurarApariencia() {
        try {
            for (UIManager.LookAndFeelInfo info
                    : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            // Swing utilizara la apariencia predeterminada del sistema.
        }
    }
}
