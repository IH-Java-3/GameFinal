import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void title(String title) throws Exception {
        ASCIIArtGenerator artGen = new ASCIIArtGenerator();
        artGen.printTextArt(title, 12, ASCIIArtGenerator.ASCIIArtFont.ART_FONT_DIALOG, "+");
    }

    public static void winner(String title) throws Exception {
        ASCIIArtGenerator artGen = new ASCIIArtGenerator();
        artGen.printTextArt(title, 10, ASCIIArtGenerator.ASCIIArtFont.ART_FONT_DIALOG, "*");
    }

    public static void options(String title) throws Exception {
        ASCIIArtGenerator artGen = new ASCIIArtGenerator();
        artGen.printTextArt(title, 10, ASCIIArtGenerator.ASCIIArtFont.ART_FONT_DIALOG, "+");
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
        Menu.title("                Main Menu");
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
            Graphics.land();
            System.out.print(Graphics.ANSI_CYAN);
            System.out.print("                           Escribe una de las opciones: ");
            System.out.print(Graphics.ANSI_RESET);
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
                    Party.showGraveyard();
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
            Menu.title("                Create Party");
            System.out.println(Graphics.ANSI_RESET);
            System.out.println("1. Manual");
            System.out.println("2. Al azar");
            System.out.println("3. Importar desde CSV");
            System.out.println("4. Volver al menu anterior");
            try {
                Graphics.land();
                System.out.print(Graphics.ANSI_CYAN);
                System.out.print("                           Escribe una de las opciones: ");
                System.out.print(Graphics.ANSI_RESET);
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1 -> {
                        System.out.println("Has seleccionado la opcion 1");
                        Menu.createPartyManual();
                        salir = true;
                    }
                    case 2 -> {
                        System.out.println("Has seleccionado la opcion 2");
                        Menu.createPartyRandom();
                        salir = true;
                    }
                    case 3 -> {
                        System.out.println("Has seleccionado la opcion 3");
                        Menu.createPartyImport();
                        salir = true;
                    }
                    case 4 -> salir = true;
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
        if(Party.checkEmptyParty(Party.party)) {
            Party.createCharacter();
        }
        Graphics.land();
    }

    public static void createPartyRandom() {
        //Graphics.sky();
        System.out.println("Crear party al Azar");
        if(Party.checkEmptyParty(Party.party)) {
            Party.createRandomParty();
        }
        //Graphics.land();
    }

    public static void createPartyImport() throws Exception {
        //Music.stopMusic();
        //Music.startBattleMusic();
        //Music.startStopBgMusic();
        //Music.startStopBattleMusic();

        Graphics.sky();
        System.out.println(Graphics.ANSI_RED);
        Menu.title("                Importar party");
        System.out.println(Graphics.ANSI_RESET);
        //System.out.println("Importar party");
        Graphics.land();
        Party.importParty();
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
                Graphics.land();
                System.out.print("                           Escribe una de las opciones: ");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1 -> {
                        System.out.println("Has seleccionado la opcion 1");
                        Party.battleManual();
                        System.out.println("                           Presione Enter para continuar...");
                        try { System.in.read();
                        } catch(Exception e) {}
                        salir = true;
                    }
                    case 2 -> {
                        System.out.println("Has seleccionado la opcion 2");
                        Party.battleRandom();
                        salir = true;
                    }
                    case 3 -> salir = true;
                    default -> System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void exportParty() throws Exception {
        //Music.stopMusic();
        //Music.startStopBattleMusic();
        Graphics.sky();
        System.out.println(Graphics.ANSI_RED);
        Menu.title("                Exportar party");
        System.out.println(Graphics.ANSI_RESET);
        Scanner sn = new Scanner(System.in);
        String file;
        Graphics.land();
        System.out.print("                           Escribe el nombre del CSV a exportar sin la extensión: ");
        file = sn.nextLine();
        file = "c:/java/game/src/" + file + ".csv";
        try {
            File myObj = new File(file);
            if (myObj.createNewFile()) {
                System.out.println("Archivo creado: " + myObj.getName());
                // 0 id_party, 2type(Warrior 1 Wizard 2), 3name, 4hp, 5isalive, 6att1, 7att2
                FileWriter myWriter = new FileWriter(file);
                myWriter.write("0 id_party, 2type(Warrior 1 Wizard 2), 3name, 4hp, 5isalive, 6att1, 7att2\n");
                for (Character p : Party.party) {
                    myWriter.write(p.getIdParty() + ",");
                    myWriter.write(((p instanceof Warrior) ? 1 : 2)+ ",");
                    myWriter.write(p.getName() + ",");
                    myWriter.write(p.getHp() + ",");
                    myWriter.write(((p.isAlive) ? 1 : 0) + ",");
                    myWriter.write(((p instanceof Warrior) ? ((Warrior) p).getStamina() : ((Wizard) p).getMana())+ ",");
                    myWriter.write(((p instanceof Warrior) ? ((Warrior) p).getStrength() : ((Wizard) p).getIntelligence())+ "\n");
                }
                myWriter.close();

            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Exportando party...");
        Thread.sleep(1000);
        //Music.startStopBattleMusic();
    }

}

