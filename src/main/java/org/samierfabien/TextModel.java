package org.samierfabien;

public class TextModel {
    private String texteOriginal;
    private String texteMinuscule;
    private String texteMajuscule;
    //Pas très fan mettre les variables suivantes ici mais ça me semblait plus bizarre encore dans le controller.
    private String fondCouleur = "-fx-background-color: #F4F4F4;";
    private String texteCouleur = "-fx-text-fill: black;";

    public String getTexteOriginal() {
        return texteOriginal;
    }

    public void setTexteOriginal(String texteOriginal) {
        this.texteOriginal = texteOriginal;
    }

    public String getTexteMinuscule() {
        return texteMinuscule;
    }

    public void setTexteMinuscule(String texteMinuscule) {
        this.texteMinuscule = texteMinuscule.toLowerCase();
    }

    public String getTexteMajuscule() {
        return texteMajuscule;
    }

    public void setTexteMajuscule(String texteMajuscule) {
        this.texteMajuscule = texteMajuscule.toUpperCase();
    }

    public String getFondCouleur() {
        return fondCouleur;
    }

    public void setFondCouleur(String fondCouleur) {
        this.fondCouleur = fondCouleur;
    }

    public String getTexteCouleur() {
        return texteCouleur;
    }

    public void setTexteCouleur(String texteCouleur) {
        this.texteCouleur = texteCouleur;
    }
}
