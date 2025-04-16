import java.io.File;

/**
 * Testklasse für die DatenspeicherImpl-Implementierung.
 * Überprüft die korrekte Funktionalität des Speicherns und Ladens von Ergebnislisten.
 */
public class DatenspeicherTest {
    private static final String TEST_DATEI = "test_ergebnisse.txt";
    
    /**
     * Testet das Speichern und Laden einer Ergebnisliste.
     */
    public static void testSpeichernUndLaden() {
        try {
            System.out.println("=== Test: Speichern und Laden ===");
            
            // Testdaten erstellen
            ErgebnislisteTestimpl liste = new ErgebnislisteTestimpl();
            liste.hinzufuegen(new ErgebnisTestimpl("Max", 120, 8));
            liste.hinzufuegen(new ErgebnisTestimpl("Anna", 180, 10));
            liste.hinzufuegen(new ErgebnisTestimpl("Tom", 90, 6));
            
            System.out.println("Originale Liste:");
            for (int i = 0; i < liste.gibAnzahl(); i++) {
                System.out.println("  " + liste.gibErgebnis(i));
            }
            
            // Datenspeicher erstellen
            Datenspeicher speicher = new DatenspeicherImpl();
            
            // Liste speichern
            System.out.println("\nSpeichere Liste in " + TEST_DATEI);
            speicher.speichern(liste, TEST_DATEI);
            
            // Liste laden
            System.out.println("Lade Liste aus " + TEST_DATEI);
            Ergebnisliste geladeneListe = speicher.laden(TEST_DATEI);
            
            // Überprüfen, ob die geladene Liste mit der gespeicherten übereinstimmt
            boolean erfolgreich = true;
            if (geladeneListe.gibAnzahl() != liste.gibAnzahl()) {
                System.out.println("FEHLER: Unterschiedliche Listengrößen!");
                erfolgreich = false;
            } else {
                System.out.println("\nGeladene Liste:");
                for (int i = 0; i < geladeneListe.gibAnzahl(); i++) {
                    Ergebnis original = liste.gibErgebnis(i);
                    Ergebnis geladen = geladeneListe.gibErgebnis(i);
                    
                    System.out.println("  " + geladen);
                    
                    if (!vergleicheErgebnisse(original, geladen)) {
                        System.out.println("FEHLER: Ergebnisse an Position " + i + " stimmen nicht überein!");
                        erfolgreich = false;
                    }
                }
            }
            
            System.out.println("\nTestergebnis: " + (erfolgreich ? "Erfolgreich" : "Fehlgeschlagen"));
            
        } catch (Exception e) {
            System.err.println("Fehler beim Test: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Testdatei löschen
            new File(TEST_DATEI).delete();
        }
    }
    
    /**
     * Testet das Laden einer nicht existierenden Datei.
     */
    public static void testLadenNichtExistierendeDatei() {
        try {
            System.out.println("\n=== Test: Laden einer nicht existierenden Datei ===");
            
            String nichtExistierendeDatei = "nicht_existent.txt";
            System.out.println("Versuche, nicht existierende Datei zu laden: " + nichtExistierendeDatei);
            
            Datenspeicher speicher = new DatenspeicherImpl();
            Ergebnisliste liste = speicher.laden(nichtExistierendeDatei);
            
            if (liste != null && liste.gibAnzahl() == 0) {
                System.out.println("Testergebnis: Erfolgreich - Leere Liste wurde zurückgegeben");
            } else {
                System.out.println("FEHLER: Es wurde keine leere Liste zurückgegeben");
            }
            
        } catch (Exception e) {
            System.err.println("Fehler beim Test: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Vergleicht zwei Ergebnis-Objekte auf inhaltliche Gleichheit.
     * @param e1 Erstes Ergebnis
     * @param e2 Zweites Ergebnis
     * @return true, wenn beide Ergebnisse inhaltlich gleich sind, sonst false
     */
    private static boolean vergleicheErgebnisse(Ergebnis e1, Ergebnis e2) {
        return e1.getSpielerName().equals(e2.getSpielerName()) &&
               e1.getSpielzeit() == e2.getSpielzeit() &&
               e1.getReihenlaenge() == e2.getReihenlaenge();
    }
    
    /**
     * Hauptmethode zum Ausführen der Tests.
     * @param args Kommandozeilenargumente (nicht verwendet)
     */
    public static void main(String[] args) {
        testSpeichernUndLaden();
        testLadenNichtExistierendeDatei();
    }
} 