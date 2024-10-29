package warenkorb;

import java.util.ArrayList;
import java.util.Collections;


public class Artikel {
    // ArrayList die alle Artikel speichert
    static ArrayList<Artikel> waren = new ArrayList<>(); 

    // Attribute der Artikel
    private int artikelNummer;
    private double artikelPreis;
    private String artikelBezeichnung;

    // Artikel Konstruktor 
    public Artikel (int artikelNummer, double artikelPreis, String artikelBezeichnung) {
        this.artikelNummer = artikelNummer;
        this.artikelPreis = artikelPreis;
        this.artikelBezeichnung = artikelBezeichnung;
    }

    public static void initiateWaren() {
        // erstellt 10 Artikel im Herr der Ringe Fanshop
        Artikel a1 = new Artikel(1, 19.99, "Der Herr der Ringe - Die Gefährten");
        Artikel a2 = new Artikel(2, 19.99, "Der Herr der Ringe - Die zwei Türme");
        Artikel a3 = new Artikel(3, 19.99, "Der Herr der Ringe - Die Rückkehr des Königs");
        Artikel a4 = new Artikel(4, 5.00, "Der Herr der Ringe - Notizbuch");
        Artikel a5 = new Artikel(5, 3.99, "Der Herr der Ringe - Kartenhüllen 100er Pack");
        Artikel a6 = new Artikel(6, 24.99, "You shall not pass! T-shirt");
        Artikel a7 = new Artikel(7, 99.99, "Sauron Actionfigur");
        Artikel a8 = new Artikel(8, 7.99, "Frodo Stressball");
        Artikel a9 = new Artikel(9, 5.99, "Der Herr der Ringe - Sammelkartenpack");
        Artikel a10 = new Artikel(10, 2599.99, "The One Ring - Original Filmrequisite");
        // Fügt alle Artikel zur "waren" ArrayList hinzu
        Collections.addAll(waren, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
    }

    public static void printWaren() {
        // for-each loop, der 
        for (Artikel artikel: waren) {
            System.out.print(artikel.artikelNummer+ " | ");
            System.out.print(artikel.artikelBezeichnung+ " | ");
            System.out.println(artikel.artikelPreis);
        }
    }

    // dadurch können wir den Inhalt des Artikels als String printen und nicht als Objekt (Warenkorb@Zahl)
    @Override
    public String toString() {
        return "Artikelnummer: " + artikelNummer + "; Name: " + artikelBezeichnung + "; Preis: " + artikelPreis + " Euro";
    }

    public int getArtikelNummer() {
        return artikelNummer;
    }

    public void setArtikelNummer(int artikelNummer) {
        this.artikelNummer = artikelNummer;
    }

    public double getArtikelPreis() {
        return artikelPreis;
    }

    public void setArtikelPreis(double artikelPreis) {
        this.artikelPreis = artikelPreis;
    }

    public String getArtikelBezeichnung() {
        return artikelBezeichnung;
    }

    public void setArtikelBezeichnung(String artikelBezeichnung) {
        this.artikelBezeichnung = artikelBezeichnung;
    }
}
