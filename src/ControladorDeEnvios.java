import java.util.ArrayList;

public class ControladorDeEnvios implements Despachable, Cancelable, Rastreable {
    private ArrayList<String> historial = new ArrayList<>();

    @Override
    public void despachar(Pedido pedido) {
        System.out.println("Pedido #" + pedido.getIdPedido() + " despachado con éxito.");
        historial.add("Pedido #" + pedido.getIdPedido() + " - Despachado");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("Pedido #" + pedido.getIdPedido() + " ha sido cancelado.");
        historial.add("Pedido #" + pedido.getIdPedido() + " - Cancelado");
    }

    @Override
    public void verHistorial() {
        System.out.println("=== Historial de entregas ===");
        for (String registro : historial) {
            System.out.println(registro);
        }
    }
}