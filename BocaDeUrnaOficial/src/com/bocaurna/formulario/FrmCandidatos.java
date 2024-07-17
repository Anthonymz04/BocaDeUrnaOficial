package com.bocaurna.formulario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.bocaurna.Candidato;
import java.util.ArrayList;

public class FrmCandidatos extends JFrame {
    private JTextField txtNombre;
    private JTextField txtPartido;
    private JButton btnGuardar;
    private static ArrayList<Candidato> candidatos = new ArrayList<>(); 

    public FrmCandidatos() {
        setTitle("Registrar Prefecto");
        setBounds(100, 100, 400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 30, 80, 25);
        getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 30, 200, 25);
        getContentPane().add(txtNombre);

        JLabel lblPartido = new JLabel("Partido:");
        lblPartido.setBounds(30, 70, 80, 25);
        getContentPane().add(lblPartido);

        txtPartido = new JTextField();
        txtPartido.setBounds(120, 70, 200, 25);
        getContentPane().add(txtPartido);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(120, 110, 100, 25);
        getContentPane().add(btnGuardar);

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String partido = txtPartido.getText();
                String[] provincias = {
                    "Azuay (Cuenca)", "Bolívar (Guaranda)", "Cañar (Azogues)", "Carchi (Tulcán)", "Chimborazo (Riobamba)",
                    "Cotopaxi (Latacunga)", "El Oro (Machala)", "Esmeraldas (Ciudad Esmeraldas)", "Galápagos (Puerto Baquerizo Moreno)",
                    "Guayas (Guayaquil)", "Imbabura (Ibarra)", "Loja (Loja)", "Los Ríos (Babahoyo)", "Manabí (Portoviejo)",
                    "Morona Santiago (Macas)", "Napo (Tena)", "Orellana (Francisco de Orellana)", "Pastaza (Puyo)",
                    "Pichincha (Quito)", "Santa Elena (Santa Elena)", "Santo Domingo de los Tsáchilas (Santo Domingo)",
                    "Sucumbíos (Nueva Loja)", "Tungurahua (Ambato)", "Zamora Chinchipe (Zamora)"
                };
                
                for (String provincia : provincias) {
                    Candidato candidato = new Candidato();
                    candidato.setNombre(nombre);
                    candidato.setPartido(partido);
                    candidato.setProvincia(provincia); 
                    candidatos.add(candidato);
                }
                
                JOptionPane.showMessageDialog(null, "Candidato guardado en todas las provincias con éxito.");
                txtNombre.setText("");
                txtPartido.setText("");
            }
        });
    }

    public static ArrayList<Candidato> getCandidatos() {
        return candidatos;
    }
}

