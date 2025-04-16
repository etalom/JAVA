/**
 * Einfache Testimplementierung des Ergebnis-Interfaces für die Testumgebung von Programmierer 3.
 */
public class ErgebnisTestimpl implements Ergebnis {
    private String spielerName;
    private long spielzeit;
    private int reihenlaenge;
    
    /**
     * Konstruktor für ein Ergebnis ohne Initialwerte.
     */
    public ErgebnisTestimpl() {
        this.spielerName = "";
        this.spielzeit = 0;
        this.reihenlaenge = 0;
    }
    
    /**
     * Konstruktor für ein Ergebnis mit Initialwerten.
     * @param spielerName Name des Spielers
     * @param spielzeit Spielzeit in Sekunden
     * @param reihenlaenge Länge der Ziffernreihe
     */
    public ErgebnisTestimpl(String spielerName, long spielzeit, int reihenlaenge) {
        this.spielerName = spielerName;
        this.spielzeit = spielzeit;
        this.reihenlaenge = reihenlaenge;
    }
    
    @Override
    public String getSpielerName() {
        return spielerName;
    }
    
    @Override
    public void setSpielerName(String name) {
        this.spielerName = name;
    }
    
    @Override
    public long getSpielzeit() {
        return spielzeit;
    }
    
    @Override
    public void setSpielzeit(long zeit) {
        this.spielzeit = zeit;
    }
    
    @Override
    public int getReihenlaenge() {
        return reihenlaenge;
    }
    
    @Override
    public void setReihenlaenge(int laenge) {
        this.reihenlaenge = laenge;
    }
    
    @Override
    public String toString() {
        return "Spieler: " + spielerName + ", Spielzeit: " + spielzeit + " Sekunden, Reihenlänge: " + reihenlaenge;
    }
} 