import java.util.Random;

public class Mago extends Personaje implements Attacker{

int mana;
int intelligence;

    public int getMana() {
        return mana;
    }

    public void setMana() {
        this.mana = new Random().nextInt(10, 50);;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence() {
        this.intelligence = new Random().nextInt(1, 50);;
    }

    public Mago(int id, String name, int hp, boolean isAlive, int mana, int intelligence, int idParty) {
        super(name, idParty);
        setMana();
        setIntelligence();
        this.intelligence = intelligence;
    }

    @Override
    public int attack() {
        return 0;
    }
}
