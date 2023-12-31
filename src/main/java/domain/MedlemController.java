package domain;

import datasource.Database;

import java.util.ArrayList;

public class MedlemController {
    Database db = new Database();
   private boolean isChanged = false;

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

    public void fjernMedlemmer(int søgeMedlemsnummer) {
        isChanged = true;
        db.fjernMedlememer(søgeMedlemsnummer);
    }

    public void redigereMedlememr(int medlemsnummer, String fornavn, String efternavm, String mail, String
            adresse, String by, char medlemstype, char aktivitetsform) {
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

    public ArrayList<Resultat> getResultater() {
        return db.getResultater();
    }

    public void loadFromResultatFile() {
        db.loadFromResultatFile();
    }

    public boolean tjeckOmmedlemErIListe(int medlemsnummer) {
        ArrayList<Medlem> medlemArrayList = db.getMedlemmer();
        boolean eksistere = false;
        for (Medlem medlem : medlemArrayList) {
            if (medlem.getMedlemsnummer() == medlemsnummer) {
                eksistere = true;
            }
        }
        return eksistere;
    }

    public int juniorBetaling(int betaling, int medlemsnummer) {
        isChanged = true;
        return db.årligJuniorBetaling(betaling, medlemsnummer);
    }

    public int seniorBetaling(int betaling, int medlemsnummer) {
        isChanged = true;
        return db.årligSeniorBetaling(betaling, medlemsnummer);
    }

    public int over60Betaling(int betaling, int medlemsnummer) {
        isChanged = true;
        return db.årligOver60Betaling(betaling, medlemsnummer);
    }

    public int passiv(int betaling, int medlemsnummer) {
        isChanged = true;
        return db.årligPassivBetaling(betaling, medlemsnummer);
    }

    public void loadFromJuniorFile() {
        db.loadFromJuniorFile();
    }

    public void loadFromSenior() {
        db.loadFromSeniorFile();
    }

    public ArrayList sorterJuniorResultater() {
        return db.sorterTop5JuniorHold();
    }

    public ArrayList sorterSeniorResultater() {
        return db.sorterTop5SeniorHold();
    }

    public ArrayList sorterSeniorCrawl() {
        return db.sorterTop5SeniorHoldCrawl();
    }

    public ArrayList sorterSeniorBryst() {
        return db.sorterTop5SeniorHoldBryst();
    }

    public ArrayList sorterSeniorRyg() {
        return db.sorterTop5SeniorHoldRyg();
    }

    public ArrayList sorterSeniorButterfly() {
        return db.sorterTop5SeniorHoldButterfly();
    }

    public void loadFromKontigentFile() {
        db.loadFromKontigentFile();
    }

   public ArrayList sorterJuniorCrawl(){
        return db.sorterTop5JuniorHoldCrawl();
   }

    public ArrayList sorterJuniorBryst(){
        return db.sorterTop5JuniorHoldBryst();
    }

    public ArrayList sorterJuniorRyg(){
        return db.sorterTop5JuniorHoldRyg();
    }

    public ArrayList sorterJuniorButterfly(){
       return db.sorterTop5JuniorHoldButterfly();
    }

    public ArrayList getKontigentList(){
        return db.getKontingentList();
    }
}

