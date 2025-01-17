package de.rhkoeln.warenkorb;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String FEHLER = "Ungültige Eingabe. Bitte versuchen Sie es erneut.";


    public static void main(String[] args) {
        try (scanner) {
            
            // Wenn running==true läuft das Programm weiter
            boolean running = true;

            // Artikel werden ins Sortiment geladen
            Artikel.initiateWaren();
            
            System.out.println("Willkommen in Ihrem Herr der Ringe Fanshop. Wir wünschen viel Spaß und gutes Shopping!");
            
            // Wichtigster While Loop Programmablauf wird hier gesteuert
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
        // While Loop des Login vorgangs (Kundenerstellung, Login)
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
        // Hier passiert der Shopping Vorgang des Nutzers
        System.out.println("\nWillkommen, " + k.getVorName() + "!");
            // Sortiment wird einmal ausgegeben
            Artikel.printWaren();

            
            while (true) {
                System.out.println("""
                                   \n Was möchten Sie tun?
                                   (a) Artikel hinzufügen/entfernen
                                   (b) Warenkorb anzeigen
                                   (c) Sortiment anzeigen
                                   (d) Meine Daten ändern
                                   (e) Zur Kasse gehen
                                   (f) Bestellvorgang abbrechen""");

                    String auswahl = scanner.nextLine();
                    
                    // Einkaufssteuerung
                    switch (auswahl) {
                        case "a" -> k.changeAnzahl();
                        case "b" -> {
                            if (k.getWarenkorb().calcTotal() > 0) {
                                if (!k.warenkorbShowAndNavi()) {
                                    return;
                                }
                            } else {
                                System.out.println("Ihr Warenkorb ist leer!");
                            }
                        }
                        case "c" -> Artikel.printWaren();
                        case "d" -> Kunde.changeDaten(k);
                        case "e" -> {
                            k.endBestellung();
                            return;
                        }
                        case "f" -> {
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