package warenkorb;

import java.util.ArrayList;

public class Warenkorb {
    // initiiert Warenkorb der Artikel speichern kann
    private ArrayList<Artikel> warenkorb;

    // Der Warenkorb Konstruktor erstellt nur eine ArrayList in der Artikel gespeichert werden können
    public Warenkorb() {
        this.warenkorb = new ArrayList<>();
    }

    public void addWaren(Artikel artikel) {
        warenkorb.add(artikel);
    }

    // Auch das ist nötig um den Warenkorb als String und nicht Pointer/Objekt/Warenkorb@125491 oder so auszugeben
    // Da hab ich allerdings auch keine Ahnung von und muss mich nochmal schlau machen
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Artikel artikel : warenkorb) {
            sb.append(artikel.toString()).append("\n");
        }
        return sb.toString();
    }

    // Getter/Setter 
    public ArrayList<Artikel> getWarenkorb() {
        return warenkorb;
    }
    public void setWarenkorb(ArrayList<Artikel> warenkorb) {
        this.warenkorb = warenkorb;
    }
}