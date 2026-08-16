public class Main {
    public static void main(String[] args) {
        PedidoComida pedido1 = new PedidoComida(1, "Av. Alemania 123, Puerto Varas");
        PedidoEncomienda pedido2 = new PedidoEncomienda(2, "Ruta 225, Frutillar", 15.5);
        PedidoExpress pedido3 = new PedidoExpress(3, "Camino Real 456, Puerto Montt", 2.3);

        System.out.println("=== Asignación genérica (sobrescritura) ===");
        pedido1.asignarRepartidor();
        pedido2.asignarRepartidor();
        pedido3.asignarRepartidor();

        System.out.println("\n=== Asignación con nombre (sobrecarga) ===");
        pedido1.asignarRepartidor("Carlos Muñoz");
        pedido2.asignarRepartidor("Fernanda Soto");
        pedido3.asignarRepartidor("Ignacio Pérez");
    }
}