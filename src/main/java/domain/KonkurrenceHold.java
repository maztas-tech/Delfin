package domain;

import domain.Medlem;

import java.util.Date;

public class KonkurrenceHold extends Medlem {
    private String disciplin;
    private double tid;
    private String stævne;
    private int placering;
    private Date dato;

    public KonkurrenceHold(String fornavn, String efternavn, String disciplin, double tid, Date dato) {
        super(fornavn, efternavn);
        this.disciplin = disciplin;
        this.tid = tid;
        this.dato = dato;
    }

    
    public KonkurrenceHold(String fornavn, String efternavn, String disciplin, double tid, String stævne, int placering, Date dato){
        super(fornavn, efternavn);
        this.disciplin = disciplin;
        this.tid = tid;
        this.stævne = stævne;
        this.placering = placering;
        this.dato = dato;
    }



    @Override
    public String toString() {
        return  "Fornavn og efternavn: " + getFornavn() + " " + getEfternavn() + "\n" +
                "Disciplin: " + disciplin + '\n' +
                "Tid: " + tid + "\n" +
                "Stævne: " + stævne + "\n" +
                "Placering: " + placering + "\n" +
                "Dato: " + dato;
    }
}
