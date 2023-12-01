package domain;

import java.util.Date;

public class Resultat {
    private String disciplin;
    private double tid;
    private String stævne;
    private int placering;
    private String dato;
    private int medlemsnummer;

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


    @Override
    public String toString() {
        return "Medlemsnummer: " + medlemsnummer + "\n" +
                "Disciplin: " + disciplin + '\n' +
                "Tid: " + tid + "\n" +
                "Stævne: " + stævne + "\n" +
                "Placering: " + placering + "\n" +
                "Dato: " + dato;
    }
}
