package entities;

public class GiochiDaTavolo extends Giochi {
    private int numeroGiocatori;
    private int durata;

    public GiochiDaTavolo(int id, String titolo, int anno, double prezzo, int numeroGiocatori, int durata) {
        super(id, titolo, anno, prezzo);
        this.numeroGiocatori = numeroGiocatori;
        this.durata = durata;
    }

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }

    public void setNumeroGiocatori(int numeroGiocatori) {
        this.numeroGiocatori = numeroGiocatori;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    @Override
    public String toString() {
        return "GiochiDaTavolo{" +
                "numeroGiocatori=" + numeroGiocatori +
                ", durata=" + durata +
                ", id=" + id +
                ", titolo='" + titolo + '\'' +
                ", anno=" + anno +
                ", prezzo=" + prezzo +
                '}';
    }
}
