# Warenkorb Projekt Anwendungsentwicklung I
todo
## Beschreibung des Projekts
**Kunden** eines Webshops können **Artikel** in ihren (**ihnen** **eindeutig** **zugeordneten**) **Warenkorb** legen. Von jedem Artikel können **beliebig** **viele** (aber **mindestens einer**!) im  Warenkorb vorkommen, ein Warenkorb kann **maximal 100 verschiedene Artikel** beinhalten.  Für **Artikel** werden die **Bezeichnung**, eine **Artikelnummer** und der **Preis** gespeichert, jeder Warenkorb kann von genau einem Kunden bestellt werden. Der Kunde bekommt dann eine **Bestellbestätigung** mit dem **Preis des gesamten Warenkorbs**, der **Versandadresse** und den **separat ausgewiesenen Versandkosten**. Die **Versandkosten** liegen **bis €20 bei €5,95**, **darüber (bis €50) bei €2,95**. Bestellungen mit einem Wert von **mehr als €50 sind versandkostenfrei**. Ein **Kunde** ist durch eine **Kundennummer** identifiziert und seinen **vollständigen Namen** sowie seine **Adresse** (evtl. für **Rechnung** und **Waren** unterschiedlich!).“ Das Programm „Warenkorb“ soll **zehn beliebige Artikel (aus dem Bereich „Bücher und Medien“)** und **zwei Kunden** anlegen. Ein Kunde legt **vier beliebige Artikel** in seinen Warenkorb und **ändert nachträglich** einmal die **Stückzahl** eines Artikels, **entfernt einen Artikel** wieder und **löst dann eine Bestellung aus**. Die **Bestellbestätigung** wird auf dem Bildschirm ausgegeben. Beim zweiten Kunden (mit einem „beliebigen“ Warenkorb) **ändert sich die Versandadresse vor der Bestellbestätigung**. Überlegen Sie sich entsprechende **Testdaten für Artikel und Kunden**.
### Klassen
todo
#### Klasse "Kunde"
**Attribute**
- **int**: Kundennummer (automatisch, startet bei 1)
- **String**: Vollständiger Name (Vor- und Nachname)
- **String**: Rechnungsadresse
- ggf. Zugehöriger Warenkorb
- **String**: Lieferadresse

### Klasse "Artikel"
Bereich: Bücher und Medien
**Attribute**
- **int**: Artikelnummer
- **String**: Bezeichnung
- **int**/**double**: Preis
- **Ggf. MwSt**
