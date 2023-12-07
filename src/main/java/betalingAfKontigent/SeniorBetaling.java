package betalingAfKontigent;

import betalingAfKontigent.Aktiv;

public class SeniorBetaling extends Aktiv {
    private int kontigent = 1600;
    private int rest;

    public SeniorBetaling(int betaling) {
        super(betaling);
    }

    public int rest() {
        rest = kontigent - super.getBetaling();
        return rest;
    }
}
