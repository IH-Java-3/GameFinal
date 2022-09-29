import java.util.Random;

public class Guerrero extends Personaje implements Attacker{

int stamina;
int strength;

    public int getStamina() {
        return stamina;
    }

    public void setStamina() {
        this.stamina = new Random().nextInt(10, 50);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength() {
        this.strength = new Random().nextInt(1, 10);
   }

    public Guerrero(String name, int idParty) {
        super(name, idParty);
        setStamina();
        setStrength();
        setHp();
    }

    @Override
    public void setHp() {
        this.hp = new Random().nextInt(100, 200);
    }

    @Override
    public int attack() {
        return 0;
    }
}
