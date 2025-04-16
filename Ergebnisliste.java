/**
 * Interface für die Datenstruktur Ergebnisliste.
 * Implementiert als verkettete Liste, die Ergebnis-Objekte speichert und entsprechende Zugriffe ermöglicht.
 */
public interface Ergebnisliste {
    /**
     * Fügt ein Ergebnis am Anfang der Liste hinzu.
     * @param ergebnis Das hinzuzufügende Ergebnis
     */
    void hinzufuegen(Ergebnis ergebnis);
    
    /**
     * Gibt das Ergebnis an der angegebenen Position zurück.
     * @param position Position des Ergebnisses in der Liste (0 = erste Position)
     * @return Das Ergebnis an der angegebenen Position
     * @throws IndexOutOfBoundsException wenn die Position ungültig ist
     */
    Ergebnis gibErgebnis(int position);
    
    /**
     * Gibt die Anzahl der Ergebnisse in der Liste zurück.
     * @return Anzahl der Ergebnisse
     */
    int gibAnzahl();
    
    /**
     * Leert die Ergebnisliste.
     */
    void leeren();
    
    /**
     * Gibt die komplette Ergebnisliste als String zurück.
     * @return String-Repräsentation der Ergebnisliste
     */
    String toString();
} 