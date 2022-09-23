public class Mago extends Personaje implements Attacker{

int mana;
int intelligence;

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public Mago(int id, String name, int hp, boolean isAlive, int mana, int intelligence, int idParty) {
        super(name, idParty);
        this.mana = mana;
        this.intelligence = intelligence;
    }

    @Override
    public int attack() {
        return 0;
    }
}
