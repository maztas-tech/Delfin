import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

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


}
