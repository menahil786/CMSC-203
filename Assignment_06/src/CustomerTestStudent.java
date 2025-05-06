import static org.junit.Assert.*;
import org.junit.Test;

public class CustomerTestStudent {
    @Test
    public void testCustomerCopyConstructor() {
        Customer original = new Customer("Alice", 30);
        Customer copy = new Customer(original);
        assertEquals(original.getName(), copy.getName());
        assertNotSame(original, copy);
    }

    @Test
    public void testToString() {
        Customer customer = new Customer("Bob", 21);
        assertTrue(customer.toString().contains("Bob"));
    }
}