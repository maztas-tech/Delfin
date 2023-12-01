import datasource.Database;
import org.junit.jupiter.api.Test;

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
        int number3 = 321;

        //Act
        generedeMedlemsnumre.add(number1);
        generedeMedlemsnumre.add(number2);
        generedeMedlemsnumre.add(number3);

        //Assert
        int actualSize = generedeMedlemsnumre.size();
        int expectedSize = 2;

        assertEquals(actualSize, expectedSize);

    }
}