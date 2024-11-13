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

		// begin the program

		while (running == true) {
			System.out
					.println("Wilkommen in Ihrem Herr der Ringe Fanshop. Wir wünschen viel Spaß und gutes Shopping!\n");
			Kunde k3 = Kunde.kundenKontoErstellen();
			System.out.println("Möchten Sie sehen, welche Waren wir im Angebot haben? Y/N");
			String i = scanner.nextLine();
			if (i.equals("Y") | i.equals("y")) {
				Artikel.printWaren();
				k3.addToWarenkorb();
				OUTER: while (true) {
					System.out.println(
							"Was möchten Sie tun?\n(a) Artikel hinzufügen\n(b) Anzahl der Artikel im Warenkorb ändern\n(c) Warenkorb anzeigen\n(d) Sortiment anzeigen\n(e) Meine Daten ändern\n(f) Zur Kasse gehen \n(g) Bestellvorgang abbrechen");
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
						if (k3.getWarenkorb().getTotal() > 0) {
							if (k3.warenkorbShowAndConfig() == true) {
								continue;
							} else {
								break OUTER;
							}
						} else {
							System.out.println("Ihr Warenkorb ist leer!");
							continue;
						}
					}
					case "d" -> {
						Artikel.printWaren();
						continue;
					}
					case "e" -> {
						Kunde.changeDaten(k3);
						continue;
					}

					case "f" -> {
						k3.endBestellung();
						break OUTER;
					}
					case "g" -> {
						System.out.println("Bestellungvorgang abgebrochen.");
						break OUTER;
					}
					default -> {
						System.out.println(Fehler);
						continue;
					}
					}
				}
			} else if (!i.equals("N") && !i.equals("n")) {
				System.out.println(Fehler);
			}
			INNER: while (running == true) {
				System.out.println("(a) Neuer Kunde (b) Exit");
				String Ende = scanner.nextLine();
				switch (Ende) {
				case ("b") -> {
					System.out.println("Auf Wiedersehen.");
					running = false;
					break INNER;
				}
				case ("a") -> {
					running = true;
					break INNER;
				}
				default -> {
					System.out.println(Fehler);
					continue;
				}
				}
			}
		}
		scanner.close();
	}
}
