public class Main {
    public static void main(String[] args) {
        Pedido pedido1 = new PedidoComida(1, "Av. Alemania 123, Puerto Varas", 3.5);
        Pedido pedido2 = new PedidoEncomienda(2, "Ruta 225, Frutillar", 12.0);
        Pedido pedido3 = new PedidoExpress(3, "Camino Real 456, Puerto Montt", 7.2);

        Pedido[] pedidos = { pedido1, pedido2, pedido3 };

        for (Pedido p : pedidos) {
            p.mostrarResumen();
            System.out.println("Tiempo estimado de entrega: " + p.calcularTiempoEntrega() + " min");
            System.out.println("-----------------------------------");
        }
    }
}