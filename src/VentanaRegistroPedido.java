package main;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistroPedido extends JFrame {
    private ControladorPedidos controlador;
    private JTextField txtDireccion;
    private JComboBox<String> comboTipo;

    public VentanaRegistroPedido(ControladorPedidos controlador) {
        this.controlador = controlador;

        setTitle("Registrar Pedido");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblDireccion = new JLabel("Dirección:");
        txtDireccion = new JTextField();

        JLabel lblTipo = new JLabel("Tipo:");
        comboTipo = new JComboBox<>(new String[]{"Comida", "Encomienda", "Express"});

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarPedido());

        add(lblDireccion);
        add(txtDireccion);
        add(lblTipo);
        add(comboTipo);
        add(new JLabel());
        add(btnGuardar);
    }

    private void guardarPedido() {
        String direccion = txtDireccion.getText().trim();
        String tipo = (String) comboTipo.getSelectedItem();

        if (direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una dirección.",
                    "Campo vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Pedido nuevo = controlador.registrarPedido(direccion, tipo);
        JOptionPane.showMessageDialog(this, "Pedido #" + nuevo.getIdPedido()
                + " registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        txtDireccion.setText("");
    }
}