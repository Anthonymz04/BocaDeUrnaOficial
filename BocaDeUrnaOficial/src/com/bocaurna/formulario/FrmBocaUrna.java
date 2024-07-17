package com.bocaurna.formulario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.bocaurna.Candidato;
import java.util.ArrayList;

public class FrmBocaUrna extends JFrame {
    private JComboBox<String> cmbProvincias;
    private JComboBox<String> cmbCandidatos;
    private JTextField txtVotos;

    public FrmBocaUrna() {
        setTitle("Boca de Urna");
        setBounds(100, 100, 400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblProvincia = new JLabel("Provincia:");
        lblProvincia.setBounds(30, 30, 100, 25);
        getContentPane().add(lblProvincia);

        cmbProvincias = new JComboBox<>();
        cmbProvincias.setBounds(150, 30, 200, 25);
        getContentPane().add(cmbProvincias);

        JLabel lblCandidato = new JLabel("Candidato:");
        lblCandidato.setBounds(30, 70, 100, 25);
        getContentPane().add(lblCandidato);

        cmbCandidatos = new JComboBox<>();
        cmbCandidatos.setBounds(150, 70, 200, 25);
        getContentPane().add(cmbCandidatos);

        JLabel lblVotos = new JLabel("Votos:");
        lblVotos.setBounds(30, 110, 100, 25);
        getContentPane().add(lblVotos);

        txtVotos = new JTextField();
        txtVotos.setBounds(150, 110, 200, 25);
        getContentPane().add(txtVotos);

        JButton btnRegistrarVoto = new JButton("Registrar Voto");
        btnRegistrarVoto.setBounds(150, 150, 200, 25);
        getContentPane().add(btnRegistrarVoto);

        cargarProvincias();

        cmbProvincias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarCandidatos();
            }
        });

        btnRegistrarVoto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarVoto();
            }
        });

        // Inicializar candidatos
        cargarCandidatos();
    }

    private void cargarProvincias() {
        String[] provincias = {
            "Azuay (Cuenca)", "Bolívar (Guaranda)", "Cañar (Azogues)", "Carchi (Tulcán)", "Chimborazo (Riobamba)",
            "Cotopaxi (Latacunga)", "El Oro (Machala)", "Esmeraldas (Ciudad Esmeraldas)", "Galápagos (Puerto Baquerizo Moreno)",
            "Guayas (Guayaquil)", "Imbabura (Ibarra)", "Loja (Loja)", "Los Ríos (Babahoyo)", "Manabí (Portoviejo)",
            "Morona Santiago (Macas)", "Napo (Tena)", "Orellana (Francisco de Orellana)", "Pastaza (Puyo)",
            "Pichincha (Quito)", "Santa Elena (Santa Elena)", "Santo Domingo de los Tsáchilas (Santo Domingo)",
            "Sucumbíos (Nueva Loja)", "Tungurahua (Ambato)", "Zamora Chinchipe (Zamora)"
        };

        for (String provincia : provincias) {
            cmbProvincias.addItem(provincia);
        }

        // Cargar todos los candidatos al inicio
        cargarCandidatos();
    }

    private void cargarCandidatos() {
        cmbCandidatos.removeAllItems();
        ArrayList<Candidato> candidatos = FrmCandidatos.getCandidatos();
        for (Candidato candidato : candidatos) {
            cmbCandidatos.addItem(candidato.getNombre() + " (" + candidato.getPartido() + ")");
        }
    }

    private void registrarVoto() {
        String candidatoSeleccionado = (String) cmbCandidatos.getSelectedItem();
        int votos = Integer.parseInt(txtVotos.getText());

        ArrayList<Candidato> candidatos = FrmCandidatos.getCandidatos();
        for (Candidato candidato : candidatos) {
            if ((candidato.getNombre() + " (" + candidato.getPartido() + ")").equals(candidatoSeleccionado)) {
                candidato.incrementarVotos(votos);
                JOptionPane.showMessageDialog(this, "Votos registrados correctamente.");
                txtVotos.setText("");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Error al registrar los votos.");
    }
}

