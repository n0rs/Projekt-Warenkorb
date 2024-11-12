package warenkorb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Warenkorb {
	// initiiert Warenkorb der Artikel speichern kann
	ArrayList<Artikel> warenkorb;

	// Konstruktor erstellt nur eine ArrayList in der Artikel
	// gespeichert werden können
	public Warenkorb() {
		this.warenkorb = new ArrayList<>();
	}

	// fügt Artikel zum Warenkorb hinzu
	public void addWaren(Artikel artikel, int addAnzahl) {

		if (warenkorb.size() + addAnzahl <= 100 && addAnzahl > 0) {
			while (addAnzahl > 0) {
				warenkorb.add(artikel);
				addAnzahl--;
			}
			System.out.println("Artikel hinzugefügt.\n" + lineSep());
		} else if (addAnzahl <= 0) {
			System.out.println("Ungültige Eingabe. Anzahl muss einen Wert über 0 haben.\n");
		} else {
			System.out.println(
					"Warenkorb fasst max. 100 Artikel. Ihr aktueller Warenkorb: " + warenkorb.size() + " Elemente.\n");
		}
	}

	// berechnet den Gesamtpreis der Artikel im Warenkorb
	public double getTotal() {
		// Ich musste hier Math.round benutzen & einmal *100 & /100 rechnen, damit keine
		// Rundungsfehler rauskommen
		double total = 0;
		for (int i = 0; i < warenkorb.size(); i++) {
			total += (warenkorb.get(i).getArtikelPreis());
		}

		return Math.round(100.0 * total) / 100.0;
	}

	// berechnet die Versandkosten, die separat ausgewiesen werden
	public double calcShipping() {

		double s1 = 5.95;
		double s2 = 2.95;
		double s3 = 0.00;

		if (getTotal() <= 20 && getTotal() > 0) {
			return s1;
		} else if (getTotal() > 20 && getTotal() <= 50) {
			return s2;
		} else {
			return s3;
		}
	}

	// verändert die Anzahl eines Artikels im Warenkorb, berücksichtigt vorhandene
	// Artikel
	public void changeAnzahlW(Artikel artikel, int Anzahl) {

		// Überprüfung max. Anzahl
		if (((warenkorb.size() - Collections.frequency(warenkorb, artikel)) + Anzahl <= 100 && Anzahl >= 0)
				| (warenkorb.size() + Anzahl <= 100 && Anzahl >= 0)) {

			if (Anzahl == 0) { // Anzahl 0 = Artikel werden entfernt
				removeallArtikelx(artikel);
			} else if (Anzahl > Collections.frequency(warenkorb, artikel)) { // Anzahl erhöhen
				int diff = Anzahl - Collections.frequency(warenkorb, artikel);
				while (diff > 0) {
					warenkorb.add(artikel);
					diff--;
				}
				System.out
						.println("Anzahl \"" + artikel.getArtikelBezeichnung() + "\" auf \"" + Anzahl + "\" geändert.");
			} else if (Anzahl < Collections.frequency(warenkorb, artikel)) { // Anzahl verringern
				int diff = Collections.frequency(warenkorb, artikel) - Anzahl;
				while (diff > 0) {
					warenkorb.remove(artikel);
					diff--;
				}
				System.out
						.println("Anzahl \"" + artikel.getArtikelBezeichnung() + "\" auf \"" + Anzahl + "\" geändert.");
			} else if (Anzahl == Collections.frequency(warenkorb, artikel)) { // Anzahl entspricht vorhandener Anzahl
				System.out.println(
						"Hinweis: '" + artikel.getArtikelBezeichnung() + "' ist bereits " + Anzahl + "-mal vorhanden.");
			}

		} else if (Anzahl < 0) { // Fall: negative/ungültige Eingabe
			System.out.println("Ungültige Eingabe. Anzahl darf keinen negativen Wert haben.");
		} else { // Fall: über 100 Artikel
			System.out.println(
					"Warenkorb fasst max. 100 Artikel. Ihr aktueller Warenkorb: " + warenkorb.size() + " Elemente.");
		}
	}

	// entfernt alle Artikel vom Typ x aus der ArrayList
	public void removeallArtikelx(Artikel artikel) {

		int artikelx = Collections.frequency(warenkorb, artikel);

		while (artikelx > 0) {
			warenkorb.remove(artikel);
			artikelx--;
		}
		System.out.println("Alle Artikel vom Typ \"" + artikel.getArtikelBezeichnung() + "\" entfernt.");
	}

	// entfernt alle Elemente aus dem Warenkorb ArrayList
	public void clearWaren() {
		warenkorb.clear();
	}

	// ToString
	@Override
	public String toString() {

		if (warenkorb.isEmpty() == false) {
			warenkorb.sort(Comparator.comparing(Artikel::getArtikelNummer));
			if (warenkorb.size() <= 10) {
				StringBuilder sb = new StringBuilder();
				for (Artikel artikel : warenkorb) {
					sb.append(artikel.toString()).append("\n");
				}
				return sb.toString() + lineSep() + "Total: " + getTotal() + " €" + "\nVersand: " + calcShipping()
						+ " €";
			} else {
				StringBuilder s2 = new StringBuilder();
				for (Artikel artikel : Artikel.waren) {
					if (Collections.frequency(warenkorb, artikel) >= 1) {
						s2.append(artikel.toString() + "; Anzahl: " + Collections.frequency(warenkorb, artikel))
								.append("\n");
					} else {
						continue;
					}
				}
				return s2.toString() + lineSep() + "Total: " + getTotal() + " €" + "\nVersand: " + calcShipping()
						+ " €";
			}
		} else {
			return "Der Warenkorb ist leer.";
		}
	}

	// um toString() übersichtlicher zu machen
	public String lineSep() {
		return "-----------------------------------\n";
	}

	// Getter/Setter
	public ArrayList<Artikel> getWarenkorb() {
		return warenkorb;
	}

	public void setWarenkorb(ArrayList<Artikel> warenkorb) {
		this.warenkorb = warenkorb;
	}
}
