import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Menu {

    public static void titulo(String titulo) throws Exception {
        ASCIIArtGenerator artGen = new ASCIIArtGenerator();
        artGen.printTextArt(titulo, 10, ASCIIArtGenerator.ASCIIArtFont.ART_FONT_DIALOG,"+");
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
        boolean exit = false;
        int opcion;
        clearScreen();
        Music.startMusic();
        Graphics.sky();
        System.out.println(Graphics.ANSI_RED);
        Menu.titulo("         Main Menu");
        System.out.println(Graphics.ANSI_RESET);
        System.out.print("                           1. Create Party");
        System.out.println("           2. Simulate Battle");
        System.out.println();
        System.out.print("                           3. Show Graveyard");
        System.out.println("         4. Export Party");
        System.out.println();
        System.out.println("                                             5. Exit");
        System.out.println();
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
        clearScreen();
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        while (!salir) {
            System.out.println(Graphics.ANSI_RED);
            titulo("         Create Party");
            System.out.println(Graphics.ANSI_RESET);
            System.out.println("1. Manual");
            System.out.println("2. Al azar");
            System.out.println("3. Importar desde CSV");
            System.out.println("4. Volver al menu anterior");
            try {
                System.out.print("Escribe una de las opciones ");
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
                        clearScreen();
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
        clearScreen();
        System.out.println("Crear party Manual");
    }
    public static void createPartyAzar() {
        clearScreen();
        System.out.println("Crear party al Azar");
    }
    public static void createPartyImport() {
        clearScreen();
        System.out.println("Importar party desde archivo");
    }


    public static void simulateBattle() {
        clearScreen();
        //var m = new Sonidos();
        Music.stopMusic();
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        while (!salir) {

            System.out.println("1. Manual");
            System.out.println("2. Automatico");
            System.out.println("3. Volver al menu anterior");
            try {
                System.out.println("Escribe una de las opciones");
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

    public static void exportParty() {
    }
}

