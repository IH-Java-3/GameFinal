import java.util.Random;

public class Guerrero extends Personaje implements Attacker{

int stamina;
int strength;

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength() {
        Random random = new Random();
        this.strength = random.nextInt();
    }

    public Guerrero(int stamina, int strength) {
        this.stamina = stamina;
        this.strength = strength;
    }

    @Override
    public int attack() {
        return 0;
    }
}
