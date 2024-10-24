
public class Kunde {
	// Attribute
	private int kundenNummer;
	private String lieferAdresse;
	private String rechnungsAdresse;
	private String vorName; 
	private String nachName;

	public Kunde (int kundenNummer, String vorName, String nachName, String lieferAdresse, String rechnungsAdresse) {
		this.kundenNummer = kundenNummer;
		this.vorName = vorName;
		this.nachName = nachName;
		this.lieferAdresse = lieferAdresse;
		this.rechnungsAdresse = rechnungsAdresse;
	}
}
