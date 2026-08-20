import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach; 
 
public class ContactTest { 

    Contact c;
 
    // My adapted BeforeEach tests
    @BeforeEach
    void setup() { 
        c = new Contact("Ada Lovelace", "+1 617 555 0101"); 
    }

    @Test 
    void constructor_setsNameCorrectly() { 
        assertEquals("Ada Lovelace", c.getName()); 
    } 

    @Test
    void constructor_setsPhoneCorrectly() { 
        assertEquals("+1 617 555 0101", c.getPhone()); 
    } 

    @Test
    void getName_returnsExactString_notTransformed() { 
        assertEquals("Ada Lovelace", c.getName());
    } 

    @Test
    void toString_containsName() { 
        assertTrue(c.toString().contains("Ada Lovelace"));
    } 

    @Test
    void toString_containsPhone() {
        assertTrue(c.toString().contains("+1 617 555 0101"));
    }

    // My tests start here
    @Test
    void constructor_handlesNullName() {
        Contact c = new Contact(null, "555 0000");
        assertNull(c.getName());
    }

    @Test
    void constructor_handlesNullPhone() {
        Contact c = new Contact("Chris", null);
        assertNull(c.getPhone());
    }

    @Test
    void toString_handlesNullName() {
        Contact c = new Contact(null, "555 0000");
        assertTrue(c.toString().contains("null"));
    }

    @Test
    void toString_handlesNullPhone() {
        Contact c = new Contact("Chris", null);
        assertTrue(c.toString().contains("null"));
    }
} 