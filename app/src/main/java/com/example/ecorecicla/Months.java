package com.example.ecorecicla;

public enum Months {
    ENERO("Enero"),
    FEBRERO("Febrero"),
    MARZO("Marzo"),
    ABRIL("Abril"),
    MAYO("Mayo"),
    JUNIO("Junio"),
    JULIO("Julio"),
    AGOSTO("Agosto"),
    SEPTIEMBRE("Sepiembre"),
    OCTUBRE("Octubre"),
    NOVIEMBRE("noviembre"),
    DICIEMBRE("Diciembre");

    private final String description;

    Months(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
