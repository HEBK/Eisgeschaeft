package eu.flrkv.hebk.eisgeschaeft;

import java.util.InputMismatchException;

public class Menu {

    private String name;

    public Menu(String companyName)
    {
        this.name = companyName;
    }

    public void printHeader()
    {
        System.out.println("------------->> " + name + " <<-------------");
    }

    public void nonExistingProduct()
    {
        this.clearConsole();
        printHeader();
        System.out.println("Das gewünschte Produkt existiert nicht!");
        printHeader();
        this.sleep(2);
    }

    public void storeIsClosed()
    {
        printHeader();
        System.out.println("Wir haben geschlossen!");
        printHeader();
    }

    public void thankyou()
    {
        this.clearConsole();
        printHeader();
        System.out.println("Wir bedanken uns für Ihren Einkauf!");
        printHeader();
        this.sleep(2);
    }


    /**
     * Clears the console output
     */
    public void clearConsole()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Lets the Thread sleep a defined time
     * @param pSeconds Time in seconds to sleep
     */
    public void sleep(long pSeconds)
    {
        try {
            Thread.sleep(pSeconds * 1000);
        } catch (InterruptedException e) {}
    }
}
