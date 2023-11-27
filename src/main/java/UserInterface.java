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
    private String restance;
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
        while (true) {
            System.out.print("Tilføj fornavn: ");
            try {
                fornavn = input.nextLine();
                if (!fornavn.matches("[a-zA-Z]+")) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Skal være bogstaver!");
                continue;
            }
            break;
        }
        while (true) {
            System.out.print("Tilføj efternavn: ");
            try {
                efternavn = input.nextLine();
                if (!efternavn.matches("[a-zA-Z]+")) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Skal være bogstaver!");
                continue;
            }
            break;
        }
        while (true) {
            System.out.print("Tilføj adresse: ");
            try {
                adresse = input.nextLine();
                if (!adresse.matches(".*[a-zA-Z].*") || !adresse.matches(".*[0-9].*")) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Ugyldig adresse!");
                continue;
            }
            break;
        }
        while (true) {
            System.out.print("Tilføj by: ");
            try {
                by = input.nextLine();
                if (!by.matches("[a-zA-Z]+")) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Ikke gyldig navn!");
                continue;
            }
            break;
        }
        while (true) {
            System.out.print("Tilføj mail: ");
            try {
                mail = input.nextLine();
                if (!mail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Ikke en rigtig mail!");
                continue;
            }
            break;
        }
        while (true) {
            System.out.print("Tilføj køn M/K: ");
            try {
                køn = input.nextLine().toUpperCase().charAt(0);
                if (køn != 'M' && køn != 'K') {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Tast M eller K");
                continue;
            }
            break;
        }
        while (true) {
            System.out.print("Tilføj alder ");
            try {
                alder = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Skal være et tal!");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("Er brugeren i restance ? Ja/Nej: ");
            try {
                restance = input.nextLine().toUpperCase();
                if (!restance.equals("JA") && !restance.equals("NEJ")) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Tast ja eller nej");
                continue;
            }
            break;
        }
        while (true) {
            System.out.print("""
                    M = Motionist
                    K = Konkurrencesvømmer
                    Aktivitetsform M/K:\s""");
            try {
                aktivitetsform = input.nextLine().toUpperCase().charAt(0);
                if (aktivitetsform != 'M' && aktivitetsform != 'K') {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Tast M eller K");
                continue;
            }
            break;
        }
        while (true) {
            System.out.print("""
                    A = Aktiv
                    P = Passiv
                    Medlemstype:\s""");
            try {
                medlemstype = input.nextLine().toUpperCase().charAt(0);
                if (medlemstype != 'A' && medlemstype != 'P') {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Tast P eller A");
                continue;
            }
            break;
        }
        medlemController.registreMedlemmer(fornavn, efternavn, adresse,
                by, mail, køn,
                alder, medlemsnummer, restance, aktivitetsform, medlemstype);
        System.out.println("Medlem er blevet tilføjet!");
    }

    private void visMedlemmer() {
        ArrayList<Medlem> medlemArrayList = medlemController.visMedlemmer();
        System.out.println("Liste af alle medlemmer");
        for (Medlem medlem : medlemArrayList) {
            System.out.println("");
            System.out.println(
                            "Fornavn: " + medlem.getFornavn() + ", " +
                            "Efternavn: " + medlem.getEfternavn() + ", " +
                            "Adresse: " + medlem.getAdresse() + ", " +
                            "By: " + medlem.getBy() + ", " +
                            "Mail: " + medlem.getMail() + ", " +
                            "Køn (M/K): " + medlem.getKøn() + ", " +
                            "Alder: " + medlem.getAlder() + ", " +
                            "Medlemsnummer: " + medlem.getMedlemsnummer() + ", " +
                            "Aktivitetsform: " + medlem.getAktivitetsform() + ", " +
                            "Medlemstype: " + medlem.getMedlemstype());
        }
    }


    private void stopProgrammet() {
        System.out.println("Programmet er hermed stoppet");
        medlemController.exit();
        isRunning = false;
    }
}
