package com.bocaurna.reportes;

public class ReporteFactory {
    public static Reporte crearReporte(String tipo, String provincia) {
        switch (tipo) {
            case "Provincia":
                return new ReporteProvincia(provincia);
            case "Canton":
                return new ReporteCanton(provincia);
            default:
                throw new IllegalArgumentException("Tipo de reporte desconocido: " + tipo);
        }
    }
}
