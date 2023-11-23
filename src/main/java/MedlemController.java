import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MedlemController {
    Database db = new Database();
    Random random = new Random();
    Date date = new Date();


    public void registreMedlemmer(String fornavn, String efternavn, String adresse,
                                  String by, String mail, char køn,
                                  int alder, int medlemsnummer, boolean restance,
                                  char aktivitetsform, char medlemstype) {


        db.registreMedlemmer(fornavn, efternavn, adresse,
                by, mail, køn,
                alder, medlemsnummer, restance,
                aktivitetsform, medlemstype);
    }

    public void medlemsGenerator(){
        db.medlemsnummerGenerator();
    }

    public void visMedlemmer() {
        db.visMedlemmer();
    }

    public void saveChanges(){
        db.saveChanges();
    }

}
