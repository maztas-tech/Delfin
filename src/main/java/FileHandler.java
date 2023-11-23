import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    private File f = new File("Medlemsregister.csv");

    public void printMedlemmer(ArrayList<Medlem> medlemArrayList) {

        try {
            PrintStream output = new PrintStream(f);
            for (Medlem medlem : medlemArrayList) {
                if (medlem != null) {
                    output.println(medlem);
                } else {
                    System.out.println("There is no hero registered.");
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("File is not found!");
        }
    }

    public ArrayList<Medlem> loadFromFile() {

        ArrayList<Medlem> medlemArrayList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(f, StandardCharsets.ISO_8859_1);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] antalAttributes = line.split(";");
                if (antalAttributes.length == 11){
                    String fornavn = antalAttributes[0].trim();
                    String efternavn = antalAttributes[1].trim();
                    String adresse = antalAttributes[2].trim();
                    String by = antalAttributes[3].trim();
                    String mail = antalAttributes[4].trim();
                    char køn = antalAttributes[5].trim().charAt(0);
                    int alder = Integer.parseInt(antalAttributes[6].trim());
                    int medlemsnummer = Integer.parseInt(antalAttributes[7].trim());
                    boolean restance = Boolean.parseBoolean(antalAttributes[8].trim());
                    char aktivitetsform = antalAttributes[9].trim().charAt(0);
                    char medlemstype = antalAttributes[10].trim().charAt(0);

                    Medlem member = new Medlem(fornavn, efternavn, adresse, by, mail, køn, alder, medlemsnummer, restance, aktivitetsform, medlemstype);
                    medlemArrayList.add(member);
                }else {
                    System.out.println("Lenght is not 11!");
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();

        }
    return medlemArrayList;
    }
}
