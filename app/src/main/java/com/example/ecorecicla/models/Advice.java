package com.example.ecorecicla.models;

public class Advice {

    private String categoria;
    private String subtitle;
    private String advace;

    public Advice(String categoria, String subtitle, String advace) {
        this.categoria = categoria;
        this.subtitle = subtitle;
        this.advace = advace;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAdvace() {
        return advace;
    }

    public void setAdvace(String advace) {
        this.advace = advace;
    }
}
