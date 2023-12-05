package comparator;

import domain.Resultat;

import java.util.Comparator;

public class tidComparator implements Comparator<Resultat> {
    @Override
    public int compare(Resultat data1, Resultat data2){
        return Double.compare(data1.getTid(),data2.getTid());
    }
}
