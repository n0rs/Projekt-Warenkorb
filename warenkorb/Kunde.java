package warenkorb;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Kunde {
	// Speichert Kundendaten
	static ArrayList<Kunde> Kundenliste = new ArrayList<>();
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
	private static final Scanner scanner = new Scanner(System.in);


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
		// Kundenkonto erstellen
		Kunde k;
		
		System.out.println("Bitte erstellen Sie Ihr Kundenkonto.");
		System.out.println("Nachname:");
		String kNachname = scanner.nextLine();
		System.out.println("Vorname:");
		String kVorName = scanner.nextLine();
		System.out.println("Lieferadresse:");
		String lAdresse = scanner.nextLine();
		System.out.println("Rechnungsadresse:");
		String kAdresse = scanner.nextLine();
		k = new Kunde(kVorName, kNachname, lAdresse, kAdresse);
		System.out.println("Kundendaten speichern? Y/N"); // Speicher-Dialog
		String save = scanner.nextLine().toLowerCase();
		if (save.equals("y")) {
			Kundenliste.add(k);
			System.out.print("Daten gespeichert. Kundennummer: " + k.getKundenNummer() + "\n");
		}
		return k;
	}

	public static Kunde changeDaten(Kunde k) {
		System.out.println(k);
		System.out.println("\nWelche Daten möchten Sie ändern?\n(1) Lieferadresse\n(2) Rechnungsadresse");

		try {
			int auswahl = scanner.nextInt();
			switch (auswahl) {
			case 2 -> {
				System.out.println("Geben Sie Ihre neue Rechnungsadresse ein:");
				scanner.nextLine();
				String newAdressR = scanner.nextLine();
				k.setRechnungsAdresse(newAdressR);
				System.out.println("Adresse geändert.\n");
			}
			case 1 -> {
				System.out.println("Geben Sie Ihre neue Lieferadresse ein:");
				scanner.nextLine();
				String newAdressL = scanner.nextLine();
				k.setLieferAdresse(newAdressL);
				System.out.println("Adresse geändert.\n");
			}
			default -> {
				return k;
			}
			}
		} catch (InputMismatchException | IndexOutOfBoundsException e) {
			System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.\n");
        	scanner.nextLine(); // Scanner-Fehler durch ungültige Eingabe zurücksetzen
		}
		return k;
		/* 
		if (scanner.hasNextInt()) {
			int auswahl = scanner.nextInt();
			switch (auswahl) {
			case 2 -> {
				System.out.println("Geben Sie Ihre neue Rechnungsadresse ein:");
				scanner.nextLine();
				String newAdressR = scanner.nextLine();
				k.setRechnungsAdresse(newAdressR);
				System.out.println("Adresse geändert.\n");
			}
			case 1 -> {
				System.out.println("Geben Sie Ihre neue Lieferadresse ein:");
				scanner.nextLine();
				String newAdressL = scanner.nextLine();
				k.setLieferAdresse(newAdressL);
				System.out.println("Adresse geändert.\n");
			}
			default -> {
				return k;
			}
			}
		} else {
			System.out.println("Bitte versuchen Sie es erneut");
		}
		// scannerD.close();
		return k;*/ //testtestsetestejsejkrs
	}

	public boolean warenkorbShowAndNavi() {

		System.out.println(getWarenkorb() + lineSep() + "\n(a) Warenkorb leeren" + "   " + "(b) Bestellung abbrechen"
				+ "   " + "(c) Zur Kasse gehen" + "   (d) Einkauf fortsetzen");

		try {
			scanner.nextLine();
			String auswahl = scanner.nextLine();
			switch (auswahl) {
			case "a" -> {
				warenkorb.clearWaren();
				System.out.println("Warenkorb geleert.");
				return true;
			}
			case "b" -> {
				System.out.println("Bestellung abgebrochen.");
				return false;
			}
			case "c" -> {
				endBestellung();
				return false;
			}
			default -> {
				return true;
			}
		}
	} catch (InputMismatchException | IndexOutOfBoundsException e) {
		System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.\n");
        scanner.nextLine(); // Scanner-Fehler durch ungültige Eingabe zurücksetzen
	}
		return true;
	}

	// Aufruf Warenkorb.addWaren Methode
	public void addToWarenkorb() {
		System.out.println(
				"Bitte fügen Sie jetzt etwas Ihrem Warenkorb hinzu.\nGeben Sie die Artikelnummer und die Anzahl an, die Sie hinzufügen möchten.");

		try {
			Artikel artikel = Artikel.waren.get(scanner.nextInt() - 1);
			System.out.println("Anzahl: ");

			int addAnzahl = scanner.nextInt();
			warenkorb.addWaren(artikel, addAnzahl);
			scanner.nextLine();

		} catch (InputMismatchException | IndexOutOfBoundsException  e) {
			System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.");
			scanner.nextLine();
		}
		/* 
		if (scanner.hasNextInt()) {
			Artikel artikel = Artikel.waren.get(scanner.nextInt() - 1);
			System.out.println("Anzahl: ");
			if (scanner.hasNextInt()) {
				int addAnzahl = scanner.nextInt();
				warenkorb.addWaren(artikel, addAnzahl);
			} else {
				System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.");
			}
		} else {
			System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.");
		}*/
	}

	// Aufruf Warenkorb.changeAnzahlW Methode
	public void changeAnzahl() {
		System.out.println("Bitte geben Sie die Artikelnummer ein und anschließend die gewünschte Anzahl:");

    try {
        int artikelNummer = scanner.nextInt();
        Artikel artikel = Artikel.waren.get(artikelNummer - 1);

        System.out.print("Neue Anzahl: ");
        int anzahl = scanner.nextInt();

        warenkorb.changeAnzahlW(artikel, anzahl);
		scanner.nextLine();
    } catch (InputMismatchException | IndexOutOfBoundsException e) {
        System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.\n");
        scanner.nextLine(); // Scanner-Fehler durch ungültige Eingabe zurücksetzen
    }
}
	/* System.out.println(
			"Ändern Sie die Anzahl eines Artikels durch Eingabe der Artikelnummer und der gewünschten neuen Anzahl.");
	if (scanner.hasNextInt()) {
		Artikel artikel = Artikel.waren.get(scanner.nextInt() - 1);
		System.out.println("Anzahl: ");
		if (scanner.hasNextInt()) {
			int Anzahl = scanner.nextInt();
			warenkorb.changeAnzahlW(artikel, Anzahl);
		} else {
			System.out.println("Untültige Eingabe. Bitte versuchen Sie es erneut.\n");
		}
	} else {
		System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.\n");
	}
	}*/

	// Aufruf Warenkorb.clearWaren Methode
	public void clearWarenkorb() {
		warenkorb.clearWaren();
	}
	

	// Aufruf Warenkorb.calcShipping Methode
	public double prizeShipping() {
		return warenkorb.calcShipping();
	}

	// um Bestellbestätigung schöner zu printen
	public String lineSep() {
		return "\n-----------------------------------";
	}

	// gibt Bestellbestätigung aus
	public void endBestellung() {

		if (warenkorb.getTotal() > 0) {
			System.out.println("\nÜbersicht\n\n" + toString() + lineSep() + "\n" + warenkorb.toString() + lineSep()
					+ "\nVielen Dank für Ihre Bestellung!");
		} else {
			System.out.println("\nÜbersicht\n\n" + toString() + lineSep() + "\n" + warenkorb.toString() + lineSep()
					+ "\nBestellvorgang abgebrochen");
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
