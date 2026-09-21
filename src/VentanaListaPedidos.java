package main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaListaPedidos extends JFrame {
    private ControladorPedidos controlador;
    private DefaultTableModel modeloTabla;
    private JTable tabla;

    public VentanaListaPedidos(ControladorPedidos controlador) {
        this.controlador = controlador;

        setTitle("Lista de Pedidos");
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        String[] columnas = {"ID", "Dirección", "Tipo", "Repartidor", "Estado"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modeloTabla);

        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        JButton btnRefrescar = new JButton("Refrescar");
        JButton btnAsignar = new JButton("Asignar Repartidor / Iniciar Entrega");

        btnRefrescar.addActionListener(e -> cargarDatos());
        btnAsignar.addActionListener(e -> asignarRepartidor());

        panelBotones.add(btnRefrescar);
        panelBotones.add(btnAsignar);
        add(panelBotones, BorderLayout.SOUTH);

        cargarDatos();
    }

    private void cargarDatos() {
        modeloTabla.setRowCount(0);
        for (Pedido p : controlador.listarPedidos()) {
            modeloTabla.addRow(new Object[]{
                    p.getIdPedido(), p.getDireccionEntrega(), p.getTipoPedido(),
                    p.getRepartidorAsignado(), p.getEstado()
            });
        }
    }

    private void asignarRepartidor() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un pedido de la tabla.",
                    "Sin selección", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idPedido = (int) modeloTabla.getValueAt(fila, 0);
        Pedido pedido = controlador.listarPedidos().stream()
                .filter(p -> p.getIdPedido() == idPedido)
                .findFirst()
                .orElse(null);

        if (pedido == null) return;

        String nombreRepartidor = JOptionPane.showInputDialog(this, "Nombre del repartidor:");
        if (nombreRepartidor == null || nombreRepartidor.trim().isEmpty()) return;

        pedido.setRepartidorAsignado(nombreRepartidor);
        pedido.setEstado("EN_REPARTO");
        cargarDatos();

        JOptionPane.showMessageDialog(this, "Entrega iniciada por " + nombreRepartidor
                + " para el Pedido #" + idPedido, "Entrega en curso", JOptionPane.INFORMATION_MESSAGE);

        simularEntrega(pedido);
    }

    private void simularEntrega(Pedido pedido) {
        Thread hiloEntrega = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            pedido.setEstado("ENTREGADO");
            SwingUtilities.invokeLater(this::cargarDatos);
        });
        hiloEntrega.start();
    }
}