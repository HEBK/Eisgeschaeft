package eu.flrkv.hebk.eisgeschaeft;

import java.util.*;
import java.text.DecimalFormat;


public class Geschaeft  {

    protected boolean offen = false;
    protected String geschaeftname;
    protected List<Produkt> verkaufteProdukte = new ArrayList<Produkt>();
    protected List<Produkt> produkte = new ArrayList<Produkt>();
    protected Menu menu;
    private DecimalFormat f = new DecimalFormat("#0.00");
    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructor of class Geschaeft
     * @param pName Name of the new store
     */
    public Geschaeft(String pName) {
        this.geschaeftname = pName;
        this.menu = new Menu(pName);
    }

    public void verkaufen(int pProductNo) {
        menu.clearConsole();
        Produkt p = produkte.get(pProductNo);
        System.out.print("Das gewählte Eis kostet " + f.format(p.getPreisMwst()) + " €");
        menu.sleep(1);
        verkaufteProdukte.add(p);
        menu.thankyou();
    }

    /**
     * Adds a new Product to the stores product collection
     * @param pProdukt Product to add
     */
    public void addProduct(Produkt pProdukt) {
        produkte.add(pProdukt);
    }

    /**
     * Outputs all available Products
     */
    public void showAllProducts() {
        int i = 0;
        for(Produkt p: produkte) {
            i++;
            System.out.println(i + ". " + p.getName() + " - Preis: " + f.format(p.getPreisMwst()) + " €");
        }
    }

    /**
     * Sets the stores opening status
     * @param pStatus If is set to true, the store is opened
     */
    public void setStoreStatus(boolean pStatus){
        this.offen = pStatus;
    }

    /**
     * @return Returns true if store is opened
     */
    public boolean isOpened() {
        return this.offen;
    }

    /**
     * Shows all products that have been sold
     */
    public void showSalesResults()
    {
        menu.clearConsole();
        menu.printHeader();
        int i = 0;
        double umsatz = 0;
        for(Produkt p: verkaufteProdukte) {
            i++;
            System.out.println(i + ". " + p.getName() + " - Preis: " + f.format(p.getPreisMwst()) + " €");
            umsatz += p.getPreis();
        }
        if (umsatz == 0) {
            System.out.println("- Keine Einträge zu verkauften Artikeln vorhanden!");
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Umsatz (exkl. USt.) : " + f.format(umsatz) + " €");
        System.out.println("Zu zahlende USt. : " + f.format((umsatz*1.19)-umsatz) + " €");
        menu.printHeader();
        menu.sleep(10);
    }

    /**
     * Runs the menu etc.
     */
    public void run()
    {
        int x = 0;
        menu.clearConsole();

        if(!this.isOpened()) {
            menu.storeIsClosed();
        }

        else {
            while(true) {
                menu.clearConsole();
                menu.printHeader();
                System.out.println("Bitte wählen Sie die gewünschte Eissorte aus:");
                this.showAllProducts();
                System.out.println("0. Umsatz anzeigen");
                try {
                    x = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("The software ran into an error!");
                    System.out.println(e.getMessage());
                    System.exit(-1);
                }

                if (x != 0) {
                    try {
                        this.verkaufen(x - 1);
                    } catch (IndexOutOfBoundsException e) {
                        menu.nonExistingProduct();
                    }
                } else {
                    this.showSalesResults();
                }
            }
        }
    }
}