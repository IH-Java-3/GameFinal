public class Main {
    public static void main(String[] args) throws Exception {
        boolean exit = false;
        Music.startMusic();
        while (!exit) {
                exit = Menu.mainMenu();
            }
        Music.stopMusic();
        }
}