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
public class Ride
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
}
