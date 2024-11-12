package warenkorb;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// break variable for while loop
		boolean running = true;
		// Scanner object
		Scanner scanner = new Scanner(System.in);
		Artikel.initiateWaren();

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
							"\nWas möchten Sie tun?\n(a) Artikel hinzufügen\n(b) Anzahl der Artikel im Warenkorb ändern\n(c) Warenkorb anzeigen\n(d) Sortiment anzeigen\n(e) Meine Daten ändern\n(f) Zur Kasse gehen \n(g) Bestellvorgang abbrechen");
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
								System.out.println("(a) Neuer Kunde (b) Exit");
								String Ende = scanner.nextLine();
								if (Ende.equals("a")) {
									running = true;
								} else {
									running = false;
									System.out.println("Auf Wiedersehen");
								}
								break OUTER;
							}
						} else {
							System.out.println("Ihr Warenkorb ist leer");
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
						System.out.println("(a) Neuer Kunde (b) Exit");
						String Ende = scanner.nextLine();
						if (Ende.equals("a")) {
							running = true;
						} else {
							running = false;
							System.out.println("Auf Wiedersehen");
						}
						break OUTER;
					}
					case "g" -> {
						System.out.println("Bestellvorgang abgebrochen.\n(a) Neuer Kunde   (b) Exit");
						String k = scanner.nextLine();
						if (k.equals("a")) {
							break OUTER;
						} else {
							System.out.println("Auf Wiedersehen.");
							running = false;
							break OUTER;
						}
					}
					default -> {
						System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.");
						continue;
					}
					}
				}
			} else if (i.equals("N") | i.equals("n")) {
				System.out.println("Bestellvorgang abgebrochen.\n(a) Neuer Kunde   (b) Exit");
				String k = scanner.nextLine();
				if (k.equals("a")) {
					continue;
				} else {
					System.out.println("Auf Wiedersehen.");
					running = false;
				}
			} else {
				System.out.println("Ungültige Eingabe, versuchen Sie es erneut.\n");
			}
		}
		scanner.close();
	}
}
