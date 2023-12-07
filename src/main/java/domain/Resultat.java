package domain;

import java.util.Date;

public class Resultat {
    private String disciplin;
    private double tid;
    private String stævne;
    private int placering;
    private String dato;
    private int medlemsnummer;
//hej
    public Resultat(String disciplin, double tid, String dato, int medlemsnummer) {
        this.medlemsnummer = medlemsnummer;
        this.disciplin = disciplin;
        this.tid = tid;
        this.dato = dato;
    }


    public Resultat(String disciplin, double tid, String stævne, int placering, String dato, int medlemsnummer) {
        this.medlemsnummer = medlemsnummer;
        this.disciplin = disciplin;
        this.tid = tid;
        this.stævne = stævne;
        this.placering = placering;
        this.dato = dato;
    }

    public double getTid() {
        return tid;
    }

    public int getPlacering() {
        return placering;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(medlemsnummer);
        stringBuilder.append(";");
        stringBuilder.append(disciplin);
        stringBuilder.append(";");
        stringBuilder.append(stævne);
        stringBuilder.append(";");
        stringBuilder.append(tid);
        stringBuilder.append(";");
        stringBuilder.append(placering);
        stringBuilder.append(";");
        stringBuilder.append(dato);
        return stringBuilder.toString();
    }

}
