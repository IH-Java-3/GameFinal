import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Boolean.parseBoolean;

public class Party {
    public static List<Character> party = new ArrayList<>();

    public static List<Character> party1 = new ArrayList<>();
    public static List<Character> party2 = new ArrayList<>();
    public static List<Character> graveyard = new ArrayList<>();


    /*
    public static void main(String[] args) {
        createRandomParty();
        battleRandom();
    }
     */
    public static boolean checkEmptyParty(List<Character> party) {
        boolean bool;
        bool = party.isEmpty();
        System.out.println("la party está vacía " + bool);
        return bool;
    }

    private static String getRandomName() {
        String name = Character.namesList.get(new Random().nextInt(0, Character.namesList.size()));
        boolean exists = false;
        for (Character p : party) {
            if (p.getName().equals(name)) {
                exists = true;
                break;
            }
        }
        if (exists) name += " Jr";
        return name;
    }

    private static void createRandomCharacter(int idParty) {
        for (int i = 0; i < 5; i++) {
            if (new Random().nextInt(1, 3) == 1) {
                party.add(new Warrior(getRandomName(), idParty));
            } else {
                party.add(new Wizard(getRandomName(), idParty));
            }
        }
    }

    public static void createCharacter() {
        String opcion;
        String opcion2;
        for (int i = 0; i < 2; i++) {
            System.out.println("Estamos creando party " + (i + 1));
            for (int j = 0; j < 2; j++) {
                Scanner sn = new Scanner(System.in);
                System.out.print("Introduzca el tipo del personaje " + (j + 1) + " WARRIOR o WIZARD : ");
                opcion = sn.nextLine();
                switch (opcion.toUpperCase()) {
                    case "WARRIOR" -> {
                        System.out.print("Introduzca el nombre del personaje " + (j + 1) + ": ");
                        opcion2 = sn.nextLine();
                        party.add(new Warrior(opcion2, i));
                    }
                    case "WIZARD" -> {
                        System.out.print("Introduzca el nombre del personaje " + (j + 1) + ": ");
                        opcion2 = sn.nextLine();
                        party.add(new Wizard(opcion2, i));
                    }
                    default -> {
                        System.out.println("Solo introduzca WARRIOR ó WIZARD");
                        j--;
                    }
                }
            }
        }
        //for (int i = 0; i < party.size(); i++) {
        //    //System.out.println(party.get(i) + " " +1 party.get(i).getClass());
        //}
    }

    public static void createRandomParty() {
        party = new ArrayList<>();
        createRandomCharacter(0);
        createRandomCharacter(1);
    }

    private static boolean hasMembersAlive(int idParty) {
        boolean alive = false;
        for (Character p : party) {
            if (p.getIdParty() == idParty && p.getHp() > 0) {
                //if (p.idParty == idParty && p.isAlive){ codigo antiguo lili
                alive = true;
                return alive;
            }
        }
        return alive;
    }

    public static void battleRandom() {
        Character player1, player2;
        int damage1 = 0, damage2 = 0;

        while (hasMembersAlive(0) && hasMembersAlive(1)) {
            System.out.println(party);
            player1 = chooseCharacterRandom(0);
            player2 = chooseCharacterRandom(1);

            while (player1.getHp() > 0 && player2.getHp() > 0) {
                System.out.println("*******Player 1: " + player1);
                System.out.println("*******Player 2: " + player2);

                while (player1.getHp() > 0 && player2.getHp() > 0) {
                    if (player1 instanceof Warrior) {
                        if (((Warrior) player1).getStamina() < 15) {
                            damage1 = (((Warrior) player1).attackNormal());
                        } else {
                            damage1 = (((Warrior) player1).attackEspecial());
                        }
                    } else if (player1 instanceof Wizard) {
                        if (((Wizard) player1).getMana() < 15) {
                            damage1 = (((Wizard) player1).attackNormal());
                        } else {
                            damage1 = (((Wizard) player1).attackEspecial());
                        }
                    }

                    if (player2 instanceof Warrior) {
                        if (((Warrior) player2).getStamina() < 15) {
                            damage1 = (((Warrior) player2).attackNormal());
                        } else {
                            damage1 = (((Warrior) player2).attackEspecial());
                        }
                    } else if (player2 instanceof Wizard) {
                        if (((Wizard) player2).getMana() < 15) {
                            damage1 = (((Wizard) player2).attackNormal());
                        } else {
                            damage1 = (((Wizard) player2).attackEspecial());
                        }
                    }
                }
                System.out.println("Party 1 " + player1.getName() + " hace " + damage1 + " puntos de daño a " + player2.getName());
                System.out.println("Party 2 " + player2.getName() + " hace " + damage2 + " puntos de daño a " + player1.getName());

                player1.setHp(player1.getHp() - damage2);
                player2.setHp(player2.getHp() - damage1);
                if (player1.getHp() <= 0) {
                    player1.setHp(0);
                    player1.setAlive(false);
                    System.out.println("Party 1 " + player1.getName() + " ha muerto");
                }
                if (player2.getHp() <= 0) {
                    player2.setHp(0);
                    player2.setAlive(false);
                    System.out.println("Party 2 " + player2.getName() + " ha muerto");
                }
            }
        }
    }

    public static void battleManual() throws Exception {
        int damage1 = 0, damage2 = 0;
        while (hasMembersAlive(0) && hasMembersAlive(1)) {
            Character player1 = chooseCharacterManual(0);
            Character player2 = chooseCharacterManual(1);

            while (player1.getHp() > 0 && player2.getHp() > 0) {
                if (player1 instanceof Warrior) {
                    if (((Warrior) player1).getStamina() >= 5) {
                        damage1 = (((Warrior) player1).attackNormal());
                    } else {
                        damage1 = (((Warrior) player1).attackEspecial());
                    }
                } else if (player1 instanceof Wizard) {
                    if (((Wizard) player1).getMana() >= 5) {
                        damage1 = (((Wizard) player1).attackNormal());
                    } else {
                        damage1 = (((Wizard) player1).attackEspecial());
                    }
                }

                if (player2 instanceof Warrior) {
                    if (((Warrior) player2).getStamina() >= 5) {
                        damage2 = (((Warrior) player2).attackNormal());
                    } else {
                        damage2 = (((Warrior) player2).attackEspecial());
                    }
                } else if (player2 instanceof Wizard) {
                    if (((Wizard) player2).getMana() >= 5) {
                        damage2 = (((Wizard) player2).attackNormal());
                    } else {
                        damage2 = (((Wizard) player2).attackEspecial());
                    }
                }

                System.out.print(Graphics.ANSI_BLUE + "Party 1 " + player1.getName() + Graphics.ANSI_RESET + " hace " + damage1 + " puntos de daño a " + Graphics.ANSI_GREEN + player2.getName());
                System.out.println(Graphics.ANSI_RESET + " Y " + Graphics.ANSI_GREEN + "Party 2 " + player2.getName() + Graphics.ANSI_RESET + " hace " + damage2 + " puntos de daño a " + Graphics.ANSI_BLUE + "Party 1 " + player1.getName() + Graphics.ANSI_RESET);

                player1.setHp(player1.getHp() - damage2);
                player2.setHp(player2.getHp() - damage1);
                if (player1.getHp() <= 0) {
                    player1.setHp(0);
                    player1.setAlive(false);
                    removeCharacter(player1);
                    System.out.println(Graphics.ANSI_BLUE + "Party 1 " + Graphics.ANSI_RED + player1.getName() + " ha muerto\n" + Graphics.ANSI_RESET);
                }
                if (player2.getHp() <= 0) {
                    player2.setHp(0);
                    player2.setAlive(false);
                    removeCharacter(player2);
                    System.out.println(Graphics.ANSI_GREEN + "Party 2 " + Graphics.ANSI_RED + player2.getName() + " ha muerto\n" + Graphics.ANSI_RESET);
                }
            }
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

    private static Character chooseCharacterRandom(int idParty) {
        int random_character = 0;
        if (idParty == 0) random_character = new Random().nextInt(0, 2);
        if (idParty == 1) random_character = new Random().nextInt(2, 4);
        for (int i = 0; i < party.size(); i++) {
            //if (party.get(i).getIdParty() == idParty && party.get(i).getId() == random_character && party.get(i).getHp() > 0) {
            if (party.get(i).getIdParty() == idParty && party.get(i).getId() == random_character) {
                return party.get(random_character);
            }
        }
        return null;
    }

    public static void removeCharacter(Character deathPlayer) {
        graveyard.add(deathPlayer);
        party.remove(deathPlayer);
    }

    public static Character chooseCharacterManual(int idParty) {
        Character chosenCharacter = null;
        System.out.println("Equipo " + (idParty+1));
        System.out.print(Graphics.ANSI_BLUE);
        if (idParty == 1) System.out.print(Graphics.ANSI_GREEN);
        for (Character p : party) {
            if (p.idParty == idParty && p.getHp() > 0) {
                System.out.println(p.id + "- " + p.name);
            }
        }
        System.out.print(Graphics.ANSI_RESET);
        System.out.print("Elige personaje de equipo " + (idParty+1) + ": ");
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
        File f = new File(file);
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