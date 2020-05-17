package Competitors;

import Common.Common;

import javax.swing.*;

public class Cat implements ICompetitor {
    final double MAX_ALTITUDE = 5.0;
    final double MAX_DISTANCE = 50.0;

    double altitude;
    double distance;
    String moniker;
    boolean onDistance;
    ImageIcon picture;

    public Cat() {
        moniker = Common.catMoniker[Common.getRandomInt(Common.catMoniker.length)];
        onDistance = true;
        picture = new ImageIcon(getClass().getClassLoader().getResource("cat.png"));
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
        System.out.printf("The cat moniker is %s%n", moniker);
        System.out.printf("Max altitude is %f%n", altitude);
        System.out.printf("Max distance is %f%n", distance);
    }

    @Override
    public ImageIcon getPicture() {
        return picture;
    }

    @Override
    public String getName() {
        return moniker;
    }

    @Override
    public void setNewAbility() {
        altitude = Common.getRandomDouble(MAX_ALTITUDE);
        distance = Common.getRandomDouble(MAX_DISTANCE);
    }
}
