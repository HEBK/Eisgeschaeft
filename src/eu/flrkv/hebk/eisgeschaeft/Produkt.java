package eu.flrkv.hebk.eisgeschaeft;

public class Produkt {

    private String[] zutaten = new String[6];
    private String name;
    private double preis;
    private double preisMwst;

    public Produkt(String pName, double pPreis, String[] pZutaten) {
        this.setZutaten(pZutaten);
        this.setName(pName);
        this.setPreis(pPreis);
        this.setPreisMwst(calcMwst(pPreis));
    }

    public double calcMwst(double pPreis) {
        return pPreis*1.19;
    }

    public void setZutaten(String[] pZutaten) {
        this.zutaten = pZutaten;
    }

    public void setPreis(double pPreis) {
        this.preis = pPreis;
    }

    public void setPreisMwst(double pPreis) {
        this.preisMwst = pPreis;
    }

    public void setName(String pName) {
        this.name = pName;
    }

    public String getName() {
        return this.name;
    }

    public double getPreis () {
        return this.preis;
    }

    public double getPreisMwst() {
        return this.preisMwst;
    }

    public String[] getZutaten() {
        return this.zutaten;
    }








}
