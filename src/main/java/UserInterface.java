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
    private String disciplin;
    private double tid;
    private int dag;
    private int måned;
    private int år;
    private String dato;
    private String stævne;
    private int placering;


    //TODO Lav en menu som vælger hvem du er, og indtaste en unik kode for at komme ind.
    //TODO Hvis brugeren er formand, så skal tage vores første switch
    //TODO Hvis brugeren er træneren så skal den vælge trænerens information og egenskaber

    public void startProgram() {
        System.out.println("Velkommen til Delfinen!");
        medlemController.loadFromFile();
        medlemController.loadFromResultatFile();
        do {

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
                case 4 -> registrerResultat();
                case 5 -> visResultater();
                case 6 -> fjernMedlemmer();
                case 7 -> redigereMedlemmer();
                case 8 -> sorterSvømmere();
                case 9 -> stopProgrammet();

            }


        } while (isRunning);
    }



    private void velkomst() {

        System.out.println("""
                1. Registre et nyt medlem   \s
                2. Vis medlemmer           \s
                3. Søg efter medlemmer     \s
                4. Registre resultat
                5. Vis resultater
                6. Fjern et medlem
                7. Redigerer stamoplysninnger.
                8. Sorter svømmere
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

    private void fjernMedlemmer() {
        try {
            System.out.print("Indtast medlemsnummer: ");
            System.out.println("Medlem er fjernet");
            medlemsnummer = Integer.parseInt(input.nextLine());
            medlemController.fjernMedlemmer(medlemsnummer);
        } catch (NumberFormatException nfe) {
            System.out.println("Medlems nummer findes ikke.");
        }

    }

    private void redigereMedlemmer() {
        System.out.println("Indtast medlensnummer");
        medlemsnummer = Integer.parseInt(input.nextLine());
        System.out.println(" Indtast fornavn");
        fornavn = input.nextLine();
        System.out.println("Indtast efternavn");
        efternavn = input.nextLine();
        System.out.println("Indtast mail");
        mail = input.nextLine();
        System.out.println(" Indtast adresse");
        adresse = input.nextLine();
        System.out.println("Indtast by");
        by = input.nextLine();
        System.out.println("Indtast medlemstype");
        medlemstype = input.nextLine().toUpperCase().charAt(0);
        System.out.println("Indtast aktivitetsform");
        aktivitetsform = input.nextLine().toUpperCase().charAt(0);
        medlemController.redigereMedlememr(medlemsnummer, fornavn, efternavn, mail, adresse, by, medlemstype, aktivitetsform);
    }


    private void stopProgrammet() {
        System.out.println("Programmet er hermed stoppet");
        medlemController.exit();
        isRunning = false;
    }

    private void registrerResultat() {
            boolean firstLoop = true;
        while (firstLoop) {
            System.out.print("""
                    indtast medlemsnummer\s""");
            try {
                medlemsnummer = Integer.parseInt(input.nextLine());
                if (medlemController.tjeckOmmedlemErIListe(medlemsnummer)){
                    firstLoop=false;
                }else {
                    System.out.println("eksisterer ikke");
                }
               /* if (medlemController.visMedlemmer().contains(medlemsnummer)){
                    firstLoop=false;
                }*/
            } catch (Exception e){
                System.out.println("indtast tal");
            }

        }

        while (true) {
            System.out.print("""
                    indtast disciplin\s""");
            try {
                disciplin = input.nextLine().toUpperCase();
            } catch (Exception e) {
                System.out.println("indtast bogstaver");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("""
                    svømme tid\s""");
            try {
                tid = Double.parseDouble(input.nextLine().toUpperCase());
            } catch (NumberFormatException nfe) {
                System.out.println("indtast nummer");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("""
                    indtast stævner\s""");
            try {
                stævne = input.nextLine().toUpperCase();
            } catch (Exception e) {
                System.out.println("indtast bogstaver");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("""
                    indtast placering\s""");
            try {
                placering = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("indtast et nummer");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("""
                    indtast dato\s""");
            try {
                System.out.print("Indtast dag: ");
                dag = Integer.parseInt(input.nextLine());
                System.out.print("Indtast måned: ");
                måned = Integer.parseInt(input.nextLine());
                System.out.print("Indtast år: ");
                år = Integer.parseInt(input.nextLine());

            } catch (NumberFormatException nfe) {
                System.out.println("indtast dag/måned/år");
                continue;
            }
            dato = dag + "/" + måned + "/" + år;
            break;
        }


        medlemController.resultat(medlemsnummer, disciplin, tid, stævne, placering, dato);
    }

    private void sorterSvømmere(){
        System.out.println("Test success");
        //TODO Step 1 Indlæse CSV filer fra junior og senior hold
        //TODO Step 2 Vælge hvilket hold du vil sortere (senior eller junior)
        //TODO Step 3 Juster koden så admin kan trykke 1 - 4 der repræsenter hver disciplin
        //TODO Step 4 Brugeren skal vælge hvilken disciplin de vil sortere
        //TODO Step 5 Sætte en limiter for at foreach loopen ikke overskrider værdien 5, så den stopper efter værdien 5.
        //TODO Step 6 Vise top 5 svømmere for den ønskede disciplin

    }

    private void visResultater() {
        System.out.println(medlemController.getResultater());
    }
}

