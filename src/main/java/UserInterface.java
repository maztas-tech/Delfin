import domain.Medlem;
import domain.MedlemController;

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

    //TODO Lav en menu som vælger hvem du er, og indtaste en unik kode for at komme ind.
    //TODO Hvis brugeren er formand, så skal tage vores første switch
    //TODO Hvis brugeren er træneren så skal den vælge trænerens information og egenskaber

    public void startProgram() {
        System.out.println("Velkommen til Delfinen!");
        medlemController.loadFromFile();
        do {
            /*
            System.out.println("""
                    Er du:
                    1. Formand.
                    2. Træner.
                    3. Kasserer.
                    """);

            try {
                brugerValg = Integer.parseInt(input.nextLine());
            } catch (InputMismatchException | NumberFormatException ime) {
                System.out.println("Skal være et tal!");
            }

            switch (brugerValg) {
                case 1:
                    formand(brugerKode);
                    System.out.println("Hello formand!");

                    break;
                case 2:
                    træner(brugerKode);
                    System.out.println("Hello træner!");
                    break;
                case 3:
                    kasserer(brugerKode);
                    System.out.println("Hello kasserer");
                    break;

            }
            */
            velkomst();


            try {
                userChoice = Integer.parseInt(input.nextLine());
            } catch (InputMismatchException | NumberFormatException ime) {
                System.out.println("Skal være et tal!");
            }


            switch (userChoice) {
                case 1 -> registreMedlemmer();
                case 2 -> visMedlemmer();
                case 3 -> søgEfterMedlem();
                case 9 -> stopProgrammet();
            }


        } while (isRunning);
    }

/*    private boolean formand(int brugerInput) {
        int KODE = 432196;
        brugerInput = 0;
        if (brugerInput == KODE) {
            return true;
            int userChoice1;
            userChoice1 = Integer.parseInt(input.nextLine());
            switch (userChoice1) {

            }
        } else
            return false;
    }


    private boolean træner(int brugerInput) {
        int KODE = 246896;
        brugerInput = 0;
        while (true) {
            if (brugerInput == KODE) {
                return true;
            } else {
                return false;
            }
        }
    }

    private boolean kasserer(int brugerInput) {
        int KODE = 135796;
        while (true) {
            if (brugerInput == KODE) {
                return true;
            } else {
                return false;
            }
        }
    }*/

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
                fornavn = input.nextLine().toUpperCase();
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
                efternavn = input.nextLine().toUpperCase();
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
                adresse = input.nextLine().toUpperCase();
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
                by = input.nextLine().toUpperCase();
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
        System.out.println(fornavn + " er blevet tilføjet!");
    }

    private void visMedlemmer() {
        System.out.println("""
                1: Vis alle medlemmer
                2: Vis junior hold
                3: Vis senior hold""");
        try {
            userChoice = Integer.parseInt(input.nextLine());
        } catch (InputMismatchException | NumberFormatException ime) {
            System.out.println("Skal være et tal!");
        }

        ArrayList<Medlem> medlemArrayList = medlemController.visMedlemmer();
        switch (userChoice) {

            case 1:
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
                                    "Restance: " + medlem.getRestance() + ", " +
                                    "Medlemsnummer: " + medlem.getMedlemsnummer() + ", " +
                                    "Aktivitetsform: " + medlem.getAktivitetsform() + ", " +
                                    "Medlemstype: " + medlem.getMedlemstype());
                }
                break;
            case 2:
                //Printer Junior holdet ud på skærmen
                System.out.println("Liste af alle medlemmer i junior hold");
                for (Medlem medlem : medlemArrayList) {
                    System.out.println("");
                    if (medlem.getAlder() < 18 && medlem.getAktivitetsform() == 'K') {
                        System.out.println("Fornavn: " + medlem.getFornavn() + ", " +
                                "Efternavn: " + medlem.getEfternavn() + ", " +
                                "Adresse: " + medlem.getAdresse() + ", " +
                                "By: " + medlem.getBy() + ", " +
                                "Mail: " + medlem.getMail() + ", " +
                                "Køn (M/K): " + medlem.getKøn() + ", " +
                                "Alder: " + medlem.getAlder() + ", " +
                                "Restance: " + medlem.getRestance() + ", " +
                                "Medlemsnummer: " + medlem.getMedlemsnummer() + ", " +
                                "Aktivitetsform: " + medlem.getAktivitetsform() + ", " +
                                "Medlemstype: " + medlem.getMedlemstype());
                    }
                }
                break;
            case 3:
                //Printer Senior holdet ud på skærmen
                System.out.println("Senior hold");
                for (Medlem medlem : medlemArrayList) {
                    System.out.println("");
                    if (medlem.getAlder() > 18 && medlem.getAktivitetsform() == 'K') {
                        System.out.println("Fornavn: " + medlem.getFornavn() + ", " +
                                "Efternavn: " + medlem.getEfternavn() + ", " +
                                "Adresse: " + medlem.getAdresse() + ", " +
                                "By: " + medlem.getBy() + ", " +
                                "Mail: " + medlem.getMail() + ", " +
                                "Køn (M/K): " + medlem.getKøn() + ", " +
                                "Alder: " + medlem.getAlder() + ", " +
                                "Restance: " + medlem.getRestance() + ", " +
                                "Medlemsnummer: " + medlem.getMedlemsnummer() + ", " +
                                "Aktivitetsform: " + medlem.getAktivitetsform() + ", " +
                                "Medlemstype: " + medlem.getMedlemstype());
                    }
                }
                break;

        }


    }

    private void søgEfterMedlem() {
        System.out.println("Søg efter medlem via medlemsnummer");

        int brugermedlemsnummer;
        brugermedlemsnummer = Integer.parseInt(input.nextLine());

        System.out.println("Søg efter medlem via fornavn");
        String søgNavn;
        søgNavn = input.nextLine().toUpperCase();
        medlemController.søgEfterMedlem(brugermedlemsnummer, søgNavn);

    }


    private void stopProgrammet() {
        System.out.println("Programmet er hermed stoppet");
        medlemController.exit();
        isRunning = false;
    }
}

