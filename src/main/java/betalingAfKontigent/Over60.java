package betalingAfKontigent;

import betalingAfKontigent.Aktiv;

public class Over60 extends Aktiv {
    private int kontigent = 1200;
    private int rest;

    public Over60(int betaling) {
        super(betaling);
    }

    public int rest() {
        rest = kontigent - super.getBetaling();
        return rest;
    }
}
