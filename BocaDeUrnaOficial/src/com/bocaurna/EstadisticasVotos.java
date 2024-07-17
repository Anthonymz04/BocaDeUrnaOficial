package com.bocaurna;

import java.util.List;

public class EstadisticasVotos {
    public static String generarReportePorcentajes(Recinto recinto) {
        int totalVotos = recinto.getCandidatos().stream().mapToInt(Candidato::getVotos).sum();
        StringBuilder reporte = new StringBuilder("Porcentaje de votos por candidato:\n");
        
        for (Candidato candidato : recinto.getCandidatos()) {
            double porcentaje = totalVotos == 0 ? 0 : (double) candidato.getVotos() / totalVotos * 100;
            reporte.append(candidato.getNombre())
                   .append(" (")
                   .append(candidato.getPartido())
                   .append("): ")
                   .append(String.format("%.2f", porcentaje))
                   .append("%\n");
        }
        
        return reporte.toString();
    }
}
