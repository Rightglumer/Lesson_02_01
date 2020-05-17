package Common;

import java.util.Random;

import static java.lang.Math.round;

public class Common {

    public static String[] manName = {"Seilur Beste", "Zeshum Rennam", "Rubredd Deadshadow", "Nurvom Pridekeeper",
                                      "Glesin Rin", "Som Dudursk", "Grunveth Duskstrike", "Mon Glorygazer",
                                      "Bonuhvoh Davrajuk", "Rerin Huenkhihd", "Kedaldoulm Gralzyavzyavi", "Jaudjis Nivzadu",
                                      "Wiy Qa", "Mup Qa", "Ruscuembiz Hobrizer", "Homen Paldunu"};
    public static String[] robotModel = {"Humanoid Bot", "Cybernated Probe",
                                         "General Safety Emulator", "Ultimate Bodyguard Juggernaut", "Spudnik",
                                         "Ratchet", "Crowby", "Combot", "Emxtron", "Ezd"};
    public static String[] catMoniker = {"Hiro", "Shika", "Masaaki", "Leiko", "Aki", "Foxu", "Zonys", "Niaushraush",
                                         "Shassar", "Cikrass"};

    public static double getRandomDouble(double maxValue) {
        return round(new Random().nextDouble() * maxValue * 100.0) / 100.0;
    }

    public static int getRandomInt(int maxValue) {
        return new Random().nextInt(maxValue);
    }
}
