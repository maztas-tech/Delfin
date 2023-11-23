import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
                40, true, 'A', 'M');

        db.registreMedlemmer("Anders", "Mogens", "Farumhovedgade",
                "Farum", "andersm@gmail.com", 'M',
                40, false, 'A', 'M');

        //Act
        int actualResult = db.medlemArrayList.size();

        //Assert
        int expectedResult = 2;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    void medlemsnummerGenerator() {
        //Arrange
        generedeMedlemsnumre.add(123);
        //Act
        generedeMedlemsnumre.equals(123);
        //Assert
    }
}