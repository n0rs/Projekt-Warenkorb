package warenkorb;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Wilkommen in Ihrem Herr der Ringe Fanshop. Wir wünschen viel Spaß und gutes Shopping!\n");
		Kunde k1 = new Kunde("Max", "Mustermann", "Musterstraße 3", "Musterstraße3");
		Kunde k2 = new Kunde("Maxine", "Musterfrau", "Musterweg 12", "Musterweg 12");
		Artikel.initiateWaren();
//		Artikel.printWaren();
		// System.out.println(k1.getKundenNummer());
		// System.out.println(k2.getKundenNummer());
		k1.addToWarenkorb(Artikel.waren.get(0));
		k2.addToWarenkorb(Artikel.waren.get(9));
		// System.out.println(k1.getLieferAdresse());
		// System.out.println(k2.getLieferAdresse());
		System.out.println();
		k1.addToWarenkorb(Artikel.waren.get(7));
		k1.addToWarenkorb(Artikel.waren.get(8));
		k2.addToWarenkorb(Artikel.waren.get(7));
		k2.addToWarenkorb(Artikel.waren.get(7));
//		System.out.println(k1.getWarenkorb());

		// Kundenkonto erstellen
		System.out.println("Bitte erstellen Sie Ihr Kundenkonto.");
		
		System.out.println("Nachname:");
		Scanner Knachname = new Scanner(System.in);
		String tempnachName = Knachname.nextLine();
		System.out.println("Vorname:");
		Scanner KvorName = new Scanner(System.in);
		String tempvorName = KvorName.nextLine();
		System.out.println("Adresse:");
		Scanner KAdresse = new Scanner(System.in);
		String tempAdress = KAdresse.nextLine();
		
		Kunde kint = new Kunde(tempvorName, tempnachName, tempAdress, tempAdress);
		
		System.out.println("Vielen Dank. Bitte überprüfen Sie Ihre Daten:\n");
		System.out.println(kint.toString() + "\n" + "\nBestätigen: X \nNeu: N");
		Scanner confirm = new Scanner(System.in);
		if (confirm.nextLine() == "X") {
			// continue
		} else if (confirm.nextLine() == "N") {
			// jump to beginning
		} else {
			System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.");
			// jump to Bestätigen
		}
		
		Knachname.close();
		KvorName.close();
		KAdresse.close();
		confirm.close();
	}
}
