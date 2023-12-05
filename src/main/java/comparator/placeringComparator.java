package comparator;

import domain.Resultat;

import java.util.Comparator;

public class placeringComparator implements Comparator<Resultat> {
    @Override
    public int compare(Resultat data1, Resultat data2){
        return Integer.compare(data1.getPlacering(),data2.getPlacering());
    }
}
