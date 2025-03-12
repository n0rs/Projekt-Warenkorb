package de.rhkoeln.warenkorb;

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

	// berechnet den Gesamtpreis der Artikel im Warenkorb
	public double calcTotal() {
		// Math.round benutzt & einmal *100 & /100 gerechnet, damit keine Rundungsfehler rauskommen
		double total = 0;
		for (int i = 0; i < warenkorb.size(); i++) {
			total += (warenkorb.get(i).getArtikelPreis());
		}

		return Math.round(100.0 * total) / 100.0;
	}

	// berechnet die Versandkosten, basierend auf dem Gesamtpreis
	public double calcShipping() {

		double s1 = 5.95;
		double s2 = 2.95;
		double s3 = 0.00;

		if (calcTotal() <= 20 && calcTotal() > 0) {
			return s1;
		} else if (calcTotal() > 20 && calcTotal() <= 50) {
			return s2;
		} else {
			return s3;
		}
	}

	// berechnet Gesamtkosten
	public double calcGesamtSumme() {

		double summe = calcTotal() + calcShipping();
		return Math.round(100.0 * summe) / 100.0;
	}

	// verändert die Anzahl eines Artikels im Warenkorb, berücksichtigt vorhandene
	// Artikel
	public void changeAnzahlW(Artikel artikel, int Anzahl) {
		int aktuelleAnzahl = Collections.frequency(warenkorb, artikel);
		int warenkorbGroesse = warenkorb.size();
		int differenz = Anzahl - aktuelleAnzahl;

		// Überprüfung auf ungültige Eingaben
		if (Anzahl < 0) {
			System.err.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.");
			return;
		}

		// Überprüfung, ob die gewünschte Anzahl bereits vorhanden ist
		if (differenz == 0) {
			System.out.println(
					"Hinweis: '" + artikel.getArtikelBezeichnung() + "' ist bereits " + Anzahl + "-mal vorhanden.");
			return;
		}

		// Überprüfung, ob die neue Anzahl die Warenkorbbeschränkung überschreitet
		if (warenkorbGroesse - aktuelleAnzahl + Anzahl > 100) {
			System.err.println(
					"Warenkorb fasst max. 100 Artikel. Ihr aktueller Warenkorb: " + warenkorbGroesse + " Elemente.");
			return;
		}

		// Entfernen des Artikels, wenn die Anzahl auf 0 gesetzt wird
		if (Anzahl == 0) {
			removeallArtikelx(artikel);
			return;
		}

		// Aktualisieren der Anzahl der Artikel im Warenkorb
		if (differenz > 0) {
			for (int i = 0; i < differenz; i++) {
				warenkorb.add(artikel);
			}
		} else {
			for (int i = 0; i < -differenz; i++) {
				warenkorb.remove(artikel);
			}
		}

		System.out.println("Anzahl \"" + artikel.getArtikelBezeichnung() + "\" auf \"" + Anzahl + "\" geändert.");
	}

	// entfernt alle Artikel vom Typ x aus dem Warenkorb
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

	// Überschreiben der toString Methode um Warenkorb lesbar auszugeben
	@Override
	public String toString() {

		if (warenkorb.isEmpty()) {
			return "Der Warenkorb ist leer.";
		}

		StringBuilder sb = new StringBuilder();
		warenkorb.sort(Comparator.comparing(Artikel::getArtikelNummer));
		

		// Zusammengefasste Ausgabe
		Artikel.waren.stream()
					.filter(artikel -> Collections.frequency(warenkorb, artikel) > 0)
					.forEach(artikel -> sb
							.append(String.format("%-15s %-55s %-20s %-10s%n",
								"Artikelnr. " + artikel.getArtikelNummer() + ";",
								"Name: " + artikel.getArtikelBezeichnung() + ";",
								"Preis: " + artikel.getArtikelPreis() + " €;",
								"Anzahl: " + Collections.frequency(warenkorb, artikel))));

		sb.append(lineSep())
			.append("Total: ").append(calcTotal()).append(" €")
			.append("\nVersand: ").append(calcShipping()).append(" €")
			.append("\nSumme: ").append(calcGesamtSumme()).append(" €");
		return sb.toString();
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
