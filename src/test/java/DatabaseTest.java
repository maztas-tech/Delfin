import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Database db = new Database();
    private Set<Integer> generedeMedlemsnumre = new HashSet<>();

    @Test
    void registreMedlemmer() {
        //Arrange
        db.registreMedlemmer("Anders", "Mogens", "Farumhovedgade",
                "Farum", "andersm@gmail.com", 'M',
                40, "Ja", 'A', 'M');

        db.registreMedlemmer("Anders", "Mogens", "Farumhovedgade",
                "Farum", "andersm@gmail.com", 'M',
                40, "Nej", 'A', 'M');

        //Act
        int actualResult = db.medlemArrayList.size();

        //Assert
        int expectedResult = 2;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    void medlemsnummerGenerator() {
        //Arrange
        int number1 = 123;
        int number2 = 123;

        //Act
        generedeMedlemsnumre.add(number1);
        generedeMedlemsnumre.add(number2);

        //Assert
        int actualSize = generedeMedlemsnumre.size();
        int expectedSize = 1;

        assertEquals(actualSize, expectedSize);

    }
}