import static org.junit.Assert.*;
import org.junit.Test;

public class SmoothieTestStudent {

    @Test
    public void testSmoothiePriceWithProtein() {
        Smoothie smoothie = new Smoothie("Green Boost", Size.MEDIUM, 2, true);
        // Base 2.0 + size 0.5 + 2 fruits (1.0) + protein (1.5) = 5.0
        assertEquals(5.0, smoothie.calcPrice(), 0.01);
    }

    @Test
    public void testSmoothieEquals() {
        Smoothie s1 = new Smoothie("Tropical", Size.SMALL, 1, false);
        Smoothie s2 = new Smoothie("Tropical", Size.SMALL, 1, false);
        assertTrue(s1.equals(s2));
    }
} 
