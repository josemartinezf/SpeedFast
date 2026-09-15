import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        zonaDeCarga.agregarPedido(new Pedido(1, "Av. Alemania 123, Puerto Varas"));
        zonaDeCarga.agregarPedido(new Pedido(2, "Camino Real 456, Puerto Montt"));
        zonaDeCarga.agregarPedido(new Pedido(3, "Ruta 225, Frutillar"));
        zonaDeCarga.agregarPedido(new Pedido(4, "Costanera 321, Frutillar"));
        zonaDeCarga.agregarPedido(new Pedido(5, "Los Colonos 789, Puerto Varas"));

        Repartidor repartidor1 = new Repartidor("Carlos Muñoz", zonaDeCarga);
        Repartidor repartidor2 = new Repartidor("Fernanda Soto", zonaDeCarga);
        Repartidor repartidor3 = new Repartidor("Ignacio Pérez", zonaDeCarga);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(repartidor1);
        executor.execute(repartidor2);
        executor.execute(repartidor3);

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nTodos los pedidos han sido entregados correctamente");
    }
}