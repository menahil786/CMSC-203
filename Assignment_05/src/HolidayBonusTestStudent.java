import static org.junit.Assert.*;
import org.junit.Test;

public class HolidayBonusTestStudent {

    @Test
    public void testCalculateHolidayBonus() {
        double[][] salesData = {
            {1000, 2000, 3000},
            {4000, 5000},
            {6000, 7000, 8000}
        };

        // Expected bonus based on rules:
        // First column: 6000 (high), 4000 (mid), 1000 (low)
        // Second column: 7000 (high), 5000 (mid), 2000 (low)
        // Third column: 8000 (high), 3000 (low)
        double[] expected = {3000.0, 4000.0, 15000.0};
        double[] result = HolidayBonus.calculateHolidayBonus(salesData);

        assertArrayEquals("Holiday bonuses not calculated correctly", expected, result, 0.001);
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double[][] salesData = {
            {1000, 2000, 3000},
            {4000, 5000},
            {6000, 7000, 8000}
        };

        double expectedTotal = 22000.0;
        double resultTotal = HolidayBonus.calculateTotalHolidayBonus(salesData);

        assertEquals("Total holiday bonus not calculated correctly", expectedTotal, resultTotal, 0.001);
    }
}
