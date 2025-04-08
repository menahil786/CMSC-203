import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlotTestStudent {

    private Plot plot1;
    private Plot plot2;
    private Plot plot3;
    private Plot plot4;

    @BeforeEach
    public void setUp() {
        plot1 = new Plot(1, 1, 4, 4);
        plot2 = new Plot(2, 2, 2, 2); // inside plot1
        plot3 = new Plot(6, 6, 3, 3); // no overlap
        plot4 = new Plot(plot1);     // copy constructor
    }

    @AfterEach
    public void tearDown() {
        plot1 = plot2 = plot3 = plot4 = null;
    }

    @Test
    public void testDefaultConstructor() {
        Plot p = new Plot();
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
        assertEquals(1, p.getWidth());
        assertEquals(1, p.getDepth());
    }

    @Test
    public void testParameterizedConstructor() {
        assertEquals(1, plot1.getX());
        assertEquals(1, plot1.getY());
        assertEquals(4, plot1.getWidth());
        assertEquals(4, plot1.getDepth());
    }

    @Test
    public void testCopyConstructor() {
        assertEquals(plot1.getX(), plot4.getX());
        assertEquals(plot1.getY(), plot4.getY());
        assertEquals(plot1.getWidth(), plot4.getWidth());
        assertEquals(plot1.getDepth(), plot4.getDepth());
    }

    @Test
    public void testOverlaps() {
        assertTrue(plot1.overlaps(plot2));
        assertFalse(plot1.overlaps(plot3));
    }

    @Test
    public void testEncompasses() {
        assertTrue(plot1.encompasses(plot2));
        assertFalse(plot2.encompasses(plot1));
    }

    @Test
    public void testToString() {
        assertEquals("1,1,4,4", plot1.toString());
    }

    @Test
    public void testSettersAndGetters() {
        Plot p = new Plot();
        p.setX(3);
        p.setY(4);
        p.setWidth(5);
        p.setDepth(6);

        assertEquals(3, p.getX());
        assertEquals(4, p.getY());
        assertEquals(5, p.getWidth());
        assertEquals(6, p.getDepth());
    }
} 
