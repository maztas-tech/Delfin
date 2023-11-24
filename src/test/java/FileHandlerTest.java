import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void loadFromFile() {
        //Arrange
        FileHandler fileHandler = new FileHandler();
        //Act
        ArrayList<Medlem> actualResult = fileHandler.loadFromFile();
        //Assert
        ArrayList<Medlem> expectedResult = new ArrayList<>();
        expectedResult.add(new Medlem("Saka", "saka", "saka", "saka", "saka", 'M', 2, 237202, false, 'M', 'A'));
        expectedResult.add(new Medlem("Anas", "Faisal", "Frederiksberg", "1950", "mail@mail.com", 'M', 27, 237267, false, 'M', 'A'));
        expectedResult.add(new Medlem("Sam", "Sam", "Sam", "Sam", "Sam", 'M', 22222, 233214, false, 'M', 'A'));
        expectedResult.add(new Medlem("Anas", "Saka", "Sam", "Maz", "Maz", 'M', 2222222, 233523, false, 'M', 'A'));
        assertEquals(expectedResult, actualResult);

    }
}