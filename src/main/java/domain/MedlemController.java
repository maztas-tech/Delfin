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
        return db.getMedlemmer();
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

    public void fjernMedlemmer ( int søgeMedlemsnummer){
        isChanged = true;
        db.fjernMedlememer(søgeMedlemsnummer);
    }

    public void redigereMedlememr ( int medlemsnummer, String fornavn, String efternavm, String mail, String
            adresse, String by,char medlemstype, char aktivitetsform){
        isChanged = true;
        db.redigereMedlem(medlemsnummer, fornavn, efternavm, mail, adresse, by, medlemstype, aktivitetsform);
    }
    public void exit() {
        if (isChanged == true) {
            db.gemÆndringer();
        }
    }

    public void resultat(int medlemsnummer, String disciplin, double tid, String stævne, int placering, String dato) {
        isChanged = true;
        db.resultat(medlemsnummer, disciplin, tid, stævne, placering, dato);
    }

    public ArrayList getResultater () {
        return db.getResultater();
    }
    public void loadFromResultatFile () {
        db.loadFromResultatFile();
    }

    public boolean tjeckOmmedlemErIListe ( int medlemsnummer){
        ArrayList<Medlem> medlemArrayList = db.getMedlemmer();
        boolean eksistere = false;
        for (Medlem medlem : medlemArrayList) {
            if (medlem.getMedlemsnummer() == medlemsnummer) {
                eksistere = true;
            }
        }
        return eksistere;
    }
}

