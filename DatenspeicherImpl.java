import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Implementierung des Datenspeicher-Interfaces.
 * Speichert und lädt Ergebnislisten in eine Textdatei.
 */
public class DatenspeicherImpl implements Datenspeicher {
    private static final String TRENNZEICHEN = ";";
    
    @Override
    public Ergebnisliste laden(String dateiname) throws Exception {
        File datei = new File(dateiname);
        Ergebnisliste liste = new ErgebnislisteTestimpl();
        
        if (!datei.exists()) {
            return liste;  // Leere Ergebnisliste zurückgeben, wenn die Datei nicht existiert
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(datei))) {
            String zeile;
            while ((zeile = reader.readLine()) != null) {
                // Zeile im Format: "SpielerName;Spielzeit;Reihenlaenge"
                String[] teile = zeile.split(TRENNZEICHEN);
                
                if (teile.length == 3) {
                    try {
                        String name = teile[0];
                        long zeit = Long.parseLong(teile[1]);
                        int laenge = Integer.parseInt(teile[2]);
                        
                        Ergebnis ergebnis = new ErgebnisTestimpl(name, zeit, laenge);
                        liste.hinzufuegen(ergebnis);
                    } catch (NumberFormatException e) {
                        System.err.println("Fehlerhafte Zeile in der Datei: " + zeile);
                    }
                }
            }
        } catch (IOException e) {
            throw new Exception("Fehler beim Lesen der Datei: " + e.getMessage());
        }
        
        return liste;
    }
    
    @Override
    public void speichern(Ergebnisliste liste, String dateiname) throws Exception {
        File datei = new File(dateiname);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(datei))) {
            // Alle Ergebnisse in die Datei schreiben
            for (int i = 0; i < liste.gibAnzahl(); i++) {
                Ergebnis ergebnis = liste.gibErgebnis(i);
                
                // Zeile im Format: "SpielerName;Spielzeit;Reihenlaenge"
                String zeile = ergebnis.getSpielerName() + TRENNZEICHEN + 
                               ergebnis.getSpielzeit() + TRENNZEICHEN + 
                               ergebnis.getReihenlaenge();
                
                writer.write(zeile);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new Exception("Fehler beim Schreiben der Datei: " + e.getMessage());
        }
    }
    
    /**
     * Testet die Funktionalität des Datenspeichers.
     * @param args Kommandozeilenargumente (nicht verwendet)
     */
    public static void main(String[] args) {
        try {
            // Testdaten erstellen
            ErgebnislisteTestimpl liste = new ErgebnislisteTestimpl();
            liste.hinzufuegen(new ErgebnisTestimpl("Max", 120, 8));
            liste.hinzufuegen(new ErgebnisTestimpl("Anna", 180, 10));
            liste.hinzufuegen(new ErgebnisTestimpl("Tom", 90, 6));
            
            // Datenspeicher erstellen
            Datenspeicher speicher = new DatenspeicherImpl();
            
            // Liste speichern
            String testdatei = "test_ergebnisse.txt";
            speicher.speichern(liste, testdatei);
            System.out.println("Ergebnisliste gespeichert in " + testdatei);
            
            // Liste laden
            Ergebnisliste geladeneListe = speicher.laden(testdatei);
            System.out.println("Ergebnisliste geladen aus " + testdatei);
            
            // Geladene Liste anzeigen
            System.out.println("\nInhalt der geladenen Liste:");
            for (int i = 0; i < geladeneListe.gibAnzahl(); i++) {
                Ergebnis ergebnis = geladeneListe.gibErgebnis(i);
                System.out.println((i + 1) + ". " + ergebnis);
            }
            
        } catch (Exception e) {
            System.err.println("Fehler: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 