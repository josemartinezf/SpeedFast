import java.util.List;
import java.util.Random;

public class Repartidor implements Runnable {
    private String nombre;
    private List<Pedido> pedidosAsignados;

    public Repartidor(String nombre, List<Pedido> pedidosAsignados) {
        this.nombre = nombre;
        this.pedidosAsignados = pedidosAsignados;
    }

    @Override
    public void run() {
        System.out.println(nombre + " comienza su recorrido con " + pedidosAsignados.size() + " pedidos.");

        for (Pedido pedido : pedidosAsignados) {
            System.out.println(nombre + " está entregando el Pedido #" + pedido.getIdPedido()
                    + " (" + pedido.getClass().getSimpleName() + ")...");

            int tiempoSimulado = new Random().nextInt(3000) + 1000; // entre 1 y 4 segundos
            try {
                Thread.sleep(tiempoSimulado);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(nombre + " fue interrumpido.");
            }

            System.out.println(nombre + " completó el Pedido #" + pedido.getIdPedido()
                    + " en " + tiempoSimulado + " ms.");
        }

        System.out.println(nombre + " finalizó todas sus entregas.");
    }
}