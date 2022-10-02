import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Boolean.parseBoolean;

public class Party {
    public static List<Character> party = new ArrayList<>();
    public static List<Character> party0 = new ArrayList<>();
    public static List<Character> party1 = new ArrayList<>();
    public static List<Character> graveyard = new ArrayList<>();

    public static boolean checkEmptyParty(List<Character> party) {
        boolean bool;
        bool = party.isEmpty();
        System.out.println("la party está vacía " + bool);
        return bool;
    }

    private static String getRandomName() {
        String name = Character.namesList.get(new Random().nextInt(0, Character.namesList.size()));
        boolean exists = false;
        for (Character p : party0) {
            if (p.getName().equals(name)) {
                exists = true;
                break;
            }
        }
        if (exists) name += " Jr";
        return name;
    }

    private static void createRandomCharacter(int idParty) {
        if (idParty == 0) {
            for (int i = 0; i < 5; i++) {
                if (new Random().nextInt(1, 3) == 1) {
                    party0.add(new Warrior(getRandomName(), idParty));
                } else {
                    party0.add(new Wizard(getRandomName(), idParty));
                }
            }
        } else if (idParty == 1) {
            for (int i = 0; i < 5; i++) {
                if (new Random().nextInt(1, 3) == 1) {
                    party1.add(new Warrior(getRandomName(), idParty));
                } else {
                    party1.add(new Wizard(getRandomName(), idParty));
                }
            }
        }
    }

    public static void createCharacter() {
        createCharacterManual(0);
        createCharacterManual(0);
    }

    public static void createCharacterManual(int idParty) {
        String opcion;
        String opcion2;
        System.out.println("Estamos creando party " + idParty);
        for (int j = 0; j < 5; j++) {
            Scanner sn = new Scanner(System.in);
            System.out.print("Introduzca el tipo del personaje " + j + " WARRIOR o WIZARD : ");
            opcion = sn.nextLine();
            switch (opcion.toUpperCase()) {
                case "WARRIOR" -> {
                    System.out.print("Introduzca el nombre del personaje " + j + ": ");
                    opcion2 = sn.nextLine();
                    party.add(new Warrior(opcion2, idParty));
                }
                case "WIZARD" -> {
                    System.out.print("Introduzca el nombre del personaje " + j + ": ");
                    opcion2 = sn.nextLine();
                    party.add(new Wizard(opcion2, idParty));
                }
                default -> {
                    System.out.println("Solo introduzca WARRIOR ó WIZARD");
                    j--;
                }
            }
        }
    }

    public static void createRandomParty() {
        //party = new ArrayList<>();
        party0 = new ArrayList<>();
        party1 = new ArrayList<>();
        createRandomCharacter(0);
        createRandomCharacter(1);
    }

    private static boolean hasMembersAlive(int idParty) {
        boolean alive = false;
        if (idParty == 0) {
            for (Character p : party0) {
                if (p.getIdParty() == idParty && p.getHp() > 0) {
                    alive = true;
                    return alive;
                }
            }
        } else if (idParty == 1) {
            for (Character p : party1) {
                if (p.getIdParty() == idParty && p.getHp() > 0) {
                    alive = true;
                    return alive;
                }
            }
        }
        return alive;
    }

    public static void battleRandom() throws Exception {
        Character player1, player2;
        //int damage1 = 0, damage2 = 0;
        while (hasMembersAlive(0) && hasMembersAlive(1)) {
            player1 = chooseCharacterRandom(0);
            player2 = chooseCharacterRandom(1);
            Battles.battle(player1, player2);
        }
        if (hasMembersAlive(0)) {
            //System.out.println("\nParty 1 ha ganado la batalla\n");
            System.out.println(Graphics.ANSI_BLUE);
            Menu.winner("Party 1 ha ganado la batalla");
            System.out.println(Graphics.ANSI_RESET);
        } else {
            System.out.println(Graphics.ANSI_GREEN);
            Menu.winner("Party 2 ha ganado la batalla");
            System.out.println(Graphics.ANSI_RESET);
            //System.out.println("\nParty 2 ha ganado la batalla\n");
        }
    }

    public static void battleManual() throws Exception {
        //int damage1 = 0, damage2 = 0;
        while (hasMembersAlive(0) && hasMembersAlive(1)) {
            Character player1 = chooseCharacterManual(0);
            Character player2 = chooseCharacterManual(1);
            Battles.battle(player1, player2);
        }
        if (hasMembersAlive(0)) {
            System.out.println(Graphics.ANSI_BLUE);
            Menu.winner("Party 1 ha ganado la batalla");
            System.out.println(Graphics.ANSI_RESET);
        } else {
            System.out.println(Graphics.ANSI_GREEN);
            Menu.winner("Party 2 ha ganado la batalla");
            System.out.println(Graphics.ANSI_RESET);
        }
    }

    private static Character chooseCharacterRandom(int idParty) {
        int random_character;
        if (idParty == 0) {
            random_character = new Random().nextInt(0, party0.size());
            return party0.get(random_character);
        }
        if (idParty == 1) {
            random_character = new Random().nextInt(0, party1.size());
            return party1.get(random_character);
        }
        return null;
    }

    public static void removeCharacter(Character deathPlayer) {
        graveyard.add(deathPlayer);
        if (deathPlayer.getIdParty() == 0) {
            party0.remove(deathPlayer);
        } else if (deathPlayer.getIdParty() == 1) {
            party1.remove(deathPlayer);
        }
    }

    public static Character chooseCharacterManual(int idParty) {
        Character chosenCharacter = null;
        System.out.println("Equipo " + idParty);
        System.out.print(Graphics.ANSI_BLUE);
        if (idParty == 1) System.out.print(Graphics.ANSI_GREEN);
        for (Character p : party) {
            if (p.idParty == idParty && p.getHp() > 0) {
                System.out.println(p.id + "- " + p.name);
            }
        }
        System.out.print(Graphics.ANSI_RESET);
        System.out.print("Elige personaje de equipo " + idParty + ": ");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        //System.out.println("Has elegido a: " + s);
        for (Character p : party) {
            if (Integer.toString(p.id).equals(s)) {
                chosenCharacter = p;
            }
        }
        return chosenCharacter;
    }

    public static void showGraveyard() {
        for (Character p : graveyard) {
            if (p.getHp() <= 0) {
                System.out.println("Muerto: " + p);

            }
        }
        if (graveyard.size() == 0) System.out.println("Cementerio vacío");
    }

    public static void importParty() throws InterruptedException {
        Scanner sn = new Scanner(System.in);
        String file;
        System.out.print("Escribe el nombre del CSV a importar sin la extensión: ");

        file = sn.nextLine();
        file = "c:/java/game/src/" + file + ".csv";
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(",");
                if (data[0].equals("0")) {
                    if (data[1].equals("1")) {
                        party.add(new Warrior(data[2], 0, Integer.parseInt(data[3]), parseBoolean(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6])));
                    } else if (data[1].equals("2")) {
                        party.add(new Wizard(data[2], 0, Integer.parseInt(data[3]), parseBoolean(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6])));
                    }
                } else if (data[0].equals("1")) {
                    if (data[1].equals("1")) {
                        party.add(new Warrior(data[2], 1, Integer.parseInt(data[3]), parseBoolean(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6])));
                    } else if (data[1].equals("2")) {
                        party.add(new Wizard(data[2], 1, Integer.parseInt(data[3]), parseBoolean(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6])));
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Importando party...");
        //System.out.println(party);
        Thread.sleep(1000);

    }
}