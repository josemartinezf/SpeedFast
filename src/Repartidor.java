import java.util.Random;

public class Repartidor implements Runnable {
    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {
        Pedido pedido;
        while ((pedido = zonaDeCarga.retirarPedido()) != null) {
            System.out.println(nombre + " retiró el " + pedido + " -> ahora EN_REPARTO");

            int tiempoSimulado = new Random().nextInt(3000) + 1000;
            try {
                Thread.sleep(tiempoSimulado);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            pedido.setEstado(EstadoPedido.ENTREGADO);
            System.out.println(nombre + " entregó el Pedido #" + pedido.getId() + " -> ahora ENTREGADO");
        }
        System.out.println(nombre + " no encontró más pedidos. Finaliza su turno.");
    }
}