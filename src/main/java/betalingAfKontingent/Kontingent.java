package betalingAfKontingent;

public class Kontingent {
    private int betaling;
    private int medlemsnummer;
    private int rest;

    public Kontingent(int betaling, int medlemsnummer, int rest) {
        this.betaling = betaling;
        this.medlemsnummer = medlemsnummer;
        this.rest = rest;
    }


    public int getBetaling() {
        return betaling;
    }

}
