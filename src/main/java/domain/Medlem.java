package domain;

import java.util.Objects;

public class Medlem {
    //Attributer
    private String fornavn;
    private String efternavn;
    private String adresse;
    private String by;
    private String mail;
    private char køn;
    private int alder;
    private int medlemsnummer;
    private String restance;
    private char aktivitetsform;
    private char medlemstype;

    //Konstruktor
    public Medlem(String fornavn, String efternavn, String adresse,
                  String by, String mail, char køn,
                  int alder, int medlemsnummer, String restance,
                  char aktivitetsform, char medlemstype) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.adresse = adresse;
        this.by = by;
        this.mail = mail;
        this.køn = køn;
        this.alder = alder;
        this.medlemsnummer = medlemsnummer;
        this.restance = restance;
        this.aktivitetsform = aktivitetsform;
        this.medlemstype = medlemstype;
    }

    public Medlem(String fornavn, String efternavn) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Medlem medlem = (Medlem) o;
        return køn == medlem.køn &&
                alder == medlem.alder &&
                medlemsnummer == medlem.medlemsnummer &&
                restance == medlem.restance &&
                aktivitetsform == medlem.aktivitetsform &&
                medlemstype == medlem.medlemstype &&

                fornavn.equals(medlem.fornavn) &&
                efternavn.equals(medlem.efternavn) &&
                Objects.equals(adresse, medlem.adresse) &&
                Objects.equals(by, medlem.by)
                && Objects.equals(mail, medlem.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fornavn, efternavn, adresse, by, mail, køn, alder, medlemsnummer, restance, aktivitetsform, medlemstype);
    }

    //Getter
    public String getFornavn() {
        return fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getBy() {
        return by;
    }

    public String getMail() {
        return mail;
    }

    public char getKøn() {
        return køn;
    }

    public int getAlder() {
        return alder;
    }

    public int getMedlemsnummer() {
        return medlemsnummer;
    }

    public String getRestance() {
        return restance;
    }

    public char getAktivitetsform() {
        return aktivitetsform;
    }

    public char getMedlemstype() {
        return medlemstype;
    }

    //Setter
    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setRestance(String restance) {
        this.restance = restance;
    }

    public void setAktivitetsform(char aktivitetsform) {
        this.aktivitetsform = aktivitetsform;
    }

    public void setMedlemstype(char medlemstype) {
        this.medlemstype = medlemstype;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append("Fornavn: ");
        stringBuilder.append(fornavn);
        stringBuilder.append(";");
        //stringBuilder.append(";\tEfternavn: ");
        stringBuilder.append(efternavn);
        stringBuilder.append(";");
        //stringBuilder.append(";\tAdresse: ");
        stringBuilder.append(adresse);
        stringBuilder.append(";");
        //stringBuilder.append(";\tBy: ");
        stringBuilder.append(by);
        stringBuilder.append(";");
        //stringBuilder.append(";\tMail: ");
        stringBuilder.append(mail);
        stringBuilder.append(";");
        //stringBuilder.append(";\tKøn: ");
        stringBuilder.append(køn);
        stringBuilder.append(";");
        //stringBuilder.append(";\tAlder: ");
        stringBuilder.append(alder);
        stringBuilder.append(";");
        //stringBuilder.append(";\tMedlemsnummer: ");
        stringBuilder.append(medlemsnummer);
        stringBuilder.append(";");
        // stringBuilder.append(";\tRestance: ");
        stringBuilder.append(restance);
        stringBuilder.append(";");
        //stringBuilder.append(";\tAktivitetsform: ");
        stringBuilder.append(aktivitetsform);
        stringBuilder.append(";");
        //stringBuilder.append(";\tMedlemstype: ");
        stringBuilder.append(medlemstype);
        return stringBuilder.toString();
    }
}
