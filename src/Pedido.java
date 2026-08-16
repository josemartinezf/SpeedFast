public class Pedido {
    protected int idPedido;
    protected String direccionEntrega;
    protected String tipoPedido;

    public Pedido(int idPedido, String direccionEntrega, String tipoPedido) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipoPedido = tipoPedido;
    }

    // metodo sobreescrito
    public void asignarRepartidor() {
        System.out.println("Pedido #" + idPedido + ": buscando repartidor disponible...");
    }

    // metodo sobrecargado
    public void asignarRepartidor(String nombreRepartidor) {
        System.out.println("Pedido #" + idPedido + " asignado a " + nombreRepartidor + ".");
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }
}