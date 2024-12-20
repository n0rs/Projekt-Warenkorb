package de.rhkoeln.warenkorb;

import java.util.InputMismatchException;
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
                                scanner.nextLine();
                                return k;
                            }
                        }
    
                        System.err.println("Kundennummer nicht gefunden. Bitte versuchen Sie es erneut.");
                        scanner.nextLine();
                    } catch (InputMismatchException | NumberFormatException e) {
                        System.err.println(FEHLER);
                        scanner.nextLine();
                    }
                }
                case "a" -> {
                    return Kunde.kundenKontoErstellen();
                }
                default -> {
                   System.err.println(FEHLER);
                }
            }
        }
    }

    private static void einkaufen(Kunde k) {
        System.out.println("\nWillkommen, " + k.getVorName() + "!");
            Artikel.printWaren();

            while (true) {
                System.out.println("""
                                   \n Was möchten Sie tun?
                                   (a) Artikel hinzufügen/entfernen
                                   (b) Anzahl der Artikel im Warenkorb ändern
                                   (c) Warenkorb anzeigen
                                   (d) Sortiment anzeigen
                                   (e) Meine Daten ändern
                                   (f) Zur Kasse gehen
                                   (g) Bestellvorgang abbrechen""");

                    String auswahl = scanner.nextLine();

                    switch (auswahl) {
                        case "a" -> k.changeAnzahl();
                        case "b" -> k.changeAnzahl();
                        case "c" -> {
                            if (k.getWarenkorb().calcTotal() > 0) {
                                if (!k.warenkorbShowAndNavi()) {
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
                            k.clearWarenkorb();
                            return;
                        }
                        default -> System.err.println(FEHLER);
                    }
                }
            }
        
    private static boolean programmEnde() {
        while (true) {
            System.out.println("(a) Neu (b) Exit");
            String eingabe = scanner.nextLine();

            switch (eingabe) {
                case "b" -> {
                    return false;
                }
                case "a" -> {
                    return true;
                }
                default -> System.err.println(FEHLER);
            }
        }
    }
}