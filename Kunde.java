
public class Kunde {

	// Attribute
	private int KundenNummer;
	private String LieferAdresse;
	private String Rechnungsadresse;
	private String Name;

	// Konstruktor
	public Kunde(int kundenNummer, String lieferAdresse, String rechnungsadresse, String name) {
		super();
		KundenNummer = kundenNummer;
		LieferAdresse = lieferAdresse;
		Rechnungsadresse = rechnungsadresse;
		Name = name;
	}

	// Getter und Setter
	public int getKundenNummer() {
		return KundenNummer;
	}

	public void setKundenNummer(int kundenNummer) {
		KundenNummer = kundenNummer;
	}

	public String getLieferAdresse() {
		return LieferAdresse;
	}

	public void setLieferAdresse(String lieferAdresse) {
		LieferAdresse = lieferAdresse;
	}

	public String getRechnungsadresse() {
		return Rechnungsadresse;
	}

	public void setRechnungsadresse(String rechnungsadresse) {
		Rechnungsadresse = rechnungsadresse;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	// Ende Getter und Setter

}
