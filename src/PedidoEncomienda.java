public class PedidoEncomienda extends Pedido {

    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public int calcularTiempoEntrega() {
        return (int) Math.round(20 + distanciaKm * 1.5);
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido #" + idPedido + " (Encomienda): validando peso y embalaje...");
    }
}