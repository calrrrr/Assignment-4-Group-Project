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
}
