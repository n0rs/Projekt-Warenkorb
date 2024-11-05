package warenkorb;

import java.util.ArrayList;
import java.util.Collections;

public class Warenkorb {
    // initiiert Warenkorb der Artikel speichern kann

	// Konstruktor erstellt nur eine ArrayList in der Artikel
	// gespeichert werden können
	public Warenkorb() {
		this.warenkorb = new ArrayList<>();
	}

	//fügt Artikel zum Warenkorb hinzu
	public void addWaren(Artikel artikel) {
		warenkorb.add(artikel);
	}

	//berechnet den Gesamtpreis der Artikel im Warenkorb 
	public double getTotal() {
		// Ich musste hier Math.round benutzen & einmal *100 & /100 rechnen, damit keine
		// Rundungsfehler rauskommen
		double total = 0;
		for (int i = 0; i < warenkorb.size(); i++) {
			total += (warenkorb.get(i).getArtikelPreis());
		}

		return Math.round(100.0 * total) / 100.0;
	}
	
	// verändert die Anzahl eines Artikels im Warenkorb
	public void changeAnzahlW(Artikel artikel, int Anzahl) {
		if (Anzahl > Collections.frequency(warenkorb, artikel)) {
			int diff = Anzahl - Collections.frequency(warenkorb, artikel);
			while (diff > 0) {
				warenkorb.add(artikel);
				diff--;
			}
		} else if (Anzahl < Collections.frequency(warenkorb, artikel)) {
			int diff = Collections.frequency(warenkorb, artikel) - Anzahl;
			while (diff > 0) {
				warenkorb.remove(artikel);
				diff--;
			}
		} else if (Anzahl == Collections.frequency(warenkorb, artikel)) {
			System.out.println(
					"Hinweis: '" + artikel.getArtikelBezeichnung() + "' ist bereits " + Anzahl + "-mal vorhanden.");
		} else if (Anzahl == 0) {
			removeallArtikelx(artikel);
		}
	}
	
	// entfernt alle Artikel vom Typ x aus der ArrayList
	public void removeallArtikelx(Artikel artikel) {

		int artikelx = Collections.frequency(warenkorb, artikel);

		while (artikelx > 0) {
			warenkorb.remove(artikel);
			artikelx--;
		}
	}
	
	// entfernt alle Elemente aus dem Warenkorb ArrayList
	public void clearWaren() {
		warenkorb.clear();
	}

	// ToString
	@Override
	public String toString() {
		// (Liv) getTotal() zu toString() hinzugefügt

		StringBuilder sb = new StringBuilder();
		for (Artikel artikel : warenkorb) {
			sb.append(artikel.toString()).append("\n");
		}
		return sb.toString() + "Total: " + getTotal() + "€";
	}


    public void setWarenkorb(ArrayList<Artikel> warenkorb) {
        this.warenkorb = warenkorb;
    }
}
