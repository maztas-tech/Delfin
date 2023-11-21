import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Database db = new Database();

    @Test
    void registreMedlemmer() {
        //Arrange
        db.registreMedlemmer("Anders", "Mogens", "Farumhovedgade",
                "Farum", "andersm@gmail.com", 'M',
                40, 4023, false, 'M', 'A');

        db.registreMedlemmer("Anders", "Mogens", "Farumhovedgade",
                "Farum", "andersm@gmail.com", 'M',
                40, 4023, false, 'M', 'A');

        //Act
        int actualResult = db.medlemArrayList.size();

        //Assert
        int expectedResult = 2;
        assertEquals(actualResult, expectedResult);
    }

}