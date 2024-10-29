package warenkorb;

public class Kunde {
	// Attribute
	private Warenkorb warenkorb;
	private int kundenNummer;
	private String lieferAdresse;
	private String rechnungsAdresse;
	private String vorName; 
	private String nachName;
	// Counter wird benutzt um kundenNummer bei jedem Aufrufen des Konstruktors um 1 zu erhöhen
	private static int counter = 1;

	// Kunden-Konstruktor mit kundenNummer und warenkorb als sich ändernde Objekte
	// eventuell müssen wir die Lieferadresse auch so behandeln wenn wir die ändern wollen
	public Kunde (String vorName, String nachName, String lieferAdresse, String rechnungsAdresse) {
		kundenNummer = counter++;
		this.vorName = vorName;
		this.nachName = nachName;
		this.lieferAdresse = lieferAdresse;
		this.rechnungsAdresse = rechnungsAdresse;
		this.warenkorb = new Warenkorb();
	}

	// fügt Waren in den für jeden Kunden einzigartigen Warenkorb
	// Nutzt die Warenkorb.addWaren Methode
	public void addToWarenkorb (Artikel artikel) {
		warenkorb.addWaren(artikel);
	}

	// Getter und Setter für alle Attribute außer counter
	// Wir sollten am Ende schauen, welche der Getter/Setter nicht verwendet werden
	public int getKundenNummer() {
        return kundenNummer;
    }
    public void setKundenNummer(int kundenNummer) {
        this.kundenNummer = kundenNummer;
    }
	public String getLieferAdresse() {
		return lieferAdresse;
	}
	public void setLieferAdresse(String lieferAdresse) {
		this.lieferAdresse = lieferAdresse;
	}
	public String getRechnungsAdresse() {
		return rechnungsAdresse;
	}
	public void setRechnungsAdresse(String rechnungsAdresse) {
		this.rechnungsAdresse = rechnungsAdresse;
	}
	public String getVorName() {
		return vorName;
	}
	public void setVorName(String vorName) {
		this.vorName = vorName;
	}
	public String getNachName() {
		return nachName;
	}
	public void setNachName(String nachName) {
		this.nachName = nachName;
	}
    public Warenkorb getWarenkorb() {
        return warenkorb;
    }
    public void setWarenkorb(Warenkorb warenkorb) {
        this.warenkorb = warenkorb;
    }  
}
