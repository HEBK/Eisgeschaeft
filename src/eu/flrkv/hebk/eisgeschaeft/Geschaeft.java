package eu.flrkv.hebk.eisgeschaeft;

import java.util.*;
import java.text.DecimalFormat;

public class Geschaeft{

    protected boolean offen = false;
    protected String geschaeftname;
    protected List<Produkt> verkauftProdukte = new ArrayList<Produkt>();
    protected List<Produkt> produkte = new ArrayList<Produkt>();
    protected Menu menu;
    private DecimalFormat f = new DecimalFormat("#0.00");
    private Scanner scanner = new Scanner(System.in);


    public Geschaeft(String pName) {
        this.geschaeftname = pName;
        this.menu = new Menu(pName);
    }

    public Produkt verkaufen(int pProductNo) {
        System.out.print("Das kostet" + produkte.get(pProductNo).getPreisMwst());
        verkauftProdukte.add(produkte.get(pProductNo));
        return produkte.get(pProductNo);
    }

    public void addProduct(Produkt pProdukt) {
        produkte.add(pProdukt);
    }

    public void showAllProducts() {
        int i = 0;
        for(Produkt p: produkte) {
            i++;
            System.out.println(i + ". " + p.getName() + " - Preis: " + f.format(p.getPreisMwst()) + " €");
        }
    }

    public void setStoreStatus(boolean pStatus){
        this.offen = pStatus;
    }

    public boolean isOpened() {
        return this.offen;
    }

    public void run() {
        menu.clearConsole();
        if(!this.isOpened()) {
            menu.storeIsClosed();
        }

        else {
            while(true) {
                menu.printHeader();
                System.out.println("Bitte wählen Sie die gewünschte Eissorte aus:");
                this.showAllProducts();
                scanner.nextInt();
            }
        }
    }
}