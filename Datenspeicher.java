/**
 * Interface für den Datenspeicher, der Ergebnislisten aus einer Datei lädt und in eine Datei speichert.
 */
public interface Datenspeicher {
    /**
     * Lädt eine Ergebnisliste aus einer Datei.
     * @param dateiname Name der Datei, aus der geladen werden soll
     * @return Die geladene Ergebnisliste
     * @throws Exception wenn beim Laden ein Fehler auftritt
     */
    Ergebnisliste laden(String dateiname) throws Exception;
    
    /**
     * Speichert eine Ergebnisliste in eine Datei.
     * @param liste Die zu speichernde Ergebnisliste
     * @param dateiname Name der Datei, in die gespeichert werden soll
     * @throws Exception wenn beim Speichern ein Fehler auftritt
     */
    void speichern(Ergebnisliste liste, String dateiname) throws Exception;
} 