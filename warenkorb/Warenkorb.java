package warenkorb;

import java.util.ArrayList;

public class Warenkorb {
    // initiiert Warenkorb der Artikel speichern kann
    private ArrayList<Artikel> warenkorb;

    public Warenkorb() {
        this.warenkorb = new ArrayList<>();
    }

    public void addWaren(Artikel artikel) {
        warenkorb.add(artikel);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Artikel artikel : warenkorb) {
            sb.append(artikel.toString()).append("\n");
        }
        return sb.toString();
    }

    public ArrayList<Artikel> getWarenkorb() {
        return warenkorb;
    }

    public void setWarenkorb(ArrayList<Artikel> warenkorb) {
        this.warenkorb = warenkorb;
    }
}