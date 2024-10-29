package warenkorb;

public class Main {
    public static void main(String[] args) {
        System.out.println("Wilkommen in ihrem Herr der Ringe Fanshop. Viel Spaß und gutes shopping.\n");
        Kunde k1 = new Kunde("Max", "Mustermann", "Musterstraße 3", "Musterstraße3");
        Kunde k2 = new Kunde("Maxine", "Musterfrau", "Musterweg 12", "Musterweg 12");
        Artikel.initiateWaren();
        Artikel.printWaren();
        System.out.println(k1.getKundenNummer());
        System.out.println(k2.getKundenNummer());
        k1.addToWarenkorb(Artikel.waren.get(0));
        k2.addToWarenkorb(Artikel.waren.get(9));
        System.out.println(k1.getLieferAdresse());
        System.out.println(k2.getLieferAdresse());
        System.out.println(k1.getWarenkorb());
        System.out.println(k2.getWarenkorb());
    }
}
