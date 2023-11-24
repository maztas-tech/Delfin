import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    MedlemController medlemController = new MedlemController();
    Scanner input = new Scanner(System.in);
    private boolean isRunning = true;
    private int userChoice;
    private boolean memberVerified = true;
    private String fornavn;
    private String efternavn;
    private String adresse;
    private String by;
    private String mail;
    private char køn;
    private int alder;
    private int medlemsnummer;
    private boolean restance;
    private char aktivitetsform;
    private char medlemstype;

    public void startProgram() {
        System.out.println("Velkommen til Delfinen!");
        medlemController.loadFromFile();
        do {
            //TODO læs en CSV fil
            velkomst();
            try {
                userChoice = Integer.parseInt(input.nextLine());
            } catch (InputMismatchException | NumberFormatException ime) {
                System.out.println("Skal være et tal!");
            }

            switch (userChoice) {
                case 1 -> registreMedlemmer();
                case 2 -> visMedlemmer();
                case 9 -> stopProgrammet();
            }
        } while (isRunning);
    }

    private void velkomst() {

        System.out.println("""
                1. Registre et nyt medlem   \s
                2. Vis medlemmer           \s
                9. Afslut programmet
                """);
    }

    private void registreMedlemmer() {
        do {
            //TODO lav en try catch så der ikke kommer forkert input
            System.out.print("Tilføj fornavn: ");
            fornavn = input.nextLine();

            System.out.print("Tilføj efternavn: ");
            efternavn = input.nextLine();

            System.out.print("Tilføj adresse: ");
            adresse = input.nextLine();

            System.out.print("Tilføj by: ");
            by = input.nextLine();

            System.out.print("Tilføj mail: ");
            mail = input.nextLine();

            System.out.print("Tilføj køn M/K: ");
            køn = input.nextLine().toUpperCase().charAt(0);

            System.out.print("Tilføj alder: ");
            alder = Integer.parseInt(input.nextLine());

            System.out.print("Er brugeren i restance ? J/N: ");
            restance = Boolean.parseBoolean(input.nextLine().toUpperCase());

            System.out.print("""
                    M = Motionist
                    K = Konkurrencesvømmer
                    Aktivitetsform M/K:\s""");
            aktivitetsform = input.nextLine().toUpperCase().charAt(0);

            System.out.print("""
                    A = Aktiv medlemstype
                    P = Passiv medlemstype
                    Medlemstype A/P:\s""");
            medlemstype = input.nextLine().toUpperCase().charAt(0);
            //TODO if statement -> hvis vores medlemsnummer allerede eksisterer skal den lave et nyt tal
            medlemController.registreMedlemmer(fornavn, efternavn, adresse,
                    by, mail, køn,
                    alder, medlemsnummer, restance, aktivitetsform, medlemstype);

            System.out.println("Medlem er blevet tilføjet!");

            memberVerified = false;
        } while (memberVerified);
    }

    private void visMedlemmer() {
        //TODO indlæs medlemmer fra CSV fil
        System.out.println("Liste af alle medlemmer");
        medlemController.visMedlemmer();
    }


    private void stopProgrammet() {
        System.out.println("Programmet er hermed stoppet");
        medlemController.exit();
        isRunning = false;
    }
}
