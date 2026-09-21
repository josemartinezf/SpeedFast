package main;

import java.util.ArrayList;
import java.util.List;

public class ControladorPedidos {
    private List<Pedido> pedidos = new ArrayList<>();
    private int siguienteId = 1;

    public Pedido registrarPedido(String direccion, String tipo) {
        Pedido nuevo = new Pedido(siguienteId, direccion, tipo);
        pedidos.add(nuevo);
        siguienteId++;
        return nuevo;
    }

    public List<Pedido> listarPedidos() {
        return pedidos;
    }
}