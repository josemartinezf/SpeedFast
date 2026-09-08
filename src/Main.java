import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Pedidos del repartidor 1
        List<Pedido> pedidos1 = new ArrayList<>();
        pedidos1.add(new PedidoComida(1, "Av. Alemania 123, Puerto Varas", 3.5));
        pedidos1.add(new PedidoExpress(2, "Camino Real 456, Puerto Montt", 7.2));

        // Pedidos del repartidor 2
        List<Pedido> pedidos2 = new ArrayList<>();
        pedidos2.add(new PedidoEncomienda(3, "Ruta 225, Frutillar", 12.0));
        pedidos2.add(new PedidoComida(4, "Av. Vicente Pérez Rosales 200, Puerto Varas", 2.1));

        // Pedidos del repartidor 3
        List<Pedido> pedidos3 = new ArrayList<>();
        pedidos3.add(new PedidoExpress(5, "Los Colonos 789, Puerto Varas", 4.0));
        pedidos3.add(new PedidoEncomienda(6, "Costanera 321, Frutillar", 9.5));

        Repartidor repartidor1 = new Repartidor("Carlos Muñoz", pedidos1);
        Repartidor repartidor2 = new Repartidor("Fernanda Soto", pedidos2);
        Repartidor repartidor3 = new Repartidor("Ignacio Pérez", pedidos3);

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

        System.out.println("\nTodas las entregas han finalizado.");
    }
}