import java.util.LinkedList;
import java.util.List;

public class ZonaDeCarga {
    private List<Pedido> pedidosPendientes = new LinkedList<>();

    public synchronized void agregarPedido(Pedido p) {
        pedidosPendientes.add(p);
        System.out.println("Pedido agregado a la zona de carga: " + p);
    }

    public synchronized Pedido retirarPedido() {
        if (pedidosPendientes.isEmpty()) {
            return null;
        }
        Pedido pedido = pedidosPendientes.remove(0);
        pedido.setEstado(EstadoPedido.EN_REPARTO);
        return pedido;
    }
}