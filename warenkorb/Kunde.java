package warenkorb;

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

	public static void main(String[] args) {
		
	}
}
