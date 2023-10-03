package com.example.siteynetimitakip.Entity;

public class ApartmanSakini {

    private int id;
    private String kiraciIsmi;
    private String sahibiIsmi;
    private String kiraciBorc;
    private String sahibiBorc;

    public ApartmanSakini(int id, String kiraciIsmi, String sahibiIsmi, String kiraciBorc, String sahibiBorc) {
        this.id = id;
        this.kiraciIsmi = kiraciIsmi;
        this.sahibiIsmi = sahibiIsmi;
        this.kiraciBorc = kiraciBorc;
        this.sahibiBorc = sahibiBorc;
    }

    public String getAll(){
        return "Kiracı: " + kiraciIsmi + "\nSahibi: " + sahibiIsmi + "\n" + "Kiracı Borç: " + kiraciBorc + "\nSahibi Borç: " + sahibiBorc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKiraciIsmi() {
        return kiraciIsmi;
    }

    public void setKiraciIsmi(String kiraciIsmi) {
        this.kiraciIsmi = kiraciIsmi;
    }

    public String getSahibiIsmi() {
        return sahibiIsmi;
    }

    public void setSahibiIsmi(String sahibiIsmi) {
        this.sahibiIsmi = sahibiIsmi;
    }

    public String getKiraciBorc() {
        return kiraciBorc;
    }

    public void setKiraciBorc(String kiraciBorc) {
        this.kiraciBorc = kiraciBorc;
    }

    public String getSahibiBorc() {
        return sahibiBorc;
    }

    public void setSahibiBorc(String sahibiBorc) {
        this.sahibiBorc = sahibiBorc;
    }
}
