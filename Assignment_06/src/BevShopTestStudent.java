import static org.junit.Assert.*;
import org.junit.Test;

public class BevShopTestStudent {
    @Test
    public void testStartNewOrderAndGetters() {
        BevShop shop = new BevShop();
        shop.startNewOrder(9, Day.FRIDAY, "Linda", 25);
        assertEquals("Linda", shop.getCurrentOrder().getCustomer().getName());
    }

    @Test
    public void testProcessOrdersAndSales() {
        BevShop shop = new BevShop();
        shop.startNewOrder(8, Day.SATURDAY, "Max", 22);
        shop.processAlcoholOrder("Beer", Size.SMALL);
        shop.processCoffeeOrder("Latte", Size.SMALL, true, true);
        shop.processSmoothieOrder("Banana", Size.LARGE, 3, false);
        assertEquals(3, shop.getCurrentOrder().getTotalItems());
        assertTrue(shop.totalMonthlySale() > 0);
    }

    @Test
    public void testSortOrders() {
        BevShop shop = new BevShop();
        shop.startNewOrder(9, Day.MONDAY, "Zack", 40);
        shop.startNewOrder(10, Day.TUESDAY, "Aaron", 19);
        shop.sortOrders();
        assertTrue(shop.getOrderAtIndex(0).getOrderNo() <= shop.getOrderAtIndex(1).getOrderNo());
    }
}
