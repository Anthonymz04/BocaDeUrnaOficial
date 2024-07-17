package com.bocaurna.formulario;

import javax.swing.*;
import com.bocaurna.*;

public class FrmResultadosCanton extends JFrame {
    private JTextArea textAreaResultados;
    private Recinto recinto;

    public FrmResultadosCanton() {
        setTitle("Resultados por Cantón o Ciudad");
        setBounds(100, 100, 400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        recinto = cargarDatosRecinto();

        textAreaResultados = new JTextArea();
        textAreaResultados.setBounds(30, 30, 300, 200);
        getContentPane().add(textAreaResultados);

        mostrarResultados();
    }

    private Recinto cargarDatosRecinto() {
        Recinto recinto = new Recinto();
        recinto.setNombre("Cantón X");
        recinto.setProvincia("Pichincha");

        for (Candidato candidato : FrmCandidatos.getCandidatos()) {
            recinto.agragarCandidato(candidato);
        }

        return recinto;
    }

    private void mostrarResultados() {
        String reporte = EstadisticasVotos.generarReportePorcentajes(recinto);
        textAreaResultados.setText(reporte);
    }
}

