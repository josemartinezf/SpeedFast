public class PedidoExpress extends Pedido {
    private double distanciaKm;

    public PedidoExpress(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, "Compra Express");
        this.distanciaKm = distanciaKm;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido #" + idPedido + " (Compra Express): buscando repartidor más cercano con disponibilidad inmediata...");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Pedido #" + idPedido + " (Compra Express) asignado a " + nombreRepartidor
                + ". Distancia al repartidor: " + distanciaKm + " km.");
    }
}