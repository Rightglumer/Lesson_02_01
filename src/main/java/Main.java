import Common.*;
import Competitors.*;
import Obstacles.*;

import javax.swing.*;
import java.awt.image.ImageConsumer;
import java.io.IOException;

public class Main {
    final static int MAX_COMPETITORS = 5;
    final static int MAX_BARRIERS = 5;

    public static void main(String[] args)  {
        ICompetitor[] competitors = new ICompetitor[Common.getRandomInt(MAX_COMPETITORS) + 2];
        IBarrier[] barriers = new IBarrier[Common.getRandomInt(MAX_BARRIERS) + 2];

        for (int i = 0; i < competitors.length; i++) {
            int competitorType = Common.getRandomInt(3);
            switch (competitorType) {
                case (0):
                    competitors[i] = new Man();
                    break;
                case (1):
                    competitors[i] = new Robot();
                    break;
                case (2):
                    competitors[i] = new Cat();
                    break;
            }
        }

        for (int i = 0; i < barriers.length; i++) {
            int barrierType = Common.getRandomInt(2);
            switch (barrierType) {
                case (0):
                    barriers[i] = new Wall();
                    break;
                case (1):
                    barriers[i] = new Treadmill();
                    break;
            }
        }
        AreaWindow window = new AreaWindow(competitors, barriers);
/*

        for (int i = 0; i < competitors.length; i++) {
            competitors[i].printInfo();
        }

        for (int i = 0; i < barriers.length; i++) {
            barriers[i].printInfo();
        }

        for (IBarrier barrier : barriers) {
            for (ICompetitor competitor : competitors) {
                if (competitor.isOnDistance()) {
                    barrier.overcome(competitor);
                }
            }
        }
        */
    }
}
