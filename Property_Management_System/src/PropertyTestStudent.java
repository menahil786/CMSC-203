import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyTestStudent {

    Property propertyDefault, propertyFull, propertyPartial, propertyCopy;

    @BeforeEach
    public void setUp() throws Exception {
        propertyDefault = new Property();
        propertyFull = new Property("Palm Springs", "Miami", 4200.00, "Sam Green", 1, 2, 3, 4);
        propertyPartial = new Property("Ocean Breeze", "San Diego", 3900.50, "Lila Moon");
        propertyCopy = new Property(propertyFull);
    }

    @AfterEach
    public void tearDown() throws Exception {
        propertyDefault = propertyFull = propertyPartial = propertyCopy = null;
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals("", propertyDefault.getPropertyName());
        assertEquals("", propertyDefault.getCity());
        assertEquals(0.0, propertyDefault.getRentAmount());
        assertEquals("", propertyDefault.getOwner());
    }

    @Test
    public void testFullConstructor() {
        assertEquals("Palm Springs", propertyFull.getPropertyName());
        assertEquals("Miami", propertyFull.getCity());
        assertEquals(4200.00, propertyFull.getRentAmount());
        assertEquals("Sam Green", propertyFull.getOwner());
        assertEquals("1,2,3,4", propertyFull.getPlot().toString());
    }

    @Test
    public void testPartialConstructor() {
        assertEquals("Ocean Breeze", propertyPartial.getPropertyName());
        assertEquals("San Diego", propertyPartial.getCity());
        assertEquals(3900.50, propertyPartial.getRentAmount());
        assertEquals("Lila Moon", propertyPartial.getOwner());
        assertEquals("0,0,1,1", propertyPartial.getPlot().toString());
    }

    @Test
    public void testCopyConstructor() {
        assertEquals(propertyFull.getPropertyName(), propertyCopy.getPropertyName());
        assertEquals(propertyFull.getCity(), propertyCopy.getCity());
        assertEquals(propertyFull.getRentAmount(), propertyCopy.getRentAmount());
        assertEquals(propertyFull.getOwner(), propertyCopy.getOwner());
        assertEquals(propertyFull.getPlot().toString(), propertyCopy.getPlot().toString());
    }

    @Test
    public void testToString() {
        assertEquals("Palm Springs,Miami,Sam Green,4200.0", propertyFull.toString());
    }
} 
