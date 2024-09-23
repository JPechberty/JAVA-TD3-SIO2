package com.sio.javatd3sio2.models;

public class Client {
    private String siret;
    private String raisonSociale;
    private String adresse;
    private String codePostal;
    private String ville;

    public Client(String siret, String raisonSociale, String adresse, String codePostal, String ville) {
        this.siret = siret;
        this.raisonSociale = raisonSociale;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public Client(String siret, String raisonSociale) {
        this.siret = siret;
        this.raisonSociale = raisonSociale;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}

