/**
 * Interface für die Ziffernreihe im Ziffernreihen-Spiel.
 * Stellt Methoden zum Erstellen, Verwalten und Überprüfen einer Ziffernreihe bereit.
 */
public interface Ziffernreihe {
    /**
     * Erstellt eine neue zufällige Ziffernreihe mit der angegebenen Länge.
     * 
     * @param laenge Die Länge der zu erstellenden Ziffernreihe
     */
    void erzeugen(int laenge);
    
    /**
     * Gibt die aktuelle Länge der Ziffernreihe zurück.
     * 
     * @return Die Länge der Ziffernreihe
     */
    int gibLaenge();
    
    /**
     * Gibt die Ziffer an der angegebenen Position zurück.
     * 
     * @param position Die Position in der Ziffernreihe (0-basiert)
     * @return Die Ziffer an der angegebenen Position
     * @throws IndexOutOfBoundsException wenn die Position ungültig ist
     */
    int gibZiffer(int position);
    
    /**
     * Prüft, ob die vom Benutzer eingegebene Ziffernreihe korrekt ist.
     * 
     * @param benutzerEingabe Die vom Benutzer eingegebene Ziffernreihe als String
     * @return true, wenn die Eingabe korrekt ist, sonst false
     */
    boolean pruefeEingabe(String benutzerEingabe);
    
    /**
     * Gibt die komplette Ziffernreihe als String zurück.
     * 
     * @return Die Ziffernreihe als String
     */
    String toString();
} 
