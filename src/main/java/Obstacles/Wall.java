package Obstacles;

import Common.Common;
import Competitors.ICompetitor;

import javax.swing.*;

public class Wall implements IBarrier {
    final double MAX_HEIGHT = 10.0;
    double height;
    ImageIcon picture;

    public Wall() {
        setNewHardness();
        picture = new ImageIcon(getClass().getClassLoader().getResource("wall.png"));
    }

    @Override
    public boolean overcome(ICompetitor competitor) {
        return competitor.jump(height);
    }

    @Override
    public void printInfo() {
        System.out.printf("The type of barrier is wall%n");
        System.out.printf("The height is %f%n", height);
    }

    @Override
    public ImageIcon getPicture() {
        return picture;
    }

    @Override
    public String getHardness() {
        return "Height: " + String.valueOf(height) + " m";
    }

    @Override
    public void setNewHardness() {
        height = Common.getRandomDouble(MAX_HEIGHT);
    }
}
