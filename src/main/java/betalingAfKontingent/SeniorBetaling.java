package betalingAfKontingent;

public class SeniorBetaling extends Aktiv {
    private int kontingent = 1600;
    private int rest;
    private int medlemsnummer;

    public SeniorBetaling(int betaling, int medlemsnummer, int rest) {
        super(betaling, medlemsnummer, rest);
        this.medlemsnummer = medlemsnummer;
    }

    public int rest() {
        rest = kontingent - super.getBetaling();
        return rest;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(medlemsnummer);
        stringBuilder.append(";");
        stringBuilder.append(getBetaling());
        stringBuilder.append(";");
        stringBuilder.append(rest);
        return stringBuilder.toString();
    }
}
