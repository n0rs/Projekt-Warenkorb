import java.util.ArrayList;

public class Artikel {
    static ArrayList<Artikel> waren = new ArrayList<>();
    int artikelNummer;
    double artikelPreis;
    String artikelBezeichnung;

    public Artikel (int artikelNummer, double artikelPreis, String artikelBezeichnung){
        this.artikelNummer = artikelNummer;
        this.artikelPreis = artikelPreis;
        this.artikelBezeichnung = artikelBezeichnung;
    }


    public int getArtikelNummer() {
        return artikelNummer;
    }
    public void setArtikelNummer(int artikelNummer) {
        this.artikelNummer = artikelNummer;
    }
    public String getArtikelBezeichnung() {
        return artikelBezeichnung;
    }
    public void setArtikelBezeichnung(String artikelBezeichnung) {
        this.artikelBezeichnung = artikelBezeichnung;
    }
    public double getArtikelPreis() {
        return artikelPreis;
    }
    public void setArtikelPreis(double artikelPreis) {
        this.artikelPreis = artikelPreis;
    }
    
    
    public static void main(String[] args) {
        Artikel artikel1 = new Artikel(1, 19.99, "Der Herr der Ringe - Die Gefährten");
        Artikel artikel2 = new Artikel(2, 19.99, "Der Herr der Ringe - Die zwei Türme");
        Artikel artikel3 = new Artikel(3, 19.99, "Der Herr der Ringe - Die Rückkehr des Königs");
        Artikel artikel4 = new Artikel(4, 5.00, "Der Herr der Ringe - Notizbuch");
        Artikel artikel5 = new Artikel(5, 3.99, "Der Herr der Ringe - Kartenhüllen 100er Pack");
        Artikel artikel6 = new Artikel(6, 24.99, "You shall not pass! T-shirt");
        Artikel artikel7 = new Artikel(7, 99.99, "Sauron Actionfigur");
        Artikel artikel8 = new Artikel(8, 7.99, "Frodo Stressball");
        Artikel artikel9 = new Artikel(9, 5.99, "Der Herr der Ringe - Sammelkartenpack");
        Artikel artikel10 = new Artikel(10, 2599.99, "The One Ring - Original Filmrequisite");
        waren.add(artikel1);
        waren.add(artikel2);
        waren.add(artikel3);
        waren.add(artikel4);
        waren.add(artikel5);
        waren.add(artikel6);
        waren.add(artikel7);
        waren.add(artikel8);
        waren.add(artikel9);
        waren.add(artikel10);


        for (Artikel artikel: waren) {
            System.out.print(artikel.artikelNummer+ " | ");
            System.out.print(artikel.artikelBezeichnung+ " | ");
            System.out.println(artikel.artikelPreis);
        }

    }
}
