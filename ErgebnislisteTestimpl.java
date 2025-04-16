import java.util.ArrayList;
import java.util.List;

/**
 * Einfache Testimplementierung des Ergebnisliste-Interfaces für die Testumgebung von Programmierer 3.
 */
public class ErgebnislisteTestimpl implements Ergebnisliste {
    private List<Ergebnis> ergebnisse;
    
    /**
     * Konstruktor für eine leere Ergebnisliste.
     */
    public ErgebnislisteTestimpl() {
        this.ergebnisse = new ArrayList<>();
    }
    
    @Override
    public void hinzufuegen(Ergebnis ergebnis) {
        if (ergebnis == null) {
            throw new IllegalArgumentException("Ergebnis darf nicht null sein.");
        }
        
        // Hinzufügen am Anfang der Liste (neuestes Ergebnis zuerst)
        ergebnisse.add(0, ergebnis);
    }
    
    @Override
    public Ergebnis gibErgebnis(int position) {
        if (position < 0 || position >= ergebnisse.size()) {
            throw new IndexOutOfBoundsException("Ungültige Position: " + position);
        }
        
        return ergebnisse.get(position);
    }
    
    @Override
    public int gibAnzahl() {
        return ergebnisse.size();
    }
    
    @Override
    public void leeren() {
        ergebnisse.clear();
    }
    
    @Override
    public String toString() {
        if (ergebnisse.isEmpty()) {
            return "Keine Ergebnisse vorhanden.";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ergebnisse.size(); i++) {
            sb.append(i + 1).append(". ").append(ergebnisse.get(i)).append("\n");
        }
        
        return sb.toString();
    }
} 