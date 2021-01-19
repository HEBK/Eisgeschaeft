package eu.flrkv.hebk.eisgeschaeft;

public class Menu {

    private String name;
    public Menu(String companyName) {
        this.name = companyName;
    }

    public void printHeader() {
        System.out.println("------------->> " + name + " <<-------------");
    }



    public void storeIsClosed() {
        printHeader();
        System.out.println("Wir haben geschlossen!");
        printHeader();
    }


    public void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }





}
