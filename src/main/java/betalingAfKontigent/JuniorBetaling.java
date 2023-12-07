package betalingAfKontigent;

import betalingAfKontigent.Aktiv;

public class JuniorBetaling extends Aktiv {
    private int kontigent = 1000;
    private int rest;

    public JuniorBetaling(int betaling) {
        super(betaling);
    }

    public int rest() {
        rest = kontigent - super.getBetaling();
        return rest;
    }
}
