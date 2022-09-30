class Battles {
    public static void battle(Character player1, Character player2) {
        int damage1 = 0, damage2 = 0;
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
                Party.removeCharacter(player1);
                System.out.println(Graphics.ANSI_BLUE + "Party 1 " + Graphics.ANSI_RED + player1.getName() + " ha muerto\n" + Graphics.ANSI_RESET);
            }
            if (player2.getHp() <= 0) {
                player2.setHp(0);
                player2.setAlive(false);
                Party.removeCharacter(player2);
                System.out.println(Graphics.ANSI_GREEN + "Party 2 " + Graphics.ANSI_RED + player2.getName() + " ha muerto\n" + Graphics.ANSI_RESET);
            }
        }
    }
}

