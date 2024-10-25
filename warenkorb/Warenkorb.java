package warenkorb;

public class Warenkorb {
    int maxArtikel;
    public static void main(String[] args) {
        System.out.println("Wilkommen in ihrem Herr der Ringe Fanshop. Viel Spaß und gutes shopping.\n");
        Artikel.initiateWaren();
        Artikel.printWaren();
    }
}