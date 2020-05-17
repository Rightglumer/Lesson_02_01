package Competitors;

import Common.Common;

import javax.swing.*;

public class Man implements ICompetitor {
    final double MAX_ALTITUDE = 10.0;
    final double MAX_DISTANCE = 500.0;

    double altitude;
    double distance;
    String name;
    boolean onDistance;
    ImageIcon picture;

    public Man() {
        name = Common.manName[Common.getRandomInt(Common.manName.length)];
        onDistance = true;
        picture = new ImageIcon(getClass().getClassLoader().getResource("man.png"));
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
        System.out.printf("The man name is %s%n", name);
        System.out.printf("Max altitude is %f%n", altitude);
        System.out.printf("Max distance is %f%n", distance);
    }

    @Override
    public ImageIcon getPicture() {
        return picture;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setNewAbility() {
        altitude = Common.getRandomDouble(MAX_ALTITUDE);
        distance = Common.getRandomDouble(MAX_DISTANCE);
    }
}
