package warenkorb;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String FEHLER = "Ungültige Eingabe. Bitte versuchen Sie es erneut.";


    public static void main(String[] args) {
        try (scanner) {
            boolean running = true;
            Artikel.initiateWaren();
            
            System.out.println("Willkommen in Ihrem Herr der Ringe Fanshop. Wir wünschen viel Spaß und gutes Shopping!");
            
            while (running) {
                Kunde k = loginVorgang();   
                
                if (k == null) { // Kunde nicht gefunden oder Anmeldung abgebrochen
                    System.out.println("Auf Wiedersehen.");
                    break; // Schleife beenden und Programm beenden
                }
            
                einkaufen(k);
                
                if (programmEnde() == false) {
                    System.out.println("Auf Wiedersehen.");
                    running = false;
                }
            }
        }
    }


    private static Kunde loginVorgang() {
        while (true) {
            System.out.println("(a) Neuer Kunde   (b) Login");
            String auswahl = scanner.nextLine().trim().toLowerCase();
    
            switch (auswahl) {
                case "b" -> {
                    System.out.print("Ihre Kundennummer: ");
                    
                    try {
                        int kundenNummer = scanner.nextInt();
    
                        // Suche nach Kunde in der Kundenliste
                        for (Kunde k : Kunde.Kundenliste) {
                            if (k.getKundenNummer() == kundenNummer) {
                                System.out.println("Willkommen, " + k.getVorName() + "!");
                                return k;
                            }
                        }
    
                        System.out.println("Kundennummer nicht gefunden. Bitte versuchen Sie es erneut.");
                    } catch (NumberFormatException e) {
                        System.out.println(FEHLER);
                    }
                }
                case "a" -> {
                    return Kunde.kundenKontoErstellen();
                }
                default -> {
                    System.out.println(FEHLER);
                }
            }
        }
    }

    private static void einkaufen(Kunde k) {
        System.out.println("Willkommen, " + k.getVorName() + "! Unser aktuelles Sortiment:\n");
            Artikel.printWaren();

            while (true) {
                System.out.println("""
                                   \nWas möchten Sie tun?
                                   (a) Artikel hinzufügen
                                   (b) Anzahl der Artikel im Warenkorb ändern
                                   (c) Warenkorb anzeigen
                                   (d) Sortiment anzeigen
                                   (e) Meine Daten ändern
                                   (f) Zur Kasse gehen
                                   (g) Bestellvorgang abbrechen""");

                    String auswahl = scanner.nextLine();

                    switch (auswahl) {
                        case "a" -> k.addToWarenkorb();
                        case "b" -> k.changeAnzahl();
                        case "c" -> {
                            if (k.getWarenkorb().getTotal() > 0) {
                                if (!k.warenkorbShowAndConfig()) {
                                    return;
                                }
                            } else {
                                System.out.println("Ihr Warenkorb ist leer!");
                            }
                        }
                        case "d" -> Artikel.printWaren();
                        case "e" -> Kunde.changeDaten(k);
                        case "f" -> {
                            k.endBestellung();
                            return;
                        }
                        case "g" -> {
                            System.out.println("Bestellvorgang abgebrochen.");
                            return;
                        }
                        default -> System.out.println(FEHLER);
                    }
                }
            }
        

    private static boolean programmEnde() {
        while (true) {
            System.out.println("(a) Neuer Kunde (b) Exit");
            String eingabe = scanner.nextLine();

            switch (eingabe) {
                case "b" -> {
                    return false;
                }
                case "a" -> {
                    return true;
                }
                default -> System.out.println(FEHLER);
            }
        }
    }
}


