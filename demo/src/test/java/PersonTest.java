import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import com.example.Person;

public class PersonTest {

    File testFile = new File("test_output.txt");

    @Test
    void testValidPersonData() {
        Person person = new Person();
        boolean result = person.addPerson("56!@abc#CD", "123|Main St|Melbourne|Victoria|Australia", "15-11-1990", testFile);
        assertTrue(result);
    }

    @Test
    void testInvalidPersonIDLength() {
        Person person = new Person();
        boolean result = person.addPerson("56!@abcCD", "123|Main St|Melbourne|Victoria|Australia", "15-11-1990", testFile);
        assertFalse(result);
    }

    @Test
    void testInvalidPersonIDSpecialCharCount() {
        Person person = new Person();
        boolean result = person.addPerson("56abcdefFG", "123|Main St|Melbourne|Victoria|Australia", "15-11-1990", testFile);
        assertFalse(result);
    }

    @Test
    void testInvalidAddressFormat() {
        Person person = new Person();
        boolean result = person.addPerson("56!@abc#CD", "Main St, Melbourne, Victoria", "15-11-1990", testFile);
        assertFalse(result);
    }

    @Test
    void testInvalidStateInAddress() {
        Person person = new Person();
        boolean result = person.addPerson("56!@abc#CD", "123|Main St|Melbourne|New South Wales|Australia", "15-11-1990", testFile);
        assertFalse(result);
    }

    @Test
    void testInvalidBirthdateFormat() {
        Person person = new Person();
        boolean result = person.addPerson("56!@abc#CD", "123|Main St|Melbourne|Victoria|Australia", "1990-11-15", testFile);
        assertFalse(result);
    }

    //test-case for addDemeritPoints

    @Test
    void testValidAdultNoSuspension() {
        Person person = new Person();
        boolean result = person.addPerson("57s_d@%fDA", "123|Main St|Melbourne|Victoria|Australia", "15-11-1990", testFile);
        assertTrue(result);
        String result2 = person.addDemeritPoints("57s_d@%fDA", 3, "10-05-2024", testFile);
        assertEquals("Success", result2);
        assertFalse(person.isSuspended());
    }

    @Test
    void testInvalidDateFormat() {
        Person person = new Person();
        boolean result = person.addPerson("57s_d@%fDA", "123|Main St|Melbourne|Victoria|Australia", "15-11-1991", testFile);
        assertTrue(result);
        String result2 = person.addDemeritPoints("57s_d@%fDA", 3, "2024-05-10", testFile); 
        assertEquals("Failed", result2);
    }

    @Test
    void testPointsOutOfRange() {
        Person person = new Person();
        boolean result = person.addPerson("57s_d@%fDA", "123|Main St|Melbourne|Victoria|Australia", "15-11-1992", testFile);
        assertTrue(result);
        String result2 = person.addDemeritPoints("57s_d@%fDA", 7, "10-05-2024", testFile); 
        assertEquals("Failed", result2);
    }

    @Test
    void testUnderageSuspension() {
        Person person = new Person();
        boolean result = person.addPerson("57s_d@%fDA", "123|Main St|Melbourne|Victoria|Australia", "15-11-2023", testFile);
        assertTrue(result);
        person.addDemeritPoints("57s_d@%fDA", 3, "01-05-2024", testFile);
        person.addDemeritPoints("57s_d@%fDA", 4, "10-05-2024", testFile); 
        assertTrue(person.isSuspended());
    }

    @Test
    void testWrongPersonID() {
        Person person = new Person();
        boolean result = person.addPerson("57s_d@%fDA", "123|Main St|Melbourne|Victoria|Australia", "15-11-1993", testFile);
        assertTrue(result);
        String result2 = person.addDemeritPoints("WRONGID", 3, "10-05-2024", testFile);
        assertEquals("Failed", result2);
    }       

}
