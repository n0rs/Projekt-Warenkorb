package warenkorb;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// break variable for while loop
		boolean running = true;
		// Scanner object
		Scanner scanner = new Scanner(System.in);

		// begin the program
		while (running == true) {
			System.out
					.println("Wilkommen in Ihrem Herr der Ringe Fanshop. Wir wünschen viel Spaß und gutes Shopping!\n");
			Kunde k1 = new Kunde("Max", "Mustermann", "Musterstraße 3", "Musterstraße 3");
			Kunde k2 = new Kunde("Maxine", "Musterfrau", "Musterweg 12", "Musterweg 12");
			Kunde k3 = Kunde.kundenKontoErstellen();
			Artikel.initiateWaren();
			System.out.println("Möchten Sie sehen, welche Waren wir im Angebot haben? Y/N");
			String i = scanner.nextLine();
			if (i.equals("Y") | i.equals("y")) {
				Artikel.printWaren();
				k3.addToWarenkorb();
				OUTER: while (true) {
					System.out.println(
							"Was möchten Sie tun?\n(a) Artikel hinzufügen\n(b) Anzahl der Artikel im Warenkorb ändern\n(c) Warenkorb anzeigen\n(d) Sortiment anzeigen\n(e) Meine Daten ändern\n(f) Einkauf beenden");
					String f = scanner.nextLine();
					switch (f) {
					case "a" -> {
						k3.addToWarenkorb();
						continue;
					}
					case "b" -> {
						k3.changeAnzahl();
						continue;
					}
					case "c" -> {
						System.out.println(k3.getWarenkorb());
						continue;
					}
					case "d" -> {
						Artikel.printWaren();
						continue;
					}
					case "e" -> {
						Kunde.changeDaten(k3);
						continue;
					}
					default -> {
						break OUTER;
					}
					}
				}
				System.out.println("Dies ist Ihr aktueller Warenkorb:");
				System.out.println(k3.getWarenkorb());
				k3.endBestellung();
				running = false;
			} else if (i.equals("N") | i.equals("n")) {
				System.out.println("Bestellvorgang abgebrochen.");
				running = false;
			} else {
				System.out.println("Ungültige Eingabe, versuchen Sie es erneut.\n");
			}
		}
		scanner.close();
	}
}
