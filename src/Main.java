public class Main {
    public static void main(String[] args) {
        Pedido pedido1 = new PedidoComida(1, "Av. Alemania 123, Puerto Varas", 3.5);
        Pedido pedido2 = new PedidoEncomienda(2, "Ruta 225, Frutillar", 12.0);
        Pedido pedido3 = new PedidoExpress(3, "Camino Real 456, Puerto Montt", 7.2);

        ControladorDeEnvios controlador = new ControladorDeEnvios();

        System.out.println("=== Asignación automática (sobrescritura) ===");
        pedido1.asignarRepartidor();
        pedido2.asignarRepartidor();
        pedido3.asignarRepartidor();

        System.out.println("\n=== Asignación manual (sobrecarga) ===");
        pedido1.asignarRepartidor("Carlos Muñoz");
        pedido2.asignarRepartidor("Fernanda Soto");
        pedido3.asignarRepartidor("Ignacio Pérez");

        System.out.println("\n=== Tiempos estimados ===");
        pedido1.mostrarResumen();
        System.out.println("Tiempo estimado: " + pedido1.calcularTiempoEntrega() + " min");
        pedido2.mostrarResumen();
        System.out.println("Tiempo estimado: " + pedido2.calcularTiempoEntrega() + " min");
        pedido3.mostrarResumen();
        System.out.println("Tiempo estimado: " + pedido3.calcularTiempoEntrega() + " min");

        System.out.println("\n=== Despacho y cancelación ===");
        controlador.despachar(pedido1);
        controlador.despachar(pedido2);
        controlador.cancelar(pedido3);

        System.out.println();
        controlador.verHistorial();
    }
}