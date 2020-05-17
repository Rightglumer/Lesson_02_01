package Competitors;

import Common.Common;

import javax.swing.*;

public class Robot implements ICompetitor {
    final double MAX_ALTITUDE = 20.0;
    final double MAX_DISTANCE = 1000.0;

    double altitude;
    double distance;
    String model;
    boolean onDistance;
    ImageIcon picture;

    public Robot() {
        model = Common.robotModel[Common.getRandomInt(Common.robotModel.length)];
        onDistance = true;
        picture = new ImageIcon(getClass().getClassLoader().getResource("robot.png"));
    }

    @Override
    public boolean jump(double altitude) {
        onDistance = altitude <= this.altitude;
        return onDistance;
    }

    @Override
    public boolean run(double distance) {
        onDistance = distance <= this.distance;
        return onDistance;
    }

    @Override
    public void setReady() {
        onDistance = true;
        setNewAbility();
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void printInfo() {
        System.out.printf("The robot model is %s%n", model);
        System.out.printf("Max altitude is %f%n", altitude);
        System.out.printf("Max distance is %f%n", distance);
    }

    @Override
    public ImageIcon getPicture() {
        return picture;
    }

    @Override
    public String getName() {
        return model;
    }

    @Override
    public void setNewAbility() {
        altitude = Common.getRandomDouble(MAX_ALTITUDE);
        distance = Common.getRandomDouble(MAX_DISTANCE);
    }
}
