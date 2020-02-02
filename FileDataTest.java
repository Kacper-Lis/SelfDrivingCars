package selfdrivingcars;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Gets the data from the input file as int[][]
 */
public class FileDataTest
{

    //Stack of rides
    public static Stack<Ride> rides = new Stack<>();

    public static void main(String[] args) throws FileNotFoundException
    {
        int[][] fileData = getFileData();

        for (int i = 0; i < fileData.length; i++)
        {
            System.out.println(Arrays.toString(fileData[i]));
        }

        //int[] firstLine = getIntArrayFromString(dataList.get(0));
        int rows = fileData[0][0];
        int columns = fileData[0][1];
        int vehicleNum = fileData[0][2];
        int ridesNum = fileData[0][3];
        int rideBonus = fileData[0][4];
        int steps = fileData[0][5];

        /* Stack needs to be sorted first here*/
        
        //Assign stack stack of rides
        for (int i = 1; i < rows; i++)
        {
            int sX = fileData[i][0];
            int sY = fileData[i][1];
            int eX = fileData[i][2];
            int eY = fileData[i][3];
            int s = fileData[i][4];
            int f = fileData[i][5];
            int num = i - 1;
            rides.push(new Ride(sX,sY,eX,eY,s,f,num));
        }

        Vehicle[] vehicles = new Vehicle[vehicleNum];

        //create all vehicles
        for (int i = 0; i < vehicles.length; i++)
        {
            vehicles[i] = new Vehicle();
        }

        //Start the loop
        for (int i = 0; i < steps; i++)
        {
            for (Vehicle veh : vehicles)
            {
                veh.changePos(i);
            }
        }
    }

    private static int[][] getFileData() throws FileNotFoundException
    {
        File file = new File("C:\\Users\\rwake\\OneDrive - Swansea University\\Google hash\\a_example.in");
        Scanner scanner = new Scanner(file);

        // Get data out of file
        ArrayList<int[]> dataList = new ArrayList<>();
        while (scanner.hasNextLine())
        {
            dataList.add(getIntArrayFromString(scanner.nextLine()));
        }

        // Convert ArrayList to 2d array
        int[][] data = new int[dataList.size()][6];
        for (int i = 0; i < data.length; i++)
        {
            data[i] = dataList.get(i);
        }

        return data;
    }

    /*
     * Converts a string of space separated integers to an array of integers
     */
    private static int[] getIntArrayFromString(String inputString)
    {
        String[] tokens = inputString.split(" ");
        int[] numbers = new int[tokens.length];

        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = Integer.parseInt(tokens[i]);
        }
        return numbers;
    }
}
