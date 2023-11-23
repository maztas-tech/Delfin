import java.text.SimpleDateFormat;
import java.util.*;

public class Database {


    private Date date = new Date();
    private Random random = new Random();
    FileHandler fileHandler = new FileHandler();
    public ArrayList<Medlem> medlemArrayList = new ArrayList<>();


    public void medlemsnummerGenerator() {
        Set<Integer> randomNumbers = new HashSet<>();
        SimpleDateFormat sdf1 = new SimpleDateFormat("YY");
        int oldNumber = -1;

        while (randomNumbers.size() < 1) {
            int number = random.nextInt(9000) + 1000;
            if (number != oldNumber && !randomNumbers.contains(number)) {
                randomNumbers.add(number);
            }
        }
        int year = Integer.parseInt(sdf1.format(date));
        for (int number : randomNumbers) {
            String combined = String.valueOf(year) + number;
            System.out.println(combined);
        }
    }

    public void registreMedlemmer(String fornavn, String efternavn, String adresse,
                                  String by, String mail, char køn,
                                  int alder, int medlemsnummer, boolean restance,
                                  char aktivitetsform, char medlemstype) {
        medlemArrayList.add(new Medlem(fornavn, efternavn, adresse,
                by, mail, køn, alder, medlemsnummer, restance, aktivitetsform, medlemstype));
    }

    public void visMedlemmer() {
        for (Medlem medlem : medlemArrayList) {
            System.out.println(medlem);
        }
    }

    public void saveChanges() {
        fileHandler.printMedlemmer(medlemArrayList);
    }

}
