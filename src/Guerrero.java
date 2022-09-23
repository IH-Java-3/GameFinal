import java.util.Random;

public class Guerrero extends Personaje implements Attacker{

int stamina;
int strength;

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = new Random().nextInt(10, 50);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength() {
        this.strength = new Random().nextInt(1, 10);
   }

    public Guerrero(int id, String name, int hp, boolean isAlive, int stamina, int strength) {
        super(id, name, hp, isAlive);
        this.stamina = stamina;
        this.strength = strength;
    }

    @Override
    public int attack() {
        return 0;
    }
}
