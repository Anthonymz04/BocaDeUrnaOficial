package com.bocaurna.reportes;

import com.bocaurna.Candidato;
import com.bocaurna.formulario.FrmCandidatos;

public class ReporteProvincia implements Reporte {
    private String provincia;

    public ReporteProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String generarReporte() {
        StringBuilder reporte = new StringBuilder("Resultados por Provincia: " + provincia + "\n");
        for (Candidato candidato : FrmCandidatos.getCandidatos()) {
            if (candidato.getProvincia().equals(provincia)) {
                reporte.append(candidato.getNombre())
                       .append(" (")
                       .append(candidato.getPartido())
                       .append("): ")
                       .append(candidato.getVotos())
                       .append(" votos\n");
            }
        }
        return reporte.toString();
    }
}
