import static org.junit.Assert.*;
import org.junit.Test;

public class OrderTestStudent {
    @Test
    public void testOrderAddBeveragesAndTotal() {
        Order order = new Order(10, Day.MONDAY, new Customer("Test", 25));
        order.addNewBeverage("Latte", Size.MEDIUM, true, false);
        order.addNewBeverage("Mango", Size.SMALL, 2, true);
        order.addNewBeverage("Whiskey", Size.SMALL);
        assertEquals(3, order.getTotalItems());
        assertTrue(order.calcOrderTotal() > 0);
    }

    @Test
    public void testIsWeekend() {
        Order order = new Order(12, Day.SUNDAY, new Customer("Ken", 30));
        assertTrue(order.isWeekend());
    }

    @Test
    public void testCompareTo() {
        Order o1 = new Order(8, Day.TUESDAY, new Customer("Tom", 20));
        Order o2 = new Order(9, Day.WEDNESDAY, new Customer("Tom", 20));
        assertNotEquals(0, o1.compareTo(o2));
    }
}
