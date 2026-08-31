public class PedidoComida extends Pedido {

    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public int calcularTiempoEntrega() {
        return (int) (15 + distanciaKm * 2);
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido #" + idPedido + " (Comida): requiere repartidor con mochila térmica.");
    }
}