public class PedidoEncomienda extends Pedido {
    private double pesoKg;

    public PedidoEncomienda(int idPedido, String direccionEntrega, double pesoKg) {
        super(idPedido, direccionEntrega, "Encomienda");
        this.pesoKg = pesoKg;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Pedido #" + idPedido + " (Encomienda): validando peso y embalaje...");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        String validacion = (pesoKg <= 20) ? "peso dentro del límite" : "peso excede el límite permitido";
        System.out.println("Pedido #" + idPedido + " (Encomienda) asignado a " + nombreRepartidor
                + ". Validación: " + validacion + " (" + pesoKg + " kg).");
    }
}