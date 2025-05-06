import static org.junit.Assert.*;
import org.junit.Test;

public class AlcoholTestStudent {

    @Test
    public void testAlcoholWeekendPrice() {
        Alcohol drink = new Alcohol("Whiskey", Size.SMALL, true);
        // Base 2.0 + weekend 0.6 = 2.6
        assertEquals(2.6, drink.calcPrice(), 0.01);
    }

    @Test
    public void testAlcoholEquals() {
        Alcohol a1 = new Alcohol("Vodka", Size.MEDIUM, false);
        Alcohol a2 = new Alcohol("Vodka", Size.MEDIUM, false);
        assertTrue(a1.equals(a2));
    }
} 
