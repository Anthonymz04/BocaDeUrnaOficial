package com.bocaurna.reportes;

import com.bocaurna.Candidato;
import com.bocaurna.formulario.FrmCandidatos;

public class ReporteCanton implements Reporte {
    private String provincia;

    public ReporteCanton(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String generarReporte() {
        StringBuilder reporte = new StringBuilder("Resultados por Cantón o Ciudad: " + provincia + "\n");
        for (Candidato candidato : FrmCandidatos.getCandidatos()) {
            reporte.append(candidato.getNombre())
                   .append(" (")
                   .append(candidato.getPartido())
                   .append("): ")
                   .append(candidato.getVotos())
                   .append(" votos\n");
        }
        return reporte.toString();
    }
}
