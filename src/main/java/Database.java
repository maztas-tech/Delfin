import java.text.SimpleDateFormat;
import java.util.*;

public class Database {
    Random random = new Random();
    Date date = new Date();
    FileHandler fileHandler = new FileHandler();

    public ArrayList<Medlem> medlemArrayList = new ArrayList<>();
    private Set<Integer> generedeMedlemsnumre = new HashSet<>();

    private int medlemsnummerGenerator() {
        SimpleDateFormat sdf1 = new SimpleDateFormat("YY");
        int medlemsnummer;
        do {
            int number1 = random.nextInt(0, 9);
            int number2 = random.nextInt(0, 9);
            int number3 = random.nextInt(0, 9);
            int number4 = random.nextInt(0, 9);
            medlemsnummer = Integer.parseInt(sdf1.format(date) + number1 + number2 + number3 + number4);

        } while (generedeMedlemsnumre.contains(medlemsnummer));

        generedeMedlemsnumre.add(medlemsnummer);
        return medlemsnummer;
    }

    public void registreMedlemmer(String fornavn, String efternavn, String adresse,
                                  String by, String mail, char køn,
                                  int alder, String restance,
                                  char aktivitetsform, char medlemstype) {


        int medlemsnummer = medlemsnummerGenerator();

        medlemArrayList.add(new Medlem(fornavn, efternavn, adresse,
                by, mail, køn, alder, medlemsnummer, restance, aktivitetsform, medlemstype));
    }

    public ArrayList<Medlem> visMedlemmer() {
        return medlemArrayList;
    }

    public void gemÆndringer() {
        fileHandler.indsætMedlemmer(medlemArrayList);
        fileHandler.indsætJuniorMedlem(medlemArrayList);
        fileHandler.indsætSeniorMedlem(medlemArrayList);
    }



    public void loadFromFile() {
        ArrayList<Medlem> loadedMedlemArrayList;
        loadedMedlemArrayList = fileHandler.indlæsFraCSVFil();
        if (loadedMedlemArrayList != null) {
            //medlemArrayList.clear();
            medlemArrayList.addAll(loadedMedlemArrayList);
            //loadedMedlemArrayList.clear();
        } else {
            System.out.println("Ingen gemte medlemmer.");
        }
    }
}

