import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.*;

public class TwoDimRaggedArrayUtilityTestStudent {

    private static final double[][] TEST_ARRAY = {
        {1.0, 2.0, 3.0},
        {4.0, 5.0},
        {6.0, 7.0, 8.0, 9.0}
    };

    @Test
    public void testGetTotal() {
        assertEquals(45.0, TwoDimRaggedArrayUtility.getTotal(TEST_ARRAY), 0.001);
    }

    @Test
    public void testGetAverage() {
        assertEquals(5.0, TwoDimRaggedArrayUtility.getAverage(TEST_ARRAY), 0.001);
    }

    @Test
    public void testGetRowTotal() {
        assertEquals(6.0, TwoDimRaggedArrayUtility.getRowTotal(TEST_ARRAY, 0), 0.001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getRowTotal(TEST_ARRAY, 1), 0.001);
    }

    @Test
    public void testGetColumnTotal() {
        assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(TEST_ARRAY, 0), 0.001); // 1+4+6
        assertEquals(14.0, TwoDimRaggedArrayUtility.getColumnTotal(TEST_ARRAY, 1), 0.001); // 2+5+7
    }

    @Test
    public void testGetHighestInRow() {
        assertEquals(3.0, TwoDimRaggedArrayUtility.getHighestInRow(TEST_ARRAY, 0), 0.001);
        assertEquals(5.0, TwoDimRaggedArrayUtility.getHighestInRow(TEST_ARRAY, 1), 0.001);
    }

    @Test
    public void testGetHighestInRowIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(TEST_ARRAY, 0));
        assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(TEST_ARRAY, 1));
    }

    @Test
    public void testGetLowestInRow() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInRow(TEST_ARRAY, 0), 0.001);
    }

    @Test
    public void testGetLowestInRowIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(TEST_ARRAY, 0));
    }

    @Test
    public void testGetHighestInColumn() {
        assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInColumn(TEST_ARRAY, 0), 0.001);
        assertEquals(7.0, TwoDimRaggedArrayUtility.getHighestInColumn(TEST_ARRAY, 1), 0.001);
    }

    @Test
    public void testGetHighestInColumnIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(TEST_ARRAY, 0));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(TEST_ARRAY, 1));
    }

    @Test
    public void testGetLowestInColumn() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(TEST_ARRAY, 0), 0.001);
        assertEquals(2.0, TwoDimRaggedArrayUtility.getLowestInColumn(TEST_ARRAY, 1), 0.001);
    }

    @Test
    public void testGetLowestInColumnIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(TEST_ARRAY, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(TEST_ARRAY, 1));
    }

    @Test
    public void testGetHighestInArray() {
        assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInArray(TEST_ARRAY), 0.001);
    }

    @Test
    public void testGetLowestInArray() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(TEST_ARRAY), 0.001);
    }

    @Test
    public void testReadAndWriteFile() throws IOException {
        File tempFile = new File("temp.txt");
        TwoDimRaggedArrayUtility.writeToFile(TEST_ARRAY, tempFile);
        double[][] readData = TwoDimRaggedArrayUtility.readFile(tempFile);
        assertEquals(TEST_ARRAY.length, readData.length);
        for (int i = 0; i < TEST_ARRAY.length; i++) {
            assertArrayEquals(TEST_ARRAY[i], readData[i], 0.001);
        }
        tempFile.delete(); // Clean up
    }
}

