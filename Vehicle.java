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
    ArrayList<Ride> rides;
    boolean canStart;

    static int count = 0;

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
            if (currentRide.start >= step)
            {
                targetX = currentRide.endPosX;
                targetY = currentRide.endPosY;
            }
            if (x == targetX && y == targetY)
            {
                currentRide = null;
                changePos(step);
            }
            else
            {

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
            }

        }

    }

    /*
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
                ridez.remove(currentRide);
                currentRide = null;
                assignRide(step);
            }
        }
    }
     */
    private void assignRide(int step)
    {
        if (currentRide == null && !FileDataTest.ridesArray.isEmpty())
        {
            /*
            count++;
            System.out.println(count);
             */
 /*
            rides = new ArrayList<>();
            for (Ride ride : FileDataTest.ridesArray)
            {
                rides.add(ride);
            }
            
            Collections.sort(rides, new Comparator<Ride>()
            {
                @Override
                public int compare(Ride r1, Ride r2)
                {
                    double dis1 = Math.sqrt(Math.pow(r1.startPosX - x, 2) + Math.pow(r1.startPosY - y, 2));
                    double dis2 = Math.sqrt(Math.pow(r2.startPosX - x, 2) + Math.pow(r2.startPosY - y, 2));
                    if (dis1 > dis2)
                    {
                        return 1;
                    }
                    if (dis2 > dis1)
                    {
                        return -1;
                    }
                    return 0;
                }
            });
             */
            currentRide = FileDataTest.ridesArray.get(0);
            double dis = Math.sqrt(Math.pow(x - currentRide.startPosX, 2) + Math.pow(y - currentRide.startPosY, 2));
            double temp = dis;
            if (FileDataTest.ridesArray.size() > 100)
            {
                for (int i = 0; i < 100; i++)
                {
                    Ride ride = FileDataTest.ridesArray.get(i);
                    dis = Math.sqrt(Math.pow(x - ride.startPosX, 2) + Math.pow(y - ride.startPosY, 2));
                    if (Math.abs(x - ride.startPosX) + Math.abs(ride.startPosX - ride.endPosX)
                            + Math.abs(y - ride.startPosY) + Math.abs(ride.startPosY - ride.endPosY) < ride.finish - step && dis < temp)
                    {
                        currentRide = ride;
                        temp = dis;
                    }
                }
            }
            else
            {
                for (Ride ride : FileDataTest.ridesArray)
                {
                    dis = Math.sqrt(Math.pow(x - ride.startPosX, 2) + Math.pow(y - ride.startPosY, 2));
                    if (Math.abs(x - ride.startPosX) + Math.abs(ride.startPosX - ride.endPosX)
                            + Math.abs(y - ride.startPosY) + Math.abs(ride.startPosY - ride.endPosY) < ride.finish - step && dis < temp)
                    {
                        currentRide = ride;
                        temp = dis;
                    }
                }
            }
            /*
            if (Math.abs(x - targetX) + Math.abs(currentRide.startPosX - currentRide.endPosX)
                    + Math.abs(y - targetY) + Math.abs(currentRide.startPosY - currentRide.endPosY) > currentRide.finish - step)
            {
                ridez.remove(currentRide);
                currentRide = null;
                assignRide(step);
            }
             */
            ridez.add(currentRide);
            FileDataTest.ridesArray.remove(currentRide);

        }
    }

    private boolean earlyStart(int steps)
    {
        return currentRide.start >= steps;
    }

    //Formats for output
    public String getList()
    {
        int c = 0;
        for (Ride ride : ridez)
        {
            c++;
        }
        String ret = "" + c;
        for (int ride : ridesNum())
        {
            ret += " " + ride;
        }
        return ret;
    }
}
