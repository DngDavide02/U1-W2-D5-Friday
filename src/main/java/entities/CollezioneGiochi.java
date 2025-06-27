package entities;

import java.util.*;

public class CollezioneGiochi {
    private List<Giochi> giochi = new ArrayList<>();

    public void aggiungiGioco(Giochi gioco) {
        boolean esiste = giochi.stream()
                .anyMatch(g -> g.getId() == gioco.getId());

        if (esiste) {
            throw new IllegalArgumentException("ID già presente");
        }

        giochi.add(gioco);
    }

    public Optional<Giochi> cercaID(int id) {
        return giochi.stream()
                .filter(g -> g.getId() == id)
                .findFirst();
    }

    public List<Giochi> cercaPrezzo(double prezzoMax){
        return giochi.stream()
                .filter(g -> g.getPrezzo() < prezzoMax)
                .toList();
    }

    public List<GiochiDaTavolo> cercaGiocatori(int giocatori) {
        return giochi.stream()
                .filter(g -> g instanceof GiochiDaTavolo)
                .map(g -> (GiochiDaTavolo) g)
                .filter(g -> g.getNumeroGiocatori() == giocatori)
                .toList();
    }

    public boolean rimuoviGioco(int id){
        boolean rimosso = giochi.removeIf(g -> g.getId() == id);
        if (!rimosso){
            throw new NoSuchElementException("ID non trovato");
        }
        return rimosso;
    }

    public boolean aggiornaGioco(int id, Giochi giocoAggiornato) {
        for (int i = 0; i < giochi.size(); i++) {
            if (giochi.get(i).getId() == id){
                giochi.set(i, giocoAggiornato);
                return true;
            }
        }
        throw new NoSuchElementException("Nessun gioco con ID trovato");
    }

    public void statistiche(){
        long totVideogiochi = giochi.stream().filter(g -> g instanceof Videogiochi).count();
        long totGiochiDaTavolo = giochi.stream().filter(g -> g instanceof GiochiDaTavolo).count();

        DoubleSummaryStatistics statsPrezzi = giochi.stream().mapToDouble(Giochi::getPrezzo).summaryStatistics();

        Optional<Giochi> maxPrezzo = giochi.stream()
                .max(Comparator.comparingDouble(Giochi::getPrezzo));

        System.out.println("Videogiochi: " + totVideogiochi);
        System.out.println("Giochi da Tavolo: " + totGiochiDaTavolo);
        maxPrezzo.ifPresent(g -> System.out.println("Gioco più costoso: " + g));
        System.out.println("Prezzo medio: " + statsPrezzi.getAverage());
        System.out.println("Prezzo minimo: " + statsPrezzi.getMin());
        System.out.println("Prezzo massimo: " + statsPrezzi.getMax());
        System.out.println("Numero totale giochi: " + statsPrezzi.getCount());
    }

    public void stampaTutti() {
        if (giochi.isEmpty()) {
            System.out.println("La collezione è vuota.");
        } else {
            giochi.forEach(System.out::println);
        }
    }

}//end
