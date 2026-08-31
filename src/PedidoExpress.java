public class PedidoExpress extends Pedido {

    public PedidoExpress(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public int calcularTiempoEntrega() {
        int tiempo = 10;
        if (distanciaKm > 5) {
            tiempo += 5;
        }
        return tiempo;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido #" + idPedido + " (Express): buscando repartidor más cercano con disponibilidad inmediata...");
    }
}