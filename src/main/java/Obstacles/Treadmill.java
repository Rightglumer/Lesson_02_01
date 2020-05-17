package Obstacles;

import Common.Common;
import Competitors.ICompetitor;

import javax.swing.*;

public class Treadmill implements IBarrier {
    final double MAX_DISTANCE = 500.0;
    double distance;
    ImageIcon picture;

    public Treadmill() {
        setNewHardness();
        picture = new ImageIcon(getClass().getClassLoader().getResource("treadmill.png"));
    }

    @Override
    public boolean overcome(ICompetitor competitor) {
        return competitor.run(distance);
    }

    @Override
    public void printInfo() {
        System.out.printf("The type of barrier is treadmill%n");
        System.out.printf("The distance is %f%n", distance);
    }

    @Override
    public ImageIcon getPicture() {
        return picture;
    }

    @Override
    public String getHardness() {
        return "Distance: " + String.valueOf(distance) + " m";
    }

    @Override
    public void setNewHardness() {
        distance = Common.getRandomDouble(MAX_DISTANCE);
    }
}
