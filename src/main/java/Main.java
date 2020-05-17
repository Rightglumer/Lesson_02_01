import Common.AreaWindow;
import Common.Common;
import Competitors.Cat;
import Competitors.ICompetitor;
import Competitors.Man;
import Competitors.Robot;
import Obstacles.IBarrier;
import Obstacles.Treadmill;
import Obstacles.Wall;

public class Main {
    final static int MAX_COMPETITORS = 5;
    final static int MAX_BARRIERS = 5;

    enum DayOfWeek {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

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

        // ENUM
        /*
        int workingHours = getWorkingHours(DayOfWeek.WEDNESDAY);
        if (workingHours == 0) {
            System.out.println("It's weekend");
        } else {
            System.out.printf("There are only %d working hours left on this week", workingHours);
        }
        */
    }

    public static int getWorkingHours(DayOfWeek day) {
        return (day.ordinal() < 5) ? (5 - day.ordinal()) * 8 : 0;
    }
}
