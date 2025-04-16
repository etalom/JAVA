/**
 * Interface für einen Ergebnis-Datensatz im Ziffernreihen-Spiel.
 * Enthält Informationen über Name des Spielers, Spielzeit und Länge der Reihe.
 */
public interface Ergebnis {
    /**
     * Gibt den Namen des Spielers zurück.
     * 
     * @return Name des Spielers
     */
    String getSpielerName();

    /**
     * Setzt den Namen des Spielers.
     * 
     * @param name Name des Spielers
     */
    void setSpielerName(String name);

    /**
     * Gibt die Spielzeit in Sekunden zurück.
     * 
     * @return Spielzeit in Sekunden
     */
    long getSpielzeit();

    /**
     * Setzt die Spielzeit in Sekunden.
     * 
     * @param zeit Spielzeit in Sekunden
     */
    void setSpielzeit(long zeit);

    /**
     * Gibt die Länge der Ziffernreihe zurück.
     * 
     * @return Länge der Ziffernreihe
     */
    int getReihenlaenge();

    /**
     * Setzt die Länge der Ziffernreihe.
     * 
     * @param laenge Länge der Ziffernreihe
     */
    void setReihenlaenge(int laenge);

    /**
     * Konvertiert das Ergebnis in eine Zeichenkette.
     * 
     * @return Zeichenkette-Darstellung des Ergebnisses
     */
    String toString();
}