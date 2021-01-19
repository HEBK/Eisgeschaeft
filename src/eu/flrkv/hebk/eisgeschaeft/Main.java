package eu.flrkv.hebk.eisgeschaeft;

class Main {
    public static void main(String[] args) {

        Geschaeft g1 = new Eisroyal("Delcios Eisbude");


        g1.addProduct(new Produkt("Spaghettieis", 1.99, new String[]{"Spaghettis", "Vanille", "Milch"}));
        g1.addProduct(new Produkt("Erdbeereis", 1.95, new String[]{"Erdbeeren", "Zucker", "Milch"}));
        g1.addProduct(new Produkt("Vanilleeis", .99, new String[]{"Vanille", "Zucker", "Milch"}));
        g1.addProduct(new Produkt("Schokoeis", 1.50, new String[]{"Schokolade", "Salz", "Milch"}));
        g1.addProduct(new Produkt("Cookieeis (Ja, die aus dem Browser!)", 2, new String[]{"Kekse", "Schokolade", "Milch"}));

        g1.setStoreStatus(false);
        g1.run();
    }
}
