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
    int targetX;
    int targetY;
    Ride currentRide = null;
    ArrayList<Ride> ridez;

    public Vehicle()
    {
        x = 0;
        y = 0;
        ridez = new ArrayList<>();
    }

    //Returns array with numbers of the rides the car has taken for output
    public int[] ridesNum()
    {
        int[] ridesInt = new int[ridez.size()];
        for (int i = 0; i < ridesInt.length; i++)
        {
            ridesInt[i] = ridez.get(i).getRideNum();
        }
        return ridesInt;
    }

    public void changePos(int step)
    {
        assignRide(step);
        if (currentRide != null)
        {
            if (earlyStart(step))
            {
                targetX = currentRide.endPosX;
                targetY = currentRide.endPosY;
            }

            if (x > targetX)
            {
                x--;
            }
            else if (x < targetX)
            {
                x++;
            }
            if (y > targetY)
            {
                y--;
            }
            else if (y < targetY)
            {
                y++;
            }
            if (x == currentRide.endPosX && y == currentRide.endPosY)
            {
                currentRide = null;
            }
        }
    }

    private void assignRide(int step)
    {
        if (currentRide == null && !FileDataTest.rides.empty())
        {
            currentRide = FileDataTest.rides.pop();
            ridez.add(currentRide);
            targetX = currentRide.startPosX;
            targetY = currentRide.startPosY;
            if (Math.abs(x - targetX) + Math.abs(currentRide.startPosX - currentRide.endPosX)
                    + Math.abs(y - targetY) + Math.abs(currentRide.startPosY - currentRide.endPosY) > currentRide.finish - step)
            {
                currentRide = null;
                assignRide(step);
            }
        }
    }

    private boolean earlyStart(int steps)
    {
        boolean start = false;
        if (currentRide.start >= steps)
        {
            start = true;
        }
        return start;
    }

    //Formats for output
    public String getList()
    {
        int count = 0;
        for (Ride ride : ridez)
        {
            count++;
        }
        String ret = "" + count;
        for (int ride : ridesNum())
        {
            ret += " " + ride;
        }
        return ret;
    }
}
