package domain;

import datasource.Database;

import java.util.ArrayList;

public class MedlemController {
    Database db = new Database();
    boolean isChanged = false;

    public void registreMedlemmer(String fornavn, String efternavn, String adresse,
                                  String by, String mail, char køn,
                                  int alder, int medlemsnummer, String restance,
                                  char aktivitetsform, char medlemstype) {
        isChanged = true;
        db.registreMedlemmer(fornavn, efternavn, adresse,
                by, mail, køn,
                alder, restance,
                aktivitetsform, medlemstype);
    }

    public ArrayList<Medlem> visMedlemmer() {
        return db.visMedlemmer();
    }

    public void saveChanges() {
        db.gemÆndringer();
    }

    public void loadFromFile() {
        db.loadFromFile();

    }

    public void søgEfterMedlem(int medlemsnummer, String søgNavn) {
        db.søgEfterMedlem(medlemsnummer, søgNavn);
    }

    public void exit() {
        if (isChanged == true) {
            db.gemÆndringer();
        }
    }
}
