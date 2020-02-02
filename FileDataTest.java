package selfdrivingcars;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Gets the data from the input file as int[][]
 */
public class FileDataTest {

    public static void main(String[] args) throws FileNotFoundException {
        int[][] fileData = getFileData();

        for (int i = 0; i < fileData.length; i++) {
            System.out.println(Arrays.toString(fileData[i]));
        }

        //int[] firstLine = getIntArrayFromString(dataList.get(0));

        int rows = fileData[0][0];
        int columns = fileData[0][1];
        int vehicles = fileData[0][2];
        int rides = fileData[0][3];
        int rideBonus = fileData[0][4];
        int steps = fileData[0][5];
    }

    private static int[][] getFileData() throws FileNotFoundException {
        File file = new File("C:\\Users\\rwake\\OneDrive - Swansea University\\Google hash\\a_example.in");
        Scanner scanner = new Scanner(file);

        // Get data out of file
        ArrayList<int[]> dataList = new ArrayList<>();
        while(scanner.hasNextLine()) {
            dataList.add(getIntArrayFromString(scanner.nextLine()));
        }

        // Convert ArrayList to 2d array
        int[][] data = new int[dataList.size()][6];
        for (int i = 0; i < data.length; i++) {
            data[i] = dataList.get(i);
        }

        return data;
    }

    /*
     * Converts a string of space separated integers to an array of integers
     */
    private static int[] getIntArrayFromString(String inputString) {
        String[] tokens = inputString.split(" ");
        int[] numbers = new int[tokens.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);
        }
        return numbers;
    }
}