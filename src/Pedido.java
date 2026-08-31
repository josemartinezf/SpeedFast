public abstract class Pedido {
    protected int idPedido;
    protected String direccionEntrega;
    protected double distanciaKm;
    protected String repartidorAsignado;

    public Pedido(int idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }

    public void mostrarResumen() {
        System.out.println("Pedido #" + idPedido + " | Dirección: " + direccionEntrega
                + " | Distancia: " + distanciaKm + " km");
    }

    public abstract int calcularTiempoEntrega();

    // Sobrescrito en cada subclase
    public abstract void asignarRepartidor();

    // Sobrecargado (versión común con nombre)
    public void asignarRepartidor(String nombre) {
        this.repartidorAsignado = nombre;
        System.out.println("Pedido #" + idPedido + " asignado manualmente a " + nombre + ".");
    }

    public int getIdPedido() {
        return idPedido;
    }
}