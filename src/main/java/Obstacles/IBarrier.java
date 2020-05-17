package Obstacles;

import Competitors.ICompetitor;

import javax.swing.*;

public interface IBarrier {
    boolean overcome(ICompetitor competitor);
    void printInfo();
    void setNewHardness();
    ImageIcon getPicture();
    String getHardness();
}
