import java.awt.*;
import java.awt.Container;

public class Music {
    static Thread t = new Thread(() -> Sound.playSound("c:/java/game/src/main.wav"), "PlaySound");
    static Thread t2 = new Thread(() -> Sound.playSound("c:/java/game/src/battle.wav"), "PlaySound2");

    public static void startBgMusic() {
        t.start();
    }
    public static void pauseBgMusic() {
        t.suspend();
    }
    public static void resumeBgMusic() {
        t.resume();
    }
    public static void startBattleMusic() {
        t2.start();
    }
    public static void pauseBattleMusic() {
        t2.suspend();
    }
    public static void resumeBattleMusic() {
        t2.resume();
    }
    public static void stopMusic() {
        if (t.isAlive()) t.stop();
        if (t2.isAlive()) t2.stop();
    }
}

