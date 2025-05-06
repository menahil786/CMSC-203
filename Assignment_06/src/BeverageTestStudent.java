import static org.junit.Assert.*;
import org.junit.Test;

public class BeverageTestStudent {

    @Test
    public void testBasePriceAndSizePrice() {
        Beverage coffee = new Coffee("Test", Size.SMALL, false, false);
        assertEquals(2.0, coffee.calcPrice(), 0.01);

        Beverage medium = new Coffee("Test", Size.MEDIUM, false, false);
        assertEquals(2.5, medium.calcPrice(), 0.01);

        Beverage large = new Coffee("Test", Size.LARGE, false, false);
        assertEquals(3.0, large.calcPrice(), 0.01);
    }

    @Test
    public void testGettersSetters() {
        Beverage b = new Coffee("Flat White", Size.SMALL, false, false);
        b.setName("Flat");
        b.setSize(Size.MEDIUM);
        assertEquals("Flat", b.getBevName());
        assertEquals(Size.MEDIUM, b.getSize());
    }

    @Test
    public void testEqualsDifferentObjects() {
        Beverage b1 = new Coffee("Mocha", Size.SMALL, false, false);
        Beverage b2 = new Coffee("Mocha", Size.MEDIUM, false, false);
        assertFalse(b1.equals(b2));
    }

    @Test
    public void testToStringIncludesNameAndSize() {
        Beverage b = new Coffee("Americano", Size.LARGE, true, false);
        assertTrue(b.toString().contains("Americano"));
        assertTrue(b.toString().contains("LARGE"));
    }
}
