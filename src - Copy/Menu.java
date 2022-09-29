import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void titulo(String titulo) throws Exception {
        ASCIIArtGenerator artGen = new ASCIIArtGenerator();
        artGen.printTextArt(titulo, 12, ASCIIArtGenerator.ASCIIArtFont.ART_FONT_DIALOG, "+");
    }

    public static void options(String titulo) throws Exception {
        ASCIIArtGenerator artGen = new ASCIIArtGenerator();
        artGen.printTextArt(titulo, 10, ASCIIArtGenerator.ASCIIArtFont.ART_FONT_DIALOG, "+");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean mainMenu() throws Exception {
        Graphics.sky();
        boolean exit = false;
        int opcion;
        //Music.stopMusic();
        //Music.startBgMusic();
        //Music.startStopBgMusic();
        System.out.println(Graphics.ANSI_RED);
        Menu.titulo("                Main Menu");
        System.out.println(Graphics.ANSI_RESET);
        System.out.println(Graphics.ANSI_BLUE);
        System.out.print("                                                       1. Create Party");
        System.out.println("           2. Simulate Battle");
        System.out.println();
        System.out.print("                                                       3. Show Graveyard");
        System.out.println("         4. Export Party");
        System.out.println();
        System.out.println("                                                                         5. Exit");
        System.out.println();
        System.out.print(Graphics.ANSI_RESET);
        Scanner sn = new Scanner(System.in);
        try {
            System.out.println("                           Escribe una de las opciones ");
            Graphics.land();
            opcion = sn.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Has seleccionado la opcion 1");
                    createParty();
                }
                case 2 -> {
                    System.out.println("Has seleccionado la opcion 2");
                    simulateBattle();
                }
                case 3 -> {
                    System.out.println("Has seleccionado la opcion 3");
                    showGraveyard();
                }
                case 4 -> {
                    System.out.println("Has seleccionado la opcion 4");
                    exportParty();
                }
                case 5 -> {
                    Music.stopMusic();
                    exit = true;
                }
                default -> System.out.println("Solo números entre 1 y 5");
            }
        } catch (InputMismatchException e) {
            System.out.println("Debes insertar un número");
            sn.next();
        }
        return exit;
    }

    public static void createParty() throws Exception {
        Graphics.sky();
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        while (!salir) {
            System.out.println(Graphics.ANSI_RED);
            Menu.titulo("                Create Party");
            System.out.println(Graphics.ANSI_RESET);
            System.out.println("1. Manual");
            System.out.println("2. Al azar");
            System.out.println("3. Importar desde CSV");
            System.out.println("4. Volver al menu anterior");
            try {
                System.out.println("Escribe una de las opciones ");
                Graphics.land();
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1 -> {
                        System.out.println("Has seleccionado la opcion 1");
                        Menu.createPartyManual();
                        salir = true;
                    }
                    case 2 -> {
                        System.out.println("Has seleccionado la opcion 2");
                        Menu.createPartyAzar();
                        salir = true;
                    }
                    case 3 -> {
                        System.out.println("Has seleccionado la opcion 3");
                        Menu.createPartyImport();
                        salir = true;
                    }
                    case 4 -> {
                        salir = true;
                    }
                    default -> System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }

    public static void createPartyManual() {
        Graphics.sky();
        System.out.println("Crear party Manual");
        Graphics.land();
    }

    public static void createPartyAzar() {
        Graphics.sky();
        System.out.println("Crear party al Azar");
        Graphics.land();
    }

    public static void createPartyImport() throws Exception {
        //Music.stopMusic();
        //Music.startBattleMusic();
        //Music.startStopBgMusic();
        //Music.startStopBattleMusic();
        Graphics.sky();
        System.out.println(Graphics.ANSI_RED);
        Menu.titulo("                Importar party");
        System.out.println(Graphics.ANSI_RESET);
        //System.out.println("Importar party");
        Scanner sn = new Scanner(System.in);
        String file;
        System.out.println("Escribe el nombre del CSV a importar sin la extensión ");
        Graphics.land();
        file = sn.nextLine();
        file = "c:/java/game/src/" + file + ".csv";
        File f = new File(file);
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Importando party...");
        Thread.sleep(5000);
        //Music.startStopBattleMusic();

    }

    public static void simulateBattle() {
        Graphics.sky();
        //var m = new Sonidos();
        //Music.stopMusic();
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        while (!salir) {

            System.out.println("1. Manual");
            System.out.println("2. Automatico");
            System.out.println("3. Volver al menu anterior");
            try {
                System.out.println("Escribe una de las opciones");
                Graphics.land();
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1 -> {
                        System.out.println("Has seleccionado la opcion 1");
                        Menu.simulateBattleManual();
                        salir = true;
                    }
                    case 2 -> {
                        System.out.println("Has seleccionado la opcion 2");
                        Menu.simulateBattleAutomatico();
                        salir = true;
                    }
                    case 3 -> {
                        clearScreen();
                        salir = true;
                    }
                    default -> System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }

    private static void simulateBattleAutomatico() {
    }

    private static void simulateBattleManual() {
    }

    public static void showGraveyard() {
    }

    public static void exportParty() throws Exception {
        //Music.stopMusic();
        //Music.startStopBattleMusic();
        Graphics.sky();
        System.out.println(Graphics.ANSI_RED);
        Menu.titulo("                Export party");
        System.out.println(Graphics.ANSI_RESET);
        Scanner sn = new Scanner(System.in);
        String file;
        System.out.println("Escribe el nombre del CSV a exportar sin la extensión ");
        Graphics.land();
        file = sn.nextLine();
        file = "c:/java/game/src/" + file + ".csv";
        try {
            File myObj = new File(file);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Importando party...");
        Thread.sleep(5000);
        //Music.startStopBattleMusic();
    }


}

