package com.bocaurna;

public class Candidato {
    private String nombre;
    private String partido;
    private String provincia;
    private int votos;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getVotos() {
        return votos;
    }

    public void incrementarVotos(int votos) {
        this.votos += votos;
    }
}


