package main;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private ControladorPedidos controlador;

    public VentanaPrincipal() {
        controlador = new ControladorPedidos();

        setTitle("SpeedFast - Gestión de Entregas");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnRegistrar = new JButton("Registrar Pedido");
        JButton btnListar = new JButton("Listar Pedidos");
        JButton btnAsignar = new JButton("Asignar Repartidor / Iniciar Entrega");

        btnRegistrar.addActionListener(e -> new VentanaRegistroPedido(controlador).setVisible(true));
        btnListar.addActionListener(e -> new VentanaListaPedidos(controlador).setVisible(true));
        btnAsignar.addActionListener(e -> new VentanaListaPedidos(controlador).setVisible(true));

        add(btnRegistrar);
        add(btnListar);
        add(btnAsignar);
    }
}