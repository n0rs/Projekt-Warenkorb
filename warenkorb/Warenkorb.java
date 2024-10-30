package warenkorb;

import java.util.ArrayList;

public class Warenkorb {
	// initiiert Warenkorb der Artikel speichern kann
	private ArrayList<Artikel> warenkorb;

	// Der Warenkorb Konstruktor erstellt nur eine ArrayList in der Artikel
	// gespeichert werden können
	public Warenkorb() {
		this.warenkorb = new ArrayList<>();
	}

	public void addWaren(Artikel artikel) {
		warenkorb.add(artikel);
	}

	// (Liv) Rechnet den Preis der Artikel im Warenkorb mit einer for-schleife
	// zusammen
	// Ich musste hier Math.round benutzen & einmal *100 & /100 rechnen, damit keine
	// Rundungsfehler rauskommen
	public double getTotal() {
		double total = 0;
		for (int i = 0; i < warenkorb.size(); i++) {
			total += (warenkorb.get(i).getArtikelPreis());
		}

		return Math.round(100.0 * total) / 100.0;
	}

	// (Liv) entfernt alle Elemente aus dem Warenkorb ArrayList
	public void clearWaren() {
		warenkorb.clear();
	}

	// (Liv) getTotal() zu toString() hinzugefügt
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Artikel artikel : warenkorb) {
			sb.append(artikel.toString()).append("\n");
		}
		return sb.toString() + "Total: " + getTotal() + "€";
	}

	// Getter/Setter
	public ArrayList<Artikel> getWarenkorb() {
		return warenkorb;
	}

	public void setWarenkorb(ArrayList<Artikel> warenkorb) {
		this.warenkorb = warenkorb;
	}
}