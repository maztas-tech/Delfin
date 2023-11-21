public class Medlem {
    //Attributer
    private String fornavn;
    private String efternavn;
    private String adresse;
    private String by;
    private String mail;
    private final char køn;
    private final int alder;

    private final int medlemsnummer;
    private boolean restance;
    private char aktivitetsform;
    private char medlemstype;

    //Konstruktor
    public Medlem(String fornavn, String efternavn, String adresse,
                  String by, String mail, char køn,
                  int alder, int medlemsnummer, boolean restance,
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

    public boolean isRestance() {
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

    public void setRestance(boolean restance) {
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
        stringBuilder.append("Fornavn: ");
        stringBuilder.append(fornavn);
        stringBuilder.append("\tEfternavn: ");
        stringBuilder.append(efternavn);
        stringBuilder.append("\tAdresse: ");
        stringBuilder.append(adresse);
        stringBuilder.append("\tBy: ");
        stringBuilder.append(by);
        stringBuilder.append("\tMail: ");
        stringBuilder.append(mail);
        stringBuilder.append("\tKøn: ");
        stringBuilder.append(køn);
        stringBuilder.append("\tAlder: ");
        stringBuilder.append(alder);
        stringBuilder.append("\tMedlemsnummer: ");
        stringBuilder.append(medlemsnummer);
        stringBuilder.append("\tRestance: ");
        stringBuilder.append(restance);
        stringBuilder.append("\tAktivitetsform: ");
        stringBuilder.append(aktivitetsform);
        stringBuilder.append("\tMedlemstype: ");
        stringBuilder.append(medlemstype);
        return stringBuilder.toString();
    }
}
