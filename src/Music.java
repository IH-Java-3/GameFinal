public class Music {
    static Thread t = new Thread(() -> Sound.playSound("c:/java/game/src/main.wav"), "PlaySound");

    public static void startMusic() {
        t.start();
    }

    public static void stopMusic() {
        if (t.isAlive()) t.stop();
    }
}

