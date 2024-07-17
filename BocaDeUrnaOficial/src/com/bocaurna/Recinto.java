package com.bocaurna;

import java.util.ArrayList;
import java.util.List;

public class Recinto {
    private String nombre;
    private String provincia;
    private List<Candidato> candidatos;

    public Recinto() {
        candidatos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void agragarCandidato(Candidato candidato) {
        candidatos.add(candidato);
    }
}

