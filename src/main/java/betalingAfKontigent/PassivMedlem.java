package betalingAfKontigent;

public class PassivMedlem extends Passiv{
    private int kontigent = 500;
    private int rest;

    public PassivMedlem(int betaling) {
        super(betaling);
    }

    public int rest() {
        rest = kontigent - super.getBetaling();
        return rest;
    }
}
