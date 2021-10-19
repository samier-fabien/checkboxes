package org.samierfabien;

public class TextModel {
    private String texteOriginal;
    private String texteMinuscule;
    private String texteMajuscule;

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
}
