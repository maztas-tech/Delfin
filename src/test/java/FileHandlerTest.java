import datasource.FileHandler;
import domain.Medlem;
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

    //TODO: Load data fra Test-fil, sammenlign antal af nye medlemmer.
    @Test
    void indlæsFraCSVFil() {
        //Arrange

        ArrayList<Medlem> expectedResult = new ArrayList<>();
        //Act
        expectedResult.add(new Medlem("Saka", "saka", "saka", "saka", "saka", 'M', 2, 237202, "false", 'M', 'A'));
        expectedResult.add(new Medlem("Anas", "Faisal", "Frederiksberg", "1950", "mail@mail.com", 'M', 27, 237267, "false", 'M', 'A'));

        //Assert


        FileHandler fileHandler = new FileHandler();
        ArrayList<Medlem> actualResult = fileHandler.indlæsFraCSVFil();


        assertEquals(actualResult.size(), expectedResult.size());

    }
}