package p69.decorator;

/** Convierte a HTML el resultado del componente envuelto. El orden importa. */
public class NotificacionHTML extends NotificacionDecorator {
    public NotificacionHTML(Notificacion notificacion) {
        super(notificacion);
    }

    @Override
    public String send() {
        return formatoHTML(super.send());
    }

    private String formatoHTML(String texto) {
        String seguro = texto.replace("&", "&amp;")
                .replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&#39;")
                .replace("\r\n", "\n").replace("\r", "\n")
                .replace("\n", "<br>");
        return "<html><body><p>" + seguro + "</p></body></html>";
    }
}
