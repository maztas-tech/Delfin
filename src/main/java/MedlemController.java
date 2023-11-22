public class MedlemController {
    Database db = new Database();

    public void registreMedlemmer(String fornavn, String efternavn, String adresse,
                                  String by, String mail, char køn,
                                  int alder, int medlemsnummer, boolean restance,
                                  char aktivitetsform, char medlemstype){

        db.registreMedlemmer(fornavn, efternavn, adresse,
                        by, mail, køn,
                            alder,  restance,
                            aktivitetsform, medlemstype);
    }

    public void visMedlemmer(){

        db.visMedlemmer();
    }

}
