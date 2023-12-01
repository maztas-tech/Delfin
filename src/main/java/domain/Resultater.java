package domain;

import java.util.Date;

public class Resultater  {
    private String disciplin;
    private double tid;
    private String stævne;
    private int placering;
    private Date dato;
    private int medlemsnummer;

    public Resultater(String fornavn, String efternavn, String disciplin, double tid, Date dato, int medlemsnummer) {

        this.disciplin = disciplin;
        this.tid = tid;
        this.dato = dato;
    }

    
    public Resultater(String fornavn, String efternavn, String disciplin, double tid, String stævne, int placering, Date dato){

        this.disciplin = disciplin;
        this.tid = tid;
        this.stævne = stævne;
        this.placering = placering;
        this.dato = dato;
    }



    @Override
    public String toString() {
        return  "Fornavn og efternavn: " + "\n" +
                "Disciplin: " + disciplin + '\n' +
                "Tid: " + tid + "\n" +
                "Stævne: " + stævne + "\n" +
                "Placering: " + placering + "\n" +
                "Dato: " + dato;
    }
}
