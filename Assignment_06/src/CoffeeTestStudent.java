import static org.junit.Assert.*;
import org.junit.Test;

public class CoffeeTestStudent {

    @Test
    public void testCoffeePriceWithExtras() {
        Coffee coffee = new Coffee("Cappuccino", Size.LARGE, true, true);
        // Base 2.0 + size 1.0 + shot 0.5 + syrup 0.5 = 4.0
        assertEquals(4.0, coffee.calcPrice(), 0.01);
    }

    @Test
    public void testCoffeeEquals() {
        Coffee c1 = new Coffee("Latte", Size.MEDIUM, false, true);
        Coffee c2 = new Coffee("Latte", Size.MEDIUM, false, true);
        assertTrue(c1.equals(c2));
    }
} 
