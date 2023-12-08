package datasource;

import comparator.placeringComparator;
import comparator.tidComparator;
import domain.Medlem;
import domain.Resultat;

import java.text.SimpleDateFormat;
import java.util.*;

import betalingAfKontigent.*;

import javax.swing.*;

public class Database {
    Random random = new Random();
    Date date = new Date();
    FileHandler fileHandler = new FileHandler();

    //TODO Definer resultat-liste

    public ArrayList<Medlem> medlemArrayList = new ArrayList<>();
    private Set<Integer> generedeMedlemsnumre = new HashSet<>();
    private ArrayList<Resultat> resultater = new ArrayList<>();


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

    public ArrayList<Medlem> getMedlemmer() {
        return medlemArrayList;
    }

    public void gemÆndringer() {
        fileHandler.indsætResultater(resultater);
        fileHandler.indsætMedlemmer(medlemArrayList);
        fileHandler.indsætJuniorMedlem(medlemArrayList);
        fileHandler.indsætSeniorMedlem(medlemArrayList);

    }

    public void redigereMedlem(int medlemsnummer, String fornavn, String efternavm, String mail, String adresse, String by, char medlemstype, char aktivitetsform) {
        for (Medlem medlem : medlemArrayList) {
            if (medlem.getMedlemsnummer() == medlemsnummer) {
                medlem.setFornavn(fornavn);
                medlem.setEfternavn(efternavm);
                medlem.setMail(mail);
                medlem.setAdresse(adresse);
                medlem.setBy(by);
                medlem.setMedlemstype(medlemstype);
                medlem.setAktivitetsform(aktivitetsform);
            }
        }

    }


    public void loadFromFile() {
        ArrayList<Medlem> loadedMedlemArrayList;
        loadedMedlemArrayList = fileHandler.indlæsFraCSVFil();
        if (loadedMedlemArrayList != null) {
            //medlemArrayList.clear();
            medlemArrayList = loadedMedlemArrayList;
            //loadedMedlemArrayList.clear();
        } else {
            System.out.println("Ingen gemte medlemmer.");
        }
    }

    public void loadFromResultatFile() {
        ArrayList<Resultat> loadResultatList;
        loadResultatList = fileHandler.indlæsFraResultatCSVFil();
        if (loadResultatList != null) {
            resultater = loadResultatList;
        }
    }

    public void loadFromJuniorFile() {
        ArrayList<Medlem> loadJuniorMedlem;
        loadJuniorMedlem = fileHandler.indlæsFraJuniorCSVFil();
        if (loadJuniorMedlem != null) {
            medlemArrayList = loadJuniorMedlem;
        }
    }

    public void loadFromSeniorFile() {
        ArrayList<Medlem> loadSeniorMedlem;
        loadSeniorMedlem = fileHandler.indlæsFraSeniorCSVFil();
        if (loadSeniorMedlem != null) {
            medlemArrayList = loadSeniorMedlem;
        }
    }

    //TODO: Lav en unit test til denne metode
    public void søgEfterMedlem(int medlemsnummer, String søgNavn) {
        for (Medlem medlem : medlemArrayList) {
            if (medlem.getMedlemsnummer() == medlemsnummer) {
                System.out.println(medlem);
                break;
            }/* else if (medlem.getFornavn().toLowerCase().contains(søgNavn) || medlem.getFornavn().toUpperCase().contains(søgNavn)) {
                System.out.println(medlem);
                break;
            }*/
        }
    }

    public void fjernMedlememer(int søgeMedlemsnummer) {
        medlemArrayList.removeIf(medlem -> søgeMedlemsnummer == medlem.getMedlemsnummer());

    }

    public void resultat(int medlemsnummer, String disciplin, double tid, String stævne, int placering, String dato) {
        Resultat resultat = new Resultat(disciplin, tid, stævne, placering, dato, medlemsnummer);
        for (Medlem medlem : medlemArrayList) {
            if (medlemsnummer == medlem.getMedlemsnummer()) {
                resultater.add(resultat);
            }
        }
    }

    public ArrayList getResultater() {
        return resultater;
    }

    public int årligJuniorBetaling(int betaling, int medlemsnummer) {
        int restBeløb = 0;
        for (Medlem medlem : medlemArrayList) {
            if (medlem.getMedlemsnummer() == medlemsnummer && medlem.getAlder() <= 17 && medlem.getMedlemstype() != 'P') {
                JuniorBetaling juniorBetaling = new JuniorBetaling(betaling);
                restBeløb = juniorBetaling.rest();
            }
        }
        return restBeløb;
    }

    public int årligSeniorBetaling(int betaling, int medlemsnummer) {
        int restBeløb = 0;
        for (Medlem medlem : medlemArrayList) {
            if (medlem.getMedlemsnummer() == medlemsnummer && medlem.getAlder() >= 18 && medlem.getMedlemstype() != 'P') {
                SeniorBetaling seniorBetaling = new SeniorBetaling(betaling);
                restBeløb = seniorBetaling.rest();
            }
        }
        return restBeløb;
    }

    public int årligOver60Betaling(int betaling, int medlemsnummer) {
        int restBeløb = 0;
        for (Medlem medlem : medlemArrayList) {
            if (medlem.getMedlemsnummer() == medlemsnummer && medlem.getAlder() >= 60 && medlem.getMedlemstype() != 'P') {
                Over60 over60 = new Over60(betaling);
                restBeløb = over60.rest();
            }
        }
        return restBeløb;
    }

    public int årligPassivBetaling(int betaling, int medlemsnummer) {
        int restBeløb = 0;
        for (Medlem medlem : medlemArrayList) {
            if (medlem.getMedlemsnummer() == medlemsnummer && medlem.getMedlemstype() == 'P') {
                PassivMedlem passivMedlem = new PassivMedlem(betaling);
                restBeløb = passivMedlem.rest();
            }
        }
        return restBeløb;
    }

    public ArrayList sorterTop5JuniorHold() {
        ArrayList<Medlem> juniorSvømmere = fileHandler.indlæsFraJuniorCSVFil();
        ArrayList<Resultat> tidJuniorSvømmere = new ArrayList<>();
        ArrayList<Resultat> topFemResultater = new ArrayList<>();
        for (Medlem medlem : juniorSvømmere) {
            for (Resultat resultat : resultater) {
                if (medlem.getMedlemsnummer() == resultat.getMedlemsnummer()) {
                    tidJuniorSvømmere.add(resultat);
                }
            }
        }
        Collections.sort(tidJuniorSvømmere, new placeringComparator().thenComparing(new tidComparator()).reversed());
        for (int i = 0; i < Math.min(5, tidJuniorSvømmere.size()); i++) {
            topFemResultater.add(tidJuniorSvømmere.get(i));
        }
        return topFemResultater;
    }

    public ArrayList sorterTop5SeniorHold() {
        ArrayList<Medlem> seniorSvømmere = fileHandler.indlæsFraSeniorCSVFil();
        ArrayList<Resultat> tidSeniorSvømmere = new ArrayList<>();
        ArrayList<Resultat> topFemResultater = new ArrayList<>();
        for (Medlem medlem : seniorSvømmere) {
            for (Resultat resultat : resultater) {
                if (medlem.getMedlemsnummer() == resultat.getMedlemsnummer()) {
                    tidSeniorSvømmere.add(resultat);
                }
            }
            Collections.sort(tidSeniorSvømmere, new placeringComparator().thenComparing(new tidComparator()).reversed());
            for (int i = 0; i <Math.min(5, tidSeniorSvømmere.size()); i++) {
                topFemResultater.add(tidSeniorSvømmere.get(i));
            }
        }
        return topFemResultater;
    }
}

