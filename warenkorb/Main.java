package warenkorb;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// break variable for while loop
		boolean running = true;
		// Scanner object
		Scanner scanner = new Scanner(System.in);
		Artikel.initiateWaren();
		String Fehler = "Ungültige Eingabe. Bitte versuchen Sie es erneut.";
		ArrayList<Kunde> Kundenliste = new ArrayList<>();
		Kunde k1 = new Kunde("", "", "", "");

		// begin the program
		while (running == true) {
			System.out.println("Wilkommen in Ihrem Herr der Ringe Fanshop. Wir wünschen viel Spaß und gutes Shopping!");

			// Beginn Login-Vorgang
			INNER: while (true) {
				System.out.println("(a) Neuer Kunde   (b) Login");
				String Log = scanner.nextLine();
				switch (Log) {
				case ("b") -> { // Fall: Bekannter Kunde
					System.out.println("Ihre Kundennummer: ");
					int Knr = scanner.nextInt();

					for (int i = 0; i < Kundenliste.size(); i++) {
						if (Kundenliste.get(i).getKundenNummer() == Knr) {
							k1 = Kundenliste.get(i);
							System.out.println("Willkommen, " + k1.getVorName() + "!");
							scanner.nextLine();
							break INNER;
							// Kundennummer ist vorhanden
						}
					}
					// Neustart Login Vorgang
					System.out.println("Daten nicht vorhanden. Versuchen Sie es erneut.");
					scanner.nextLine();
					continue;
				}
				default -> { // Fall: Neuer Kunde
					k1 = Kunde.kundenKontoErstellen();
					System.out.println("Kundendaten speichern? Y/N"); // Speicher-Dialog
					String speich = scanner.nextLine();
					if (speich.equals("Y") | speich.equals("y")) {
						Kundenliste.add(k1);
						System.out.print("Daten gespeichert. Kundennummer: " + k1.getKundenNummer() + "\n");
					}
				}
				}
				break;
			} // Ende Login-Vorgang

			// Beginn Einkauf
			System.out.println("Möchten Sie sehen, welche Waren wir im Angebot haben? Y/N");

			String i = scanner.nextLine();
			if (i.equals("Y") | i.equals("y")) {
				Artikel.printWaren();
				k1.addToWarenkorb();
				OUTER: while (true) {
					System.out.println(
							"Was möchten Sie tun?\n(a) Artikel hinzufügen\n(b) Anzahl der Artikel im Warenkorb ändern\n(c) Warenkorb anzeigen\n(d) Sortiment anzeigen\n(e) Meine Daten ändern\n(f) Zur Kasse gehen \n(g) Bestellvorgang abbrechen");
					String f = scanner.nextLine();
					switch (f) {
					case "a" -> { // Hinzufügen
						k1.addToWarenkorb();
						continue;
					}
					case "b" -> { // Anzahl ändern
						k1.changeAnzahl();
						continue;
					}
					case "c" -> { // Warenkorb anzeigen
						if (k1.getWarenkorb().getTotal() > 0) {
							if (k1.warenkorbShowAndConfig() == true) {
								continue;
							} else {
								break OUTER;
							}
						} else { // Warenkorb anzeigen -> ist leer
							System.out.println("Ihr Warenkorb ist leer!");
							continue;
						}
					}
					case "d" -> { // Sortiment anzeigen
						Artikel.printWaren();
						continue;
					}
					case "e" -> { // Kundendaten ändern
						Kunde.changeDaten(k1);
						continue;
					}

					case "f" -> { // Bestellung abschließen
						k1.endBestellung();
						break OUTER;
					}
					case "g" -> { // Bestellung abbrechen
						System.out.println("Bestellungvorgang abgebrochen.");
						break OUTER;
					}
					default -> { // Ungültige Eingabe
						System.out.println(Fehler);
						continue;
					}
					} // Ende switch
				}
			} // Ende großes if
			else if (!i.equals("N") && !i.equals("n")) { // Ungültige Eingabe, ablehnen
				System.out.println(Fehler);
			}

			INNER2: while (running == true) {
				System.out.println("(a) Neuer Kunde (b) Exit");
				String Ende = scanner.nextLine();
				switch (Ende) {
				case ("b") -> {
					System.out.println("Auf Wiedersehen.");
					running = false;
				}
				case ("a") -> {
					break INNER2;
				}
				default -> { // Ungültige Eingabe
					System.out.println(Fehler);
					continue;
				}
				}
			} // Ende End-Dialog
		} // Ende großer while-Loop
		scanner.close();
	}
}
