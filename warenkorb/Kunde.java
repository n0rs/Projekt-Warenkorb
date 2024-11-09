package warenkorb;

import java.util.Scanner;

public class Kunde {
	// Attribute
	private Warenkorb warenkorb;
	private int kundenNummer;
	private String lieferAdresse;
	private String rechnungsAdresse;
	private String vorName;
	private String nachName;
	// Counter wird benutzt um kundenNummer bei jedem Aufrufen des Konstruktors um 1
	// zu erhöhen
	private static int counter = 1;
	// Scanner object erstellen

	// Konstruktor
	public Kunde(String vorName, String nachName, String lieferAdresse, String rechnungsAdresse) {
		kundenNummer = counter++;
		this.vorName = vorName;
		this.nachName = nachName;
		this.lieferAdresse = lieferAdresse;
		this.rechnungsAdresse = rechnungsAdresse;
		this.warenkorb = new Warenkorb();
		// kundenNummer und warenkorb als sich ändernde Objekte
		// eventuell müssen wir die Lieferadresse auch so behandeln wenn wir die ändern
		// wollen
	}

	public static Kunde kundenKontoErstellen() {
		Kunde k;
		Scanner scanner = new Scanner(System.in);
		// Kundenkonto erstellen
		System.out.println("Bitte erstellen Sie Ihr Kundenkonto.");
		System.out.println("Nachname:");
		String kNachname = scanner.nextLine();
		System.out.println("Vorname:");
		String kVorName = scanner.nextLine();
		System.out.println("Adresse:");
		String kAdresse = scanner.nextLine();
		k = new Kunde(kVorName, kNachname, kAdresse, kAdresse);
		return k;
	}

	// Aufruf Warenkorb.addWaren Methode
	public void addToWarenkorb() {
		System.out.println(
						"Bitte fügen Sie jetzt etwas Ihrem Warenkorb hinzu.\nGeben Sie die Artikelnummer und die Anzahl an, die Sie hinzufügen möchten.");
		Scanner scanner = new Scanner(System.in);
		Artikel artikel = Artikel.waren.get(scanner.nextInt() - 1);
		int addAnzahl = scanner.nextInt();
		warenkorb.addWaren(artikel, addAnzahl);
	}

	// Aufruf Warenkorb.changeAnzahlW Methode
	public void changeAnzahl() {
		System.out.println("Ändern Sie die Anzahl eines Artikels durch Eingabe der Artikelnummer und der gewünschten neuen Anzahl.");
		Scanner scanner = new Scanner(System.in);
		Artikel artikel = Artikel.waren.get(scanner.nextInt() - 1);
		int Anzahl = scanner.nextInt();
		warenkorb.changeAnzahlW(artikel, Anzahl);
	}

	// Aufruf Warenkorb.clearWaren Methode
	public void clearWarenkorb() {
		warenkorb.clearWaren();
	}

	// Aufruf Warenkorb.calcShipping Methode
	public double prizeShipping() {
		return warenkorb.calcShipping();
	}

	// um Bestellbestätigung einfacher zu printen
	public String lineSep() {
		return "\n-----------------------------------\n";
	}

	// gibt Bestellbestätigung aus
	public void endBestellung() {
		if (warenkorb.getTotal() > 0) {
			System.out.println("\nÜbersicht\n\n" + toString() + lineSep() + warenkorb.toString() + lineSep()
					+ "Vielen Dank für Ihre Bestellung!");
		} else {
			System.out.println("\nÜbersicht\n\n" + toString() + lineSep() + warenkorb.toString() + lineSep()
					+ "Bestellvorgang abgebrochen");
		}
	}

	@Override
	public String toString() {
		return "Name: " + vorName + " " + nachName + "\nLieferadresse: " + lieferAdresse + "\nRechnungsadresse: "
				+ rechnungsAdresse + "\nKundennummer: " + kundenNummer;
	}

	// Getter und Setter für alle Attribute außer counter
	// Wir sollten am Ende schauen, welche der Getter/Setter nicht verwendet werden
	public int getKundenNummer() {
		return kundenNummer;
	}

	public void setKundenNummer(int kundenNummer) {
		this.kundenNummer = kundenNummer;
	}

	public String getLieferAdresse() {
		return lieferAdresse;
	}

	public void setLieferAdresse(String lieferAdresse) {
		this.lieferAdresse = lieferAdresse;
	}

	public String getRechnungsAdresse() {
		return rechnungsAdresse;
	}

	public void setRechnungsAdresse(String rechnungsAdresse) {
		this.rechnungsAdresse = rechnungsAdresse;
	}

	public String getVorName() {
		return vorName;
	}

	public void setVorName(String vorName) {
		this.vorName = vorName;
	}

	public String getNachName() {
		return nachName;
	}

	public void setNachName(String nachName) {
		this.nachName = nachName;
	}

	public Warenkorb getWarenkorb() {
		return warenkorb;
	}

	public void setWarenkorb(Warenkorb warenkorb) {
		this.warenkorb = warenkorb;
	}
}
