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
			System.out.println("Wilkommen in Ihrem Herr der Ringe Fanshop. Wir wünschen viel Spaß und gutes Shopping!\n");
			Kunde k1 = new Kunde("Max", "Mustermann", "Musterstraße 3", "Musterstraße3");
			Kunde k2 = new Kunde("Maxine", "Musterfrau", "Musterweg 12", "Musterweg 12");
			Kunde k3 = Kunde.kundenKontoErstellen();
			Artikel.initiateWaren();
			System.out.println("Möchten Sie sehen, welche Waren wir im Angebot haben? Y/N");
			String i = scanner.nextLine();
			if (i.equals("Y")) {
				Artikel.printWaren();
				System.out.println(
						"Bitte fügen Sie jetzt etwas Ihrem Warenkorb hinzu.\nGeben Sie die Artikelnummer und die Anzahl die Sie hinzufügen wollen an.");
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				k3.addToWarenkorb(Artikel.waren.get(x - 1), y);
				System.out.println("Dies ist Ihr aktueller Warenkorb:");
				System.out.println(k3.getWarenkorb());
				// k2.addToWarenkorb(Artikel.waren.get(7),3);
				// System.out.println();
				// System.out.println(k3.getKundenNummer());
				k3.endBestellung();
				running = false;
			} else if (i.equals("N")) {
				running = false;
			}
		}
	}
}
