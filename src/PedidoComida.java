public class PedidoComida extends Pedido {

    public PedidoComida(int idPedido, String direccionEntrega) {
        super(idPedido, direccionEntrega, "Comida");
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido #" + idPedido + " (Comida): requiere repartidor con mochila térmica.");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Pedido #" + idPedido + " (Comida) asignado a " + nombreRepartidor
                + ". Validación: mochila térmica confirmada.");
    }
}