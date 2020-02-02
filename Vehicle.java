/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfdrivingcars;

import java.util.ArrayList;

/**
 *
 * @author poczt
 */
public class Vehicle
{

    int[][] map = new int[SelfDrivingCars.row][SelfDrivingCars.column];
    int x;
    int y;
    ArrayList<Ride> rides;

    public Vehicle()
    {
        x = 0;
        y = 0;
        rides = new ArrayList<>();
    }

    public int[] ridesNum()
    {
        int[] ridesInt = new int[rides.size()];
        for (int i = 0; i < ridesInt.length; i++)
        {
            ridesInt[i] = rides.get(i).getRideNum();
        }
        return ridesInt;
    }

    public void changePos(int x, int y)
    {

    }

}
