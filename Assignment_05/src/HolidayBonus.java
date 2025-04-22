/*
 * Class: CMSC203 
 * Instructor: Prof Grinberg
 * Description: The HolidayBonus class calculates individual and total holiday 
 * bonuses for stores based on their sales performance in each category.
 * Due: 04/21/2025
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: _Menahil Fatima_________
*/

public class HolidayBonus {

    // Constants for bonus amounts
    private static final double HIGH_BONUS = 5000.0;
    private static final double LOW_BONUS = 1000.0;
    private static final double OTHER_BONUS = 2000.0;

    /**
     * Calculates the holiday bonus for each store.
     * 
     * @param data the two-dimensional ragged array of doubles representing sales
     * @return an array of doubles representing bonuses for each store
     */
    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];

        int maxColumns = 0;
        for (double[] row : data) {
            if (row.length > maxColumns) {
                maxColumns = row.length;
            }
        }

        for (int col = 0; col < maxColumns; col++) {
            int highestIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
            int lowestIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);

            for (int row = 0; row < data.length; row++) {
                if (col < data[row].length && data[row][col] > 0) {
                    if (row == highestIndex && row == lowestIndex) {
                        bonuses[row] += HIGH_BONUS; // If only one store in column
                    } else if (row == highestIndex) {
                        bonuses[row] += HIGH_BONUS;
                    } else if (row == lowestIndex) {
                        bonuses[row] += LOW_BONUS;
                    } else {
                        bonuses[row] += OTHER_BONUS;
                    }
                }
            }
        }

        return bonuses;
    }

    /**
     * Calculates the total holiday bonuses for all stores.
     * 
     * @param data the two-dimensional ragged array of doubles representing sales
     * @return total of all holiday bonuses
     */
    public static double calculateTotalHolidayBonus(double[][] data) {
        double[] bonuses = calculateHolidayBonus(data);
        double total = 0;
        for (double bonus : bonuses) {
            total += bonus;
        }
        return total;
    }
}