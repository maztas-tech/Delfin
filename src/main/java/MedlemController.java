import java.util.ArrayList;

public class MedlemController {
    Database db = new Database();
    boolean isChanged = false;

    public void registreMedlemmer(String fornavn, String efternavn, String adresse,
                                  String by, String mail, char køn,
                                  int alder, int medlemsnummer, boolean restance,
                                  char aktivitetsform, char medlemstype) {
        isChanged = true;
        db.registreMedlemmer(fornavn, efternavn, adresse,
                by, mail, køn,
                alder, restance,
                aktivitetsform, medlemstype);
    }

    public void visMedlemmer() {
        db.visMedlemmer();
    }

    public void saveChanges() {
        db.saveChanges();
    }

    public void loadFromFile() {
        db.loadFromFile();
    }

    public void exit() {
        if (isChanged == true) {
            db.saveChanges();
        }
    }
}
