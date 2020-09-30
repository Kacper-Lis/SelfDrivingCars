/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfdrivingcars;

/**
 *
 * @author poczt
 */
public class Ride implements Comparable<Ride>
{

    int startPosX;
    int startPosY;
    int endPosX;
    int endPosY;
    int start;
    int finish;
    int rideNum;

    public Ride(int startPosX, int startPosY,
            int endPosX, int endPosY, int start, int finish, int rideNum)
    {
        this.startPosX = startPosX;
        this.startPosY = startPosY;
        this.endPosX = endPosX;
        this.endPosY = endPosY;
        this.start = start;
        this.finish = finish;
        this.rideNum = rideNum;
    }

    public int getRideNum()
    {
        return rideNum;
    }

    public double distane()
    {
        return Math.sqrt(Math.pow(startPosX - endPosX, 2) + Math.pow(startPosY - endPosY, 2));
    }
    /*
    @Override
    public int compareTo(Ride ride)
    {

        double x1 = ride.startPosX;
        double y1 = ride.startPosY;
        double x2 = ride.endPosX;
        double y2 = ride.endPosY;
        double dis1 = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double dis2 = Math.sqrt(Math.pow(startPosX - endPosX, 2) + Math.pow(startPosY - endPosY, 2));

        //double dis1 = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
        //
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
    */
    
    @Override
    public int compareTo(Ride ride)
    {
        return this.start - ride.start;
    }
    
   
    public String sortF()
    {
        return "" + Math.sqrt(Math.pow(startPosX - endPosX, 2) + Math.pow(startPosY - endPosY, 2));
    }
}
