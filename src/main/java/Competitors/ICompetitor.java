package Competitors;

import javax.swing.*;

public interface ICompetitor {
    boolean jump(double altitude);
    boolean run(double distance);
    void setReady();
    boolean isOnDistance();
    void printInfo();
    void setNewAbility();
    ImageIcon getPicture();
    String getName();
}
