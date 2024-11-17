package warenkorb;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// break variable for while loop
		boolean running = true;
		// Scanner object
		Scanner scanner = new Scanner(System.in);
		Artikel.initiateWaren();
		String Fehler = "Ungültige Eingabe. Bitte versuchen Sie es erneut.";
		Kunde k = new Kunde("", "", "", "");

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

					for (int i = 0; i < Kunde.Kundenliste.size(); i++) {
						if (Kunde.Kundenliste.get(i).getKundenNummer() == Knr) {
							k = Kunde.Kundenliste.get(i);
							System.out.println("Willkommen, " + k.getVorName() + "!");
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
					k = Kunde.kundenKontoErstellen();
				}
				}
				break;
			} // Ende Login-Vorgang

			// Beginn Einkauf
			System.out.println("Möchten Sie sehen, welche Waren wir im Angebot haben? Y/N");

			String i = scanner.nextLine();
			if (i.equals("Y") | i.equals("y")) {
				Artikel.printWaren();
				k.addToWarenkorb();
				OUTER: while (true) {
					System.out.println(
							"Was möchten Sie tun?\n(a) Artikel hinzufügen\n(b) Anzahl der Artikel im Warenkorb ändern\n(c) Warenkorb anzeigen\n(d) Sortiment anzeigen\n(e) Meine Daten ändern\n(f) Zur Kasse gehen \n(g) Bestellvorgang abbrechen");
					String f = scanner.nextLine();
					switch (f) {
					case "a" -> { // Hinzufügen
						k.addToWarenkorb();
						continue;
					}
					case "b" -> { // Anzahl ändern
						k.changeAnzahl();
						continue;
					}
					case "c" -> { // Warenkorb anzeigen
						if (k.getWarenkorb().getTotal() > 0) {
							if (k.warenkorbShowAndConfig() == true) {
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
						Kunde.changeDaten(k);
						continue;
					}

					case "f" -> { // Bestellung abschließen
						k.endBestellung();
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