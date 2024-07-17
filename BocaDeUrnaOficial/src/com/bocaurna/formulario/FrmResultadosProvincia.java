package com.bocaurna.formulario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.bocaurna.*;

public class FrmResultadosProvincia extends JFrame {
    private JTextArea textAreaResultados;
    private JComboBox<String> cmbProvincias;

    public FrmResultadosProvincia() {
        setTitle("Resultados por Provincia");
        setBounds(100, 100, 400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblProvincia = new JLabel("Provincia:");
        lblProvincia.setBounds(30, 30, 100, 25);
        getContentPane().add(lblProvincia);

        cmbProvincias = new JComboBox<>();
        cmbProvincias.setBounds(150, 30, 200, 25);
        getContentPane().add(cmbProvincias);

        textAreaResultados = new JTextArea();
        textAreaResultados.setBounds(30, 70, 320, 200);
        getContentPane().add(textAreaResultados);

        cargarProvincias();

        cmbProvincias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarResultados();
            }
        });
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
    }

    private void mostrarResultados() {
        String provinciaSeleccionada = (String) cmbProvincias.getSelectedItem();
        Recinto recinto = cargarDatosRecinto(provinciaSeleccionada);
        String reporte = EstadisticasVotos.generarReportePorcentajes(recinto);
        textAreaResultados.setText(reporte);
    }

    private Recinto cargarDatosRecinto(String provincia) {
        Recinto recinto = new Recinto();
        recinto.setNombre("Recinto X");
        recinto.setProvincia(provincia);

        for (Candidato candidato : FrmCandidatos.getCandidatos()) {
            if (provincia.equals(candidato.getProvincia())) {
                recinto.agragarCandidato(candidato);
            }
        }

        return recinto;
    }
}

