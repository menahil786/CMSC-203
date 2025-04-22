/*
 * Class: CMSC203 
 * Instructor: Prof Grinberg
 * Description: Provides utility methods to read, write, and analyze ragged two-dimensional arrays of doubles.
 * Due: 04/21/2025
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: _Menahil Fatima_________
*/

import java.io.*;
import java.util.*;

public class TwoDimRaggedArrayUtility {

    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList<double[]> list = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                String[] tokens = line.split(" ");
                double[] row = new double[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    row[i] = Double.parseDouble(tokens[i]);
                }
                list.add(row);
            }
        }
        scanner.close();
        return list.toArray(new double[list.size()][]);
    }

    public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        for (double[] row : data) {
            for (int i = 0; i < row.length; i++) {
                writer.print(row[i]);
                if (i < row.length - 1) writer.print(" ");
            }
            writer.println();
        }
        writer.close();
    }

    public static double getTotal(double[][] data) {
        double total = 0;
        for (double[] row : data) {
            for (double value : row) {
                total += value;
            }
        }
        return total;
    }

    public static double getAverage(double[][] data) {
        int count = 0;
        double total = 0;
        for (double[] row : data) {
            for (double value : row) {
                total += value;
                count++;
            }
        }
        return count == 0 ? 0 : total / count;
    }

    public static double getRowTotal(double[][] data, int row) {
        double total = 0;
        for (double value : data[row]) {
            total += value;
        }
        return total;
    }

    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        for (double[] row : data) {
            if (col < row.length) {
                total += row[col];
            }
        }
        return total;
    }

    public static double getHighestInRow(double[][] data, int row) {
        double max = data[row][0];
        for (double value : data[row]) {
            if (value > max) max = value;
        }
        return max;
    }

    public static int getHighestInRowIndex(double[][] data, int row) {
        int maxIndex = 0;
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] > data[row][maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static double getLowestInRow(double[][] data, int row) {
        double min = data[row][0];
        for (double value : data[row]) {
            if (value < min) min = value;
        }
        return min;
    }

    public static int getLowestInRowIndex(double[][] data, int row) {
        int minIndex = 0;
        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] < data[row][minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static double getHighestInColumn(double[][] data, int col) {
        boolean found = false;
        double max = 0;
        for (double[] row : data) {
            if (col < row.length) {
                if (!found) {
                    max = row[col];
                    found = true;
                } else if (row[col] > max) {
                    max = row[col];
                }
            }
        }
        return max;
    }

    public static int getHighestInColumnIndex(double[][] data, int col) {
        int index = -1;
        boolean found = false;
        double max = 0;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                if (!found) {
                    max = data[i][col];
                    index = i;
                    found = true;
                } else if (data[i][col] > max) {
                    max = data[i][col];
                    index = i;
                }
            }
        }
        return index;
    }

    public static double getLowestInColumn(double[][] data, int col) {
        boolean found = false;
        double min = 0;
        for (double[] row : data) {
            if (col < row.length) {
                if (!found) {
                    min = row[col];
                    found = true;
                } else if (row[col] < min) {
                    min = row[col];
                }
            }
        }
        return min;
    }

    public static int getLowestInColumnIndex(double[][] data, int col) {
        int index = -1;
        boolean found = false;
        double min = 0;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                if (!found) {
                    min = data[i][col];
                    index = i;
                    found = true;
                } else if (data[i][col] < min) {
                    min = data[i][col];
                    index = i;
                }
            }
        }
        return index;
    }

    public static double getHighestInArray(double[][] data) {
        double max = data[0][0];
        for (double[] row : data) {
            for (double value : row) {
                if (value > max) max = value;
            }
        }
        return max;
    }

    public static double getLowestInArray(double[][] data) {
        double min = data[0][0];
        for (double[] row : data) {
            for (double value : row) {
                if (value < min) min = value;
            }
        }
        return min;
    }

}
