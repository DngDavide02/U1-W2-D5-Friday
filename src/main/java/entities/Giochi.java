package entities;

public abstract class Giochi {
     protected int id;
     protected String titolo;
     protected int anno;
     protected double prezzo;

     public Giochi(int id, String titolo, int anno, double prezzo){
         this.id = id;
         this.titolo = titolo;
         this.anno = anno;
         this.prezzo = prezzo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
