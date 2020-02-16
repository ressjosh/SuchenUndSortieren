package my_project.model;

/**
 * Diese Klasse dient dazu Arrays zu sortieren. Sie soll außerdem den Aufwand des  jeweils durchgeführten Verfahrens
 * messen.
 * //todo Aufwandsmessung
 */
public class Datenmanager {

    private int anzahlVergleiche;
    private int anzahlVertauschungen;
    private double benoetigteZeit;

    /**
     * Erzeugt ein neues Objekt (es wird nur eins benötigt)
     */
    public Datenmanager(){
        reset();
    }

    /**
     * Setzt alle Zähler für die Algorithmen zurück
     */
    private void reset(){
        anzahlVergleiche = 0;
        anzahlVertauschungen = 0;
        benoetigteZeit = 0;
    }

    /**
     * Sortiert ein Array aus Tokens gemäß BubbleSort-Algorithmus
     * @param t
     */
    public void bubbleSort(Token[] t){
        Token tmp;
        boolean sortiert = false;

        while(!sortiert){
            sortiert = true;
            for(int i = 0; i < t.length-1; i++){
                if(t[i].getPrimaryKey() > t[i+1].getPrimaryKey()){
                    tmp = t[i];
                    t[i] = t[i+1];
                    t[i+1] = tmp;
                    sortiert = false;
                }
            }
        }
    }

    /**
     * Sortiert ein Array aus Tokens gemäß SelectionSort-Algorithmus
     * @param t
     */
    public void selectionSort(Token[] t){
        Token[] tmp = new Token[t.length];
        int zwischenIndex = 0;

        for(int i = 0; i < t.length; i++){
            int kleinstes = findeKleinstes(t);
            tmp[zwischenIndex] = t[kleinstes];
            t[kleinstes] = null;
            zwischenIndex = zwischenIndex + 1;
        }

        for(int i = 0; i < t.length; i++){
            t[i] = tmp[i];
        }
    }

    public int findeKleinstes(Token[] t){
        int zwischenDing = 0;
        boolean ersterDurchlauf = true;

        for(int i = 0; i < t.length; i++){
            if(t[i] != null) {
                if(ersterDurchlauf){
                    zwischenDing = i;
                    ersterDurchlauf = false;
                }
                if (t[i].getPrimaryKey() < t[zwischenDing].getPrimaryKey()) zwischenDing = i;
            }
        }
        return zwischenDing;
    }

    /**
     * Sortiert ein Array aus Tokens gemäß InsertionSort-Algorithmus
     * @param t
     */
    public void insertionSort(Token[] t){
        Token tmp;
        int j;

        for(int i = 0; i < t.length; i++){
            tmp = t[i];
            if(i >0 && tmp.getPrimaryKey() < t[i-1].getPrimaryKey()){
                j = i;
                t[i] = t[j-1];

                while(tmp.getPrimaryKey() < t[j].getPrimaryKey() && j > 1) {
                    j--;
                    t[j] = t[j-1];
                }

                if(tmp.getPrimaryKey() < t[0].getPrimaryKey()){
                    j--;
                }
                t[j++] = tmp;
            }
        }
    }

    /**
     * Ruft die rekursive Sortiermethode für QuickSort mit den nötigen Parametern auf und
     * sortiert ein Array aus Tokens gemäß QuickSort-Algorithmus
     * @param t
     */
    public void quickSort(Token[] t){
        recursiveQuickSort(t, 0,t.length-1);
    }

    /**
     * Sortiert ein Array aus Tokens gemäß QuickSort-Algorithmus
     * @param t
     * @param left
     * @param right
     */
    private void recursiveQuickSort(Token[] t, int left, int right){
        //todo Implementieren. Hilfestellungen finden sich im Buch und im Internet.
    }

    /**
     * Sortiert ein Array aus Tokens gemäß HashSort-Algorithmus
     * @param t
     */
    public void hashSort(Token[] t){
        //todo Implementieren. Hilfestellungen finden sich im Buch und im Internet.
    }

    /**
     * Sucht in einem Token-Array mit linearer Suche nach einem Token und gibt dessen Index zurück (-1 bedeutet nicht gefunden)
     * @param key Der gesuchte Schlüssel
     */
    public int linSearch(int key){
        //todo Implementieren. Hilfestellungen finden sich im Buch und im Internet.
        return -1;
    }

    /**
     * Sucht in einem Token-Array mit binärer Suche nach einem Token und gibt dessen Index zurück (-1 bedeutet nicht gefunden)
     * @param key Der gesuchte Schlüssel
     */
    public int binSearch(int key){
        //todo Implementieren. Hilfestellungen finden sich im Buch und im Internet.
        return -1;
    }

    // Sondierende / Zuweisende Methoden

    public int getAnzahlVergleiche() {
        return anzahlVergleiche;
    }

    public int getAnzahlVertauschungen() {
        return anzahlVertauschungen;
    }

    public double getBenoetigteZeit(){
        return benoetigteZeit;
    }
}
