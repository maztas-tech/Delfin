import java.util.ArrayList;

public class Database {

    public ArrayList<Medlem> medlemArrayList = new ArrayList<>();

    public void registreMedlemmer(String fornavn, String efternavn, String adresse,
                                  String by, String mail, char køn,
                                  int alder, int medlemsnummer, boolean restance,
                                  char aktivitetsform, char medlemstype){
        medlemArrayList.add(new Medlem(fornavn, efternavn, adresse,
                by, mail, køn, alder, medlemsnummer, restance, aktivitetsform, medlemstype));
    }

    public void visMedlemmer(){
        for (Medlem medlem: medlemArrayList) {
            System.out.println(medlem);
        }
    }
}
