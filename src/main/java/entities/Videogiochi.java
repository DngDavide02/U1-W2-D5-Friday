package entities;

public class Videogiochi extends Giochi{
    private String piattaforma;
    private int durata;
    private Generi genere;

    public Videogiochi(int id, String titolo, int anno, double prezzo, String piattaforma, int durata, Generi genere) {
        super(id, titolo, anno, prezzo);
        this.piattaforma = piattaforma;
        this.durata = durata;
        this.genere = genere;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public Generi getGenere() {
        return genere;
    }

    public void setGenere(Generi genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Videogiochi{" +
                "piattaforma='" + piattaforma + '\'' +
                ", durata=" + durata +
                ", genere=" + genere +
                ", titolo='" + titolo + '\'' +
                ", id=" + id +
                ", anno=" + anno +
                ", prezzo=" + prezzo +
                '}';
    }
}
