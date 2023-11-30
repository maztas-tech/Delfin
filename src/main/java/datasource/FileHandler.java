package datasource;

import domain.Medlem;
import domain.KonkurrenceHold;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    private File medlemsregisterFile = new File("Medlemsregister.csv");
    private File juniorFile = new File("juniorHoldet.csv");
    private File seniorFile = new File("seniorHoldet.csv");

    public void indsætMedlemmer(ArrayList<Medlem> medlemArrayList) {
        try {
            PrintStream output = new PrintStream(medlemsregisterFile);
            for (Medlem medlem : medlemArrayList) {
                if (medlem != null) {
                    output.println(medlem);
                } else {
                    System.out.println("Der er ingen medlemmer i klubben!");
                }

            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Filen eksisterer ikke!");
        }
    }

    public void indsætJuniorMedlem(ArrayList<Medlem> medlemArrayList) {
        try {
            PrintStream juniorOutput = new PrintStream(juniorFile);
            for (Medlem medlem : medlemArrayList) {
                if (medlem.getAlder() < 18 && medlem.getAktivitetsform() == 'K') {
                    juniorOutput.println(medlem);
                }else {
                    System.out.println("Ingen under 18");
                }
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("Filen eksisterer ikke!");
        }
    }

    public void indsætSeniorMedlem(ArrayList<Medlem> medlemArrayList) {
        try {
            PrintStream seniorOutput = new PrintStream(seniorFile);
            for (Medlem medlem : medlemArrayList) {
                if (medlem.getAlder() >= 18 && medlem.getAktivitetsform() == 'K') {
                    seniorOutput.println(medlem);
                } else {
                    System.out.println("Ingen over 18!");
                }
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

    public ArrayList<Medlem> indlæsFraCSVFil() {

        ArrayList<Medlem> medlemArrayList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(medlemsregisterFile, StandardCharsets.ISO_8859_1);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] antalAttributes = line.split(";");
                if (antalAttributes.length == 11) {
                    String fornavn = antalAttributes[0].trim();
                    String efternavn = antalAttributes[1].trim();
                    String adresse = antalAttributes[2].trim();
                    String by = antalAttributes[3].trim();
                    String mail = antalAttributes[4].trim();
                    char køn = antalAttributes[5].trim().charAt(0);
                    int alder = Integer.parseInt(antalAttributes[6].trim());
                    int medlemsnummer = Integer.parseInt(antalAttributes[7].trim());
                    String restance = antalAttributes[8].trim();
                    char aktivitetsform = antalAttributes[9].trim().charAt(0);
                    char medlemstype = antalAttributes[10].trim().charAt(0);

                    Medlem member = new Medlem(fornavn, efternavn, adresse, by, mail, køn, alder, medlemsnummer, restance, aktivitetsform, medlemstype);
                    medlemArrayList.add(member);
                } else {
                    System.out.println("Længden skal være 11!");
                }
            }
            sc.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return medlemArrayList;
    }

    public ArrayList<Medlem> indlæsFraSeniorCSVFil() {

        ArrayList<Medlem> medlemArrayList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(seniorFile, StandardCharsets.ISO_8859_1);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] antalAttributes = line.split(";");
                if (antalAttributes.length == 11) {
                    String fornavn = antalAttributes[0].trim();
                    String efternavn = antalAttributes[1].trim();
                    String adresse = antalAttributes[2].trim();
                    String by = antalAttributes[3].trim();
                    String mail = antalAttributes[4].trim();
                    char køn = antalAttributes[5].trim().charAt(0);
                    int alder = Integer.parseInt(antalAttributes[6].trim());
                    int medlemsnummer = Integer.parseInt(antalAttributes[7].trim());
                    String restance = antalAttributes[8].trim();
                    char aktivitetsform = antalAttributes[9].trim().charAt(0);
                    char medlemstype = antalAttributes[10].trim().charAt(0);

                    Medlem member = new Medlem(fornavn, efternavn, adresse, by, mail, køn, alder, medlemsnummer, restance, aktivitetsform, medlemstype);
                    medlemArrayList.add(member);
                } else {
                    System.out.println("Længden skal være 11!");
                }
            }
            sc.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return medlemArrayList;
    }
    public ArrayList<Medlem> indlæsFraJuniorCSVFil() {

        ArrayList<Medlem> medlemArrayList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(juniorFile, StandardCharsets.ISO_8859_1);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] antalAttributes = line.split(";");
                if (antalAttributes.length == 11) {
                    String fornavn = antalAttributes[0].trim();
                    String efternavn = antalAttributes[1].trim();
                    String adresse = antalAttributes[2].trim();
                    String by = antalAttributes[3].trim();
                    String mail = antalAttributes[4].trim();
                    char køn = antalAttributes[5].trim().charAt(0);
                    int alder = Integer.parseInt(antalAttributes[6].trim());
                    int medlemsnummer = Integer.parseInt(antalAttributes[7].trim());
                    String restance = antalAttributes[8].trim();
                    char aktivitetsform = antalAttributes[9].trim().charAt(0);
                    char medlemstype = antalAttributes[10].trim().charAt(0);

                    Medlem member = new Medlem(fornavn, efternavn, adresse, by, mail, køn, alder, medlemsnummer, restance, aktivitetsform, medlemstype);
                    medlemArrayList.add(member);
                } else {
                    System.out.println("Længden skal være 11!");
                }
            }
            sc.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return medlemArrayList;
    }
}
