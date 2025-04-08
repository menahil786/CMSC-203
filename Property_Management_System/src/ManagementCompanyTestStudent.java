import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagementCompanyTestStudent {

    ManagementCompany mgmt;
    Property prop1, prop2, propOverlap;

    @BeforeEach
    public void setUp() throws Exception {
        mgmt = new ManagementCompany("GreenTree", "123456789", 10);
        prop1 = new Property("Sunset Villas", "LA", 3000, "Alice", 1, 1, 2, 2);
        prop2 = new Property("Oceanview", "LA", 4000, "Bob", 4, 1, 2, 2);
        propOverlap = new Property("Conflict", "LA", 3000, "Clash", 1, 1, 3, 3); // Overlaps prop1
    }

    @AfterEach
    public void tearDown() throws Exception {
        mgmt = null;
        prop1 = prop2 = propOverlap = null;
    }

    @Test
    public void testAddProperty() {
        assertEquals(0, mgmt.addProperty(prop1));
        assertEquals(1, mgmt.addProperty(prop2));
    }

    @Test
    public void testAddNullProperty() {
        assertEquals(-2, mgmt.addProperty(null));
    }

    @Test
    public void testAddPropertyOverlap() {
        mgmt.addProperty(prop1);
        assertEquals(-4, mgmt.addProperty(propOverlap));
    }

    @Test
    public void testTotalRent() {
        mgmt.addProperty(prop1);
        mgmt.addProperty(prop2);
        assertEquals(7000.0, mgmt.getTotalRent());
    }

    @Test
    public void testGetPropertiesCount() {
        mgmt.addProperty(prop1);
        assertEquals(1, mgmt.getPropertiesCount());
    }

    @Test
    public void testIsPropertiesFull() {
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            mgmt.addProperty("Prop" + i, "City", 2000 + i, "Owner" + i, i * 2, 0, 1, 1); // unique plots to avoid overlap
        }
        assertTrue(mgmt.isPropertiesFull());
    }

    @Test
    public void testGetHighestRentProperty() {
        mgmt.addProperty(prop1);
        mgmt.addProperty(prop2);
        assertEquals("Oceanview", mgmt.getHighestRentProperty().getPropertyName());
    }

    @Test
    public void testToString() {
        mgmt.addProperty(prop1);
        String expected = "List of the properties for GreenTree, taxID: 123456789\n"
                + "______________________________________________________\n"
                + "Sunset Villas,LA,Alice,3000.0\n"
                + "______________________________________________________\n\n"
                + " total management Fee: 300.0";
        assertEquals(expected, mgmt.toString());
    }
} 
