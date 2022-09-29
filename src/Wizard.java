import java.util.Random;

public class Wizard extends Character implements Attacker{

    int mana;
    int intelligence;

    public Wizard(String name, int idParty) {
        super(name, idParty);
        this.initAtributes();
    }

    public Wizard(String name, int idParty, int hp, boolean isAlive,int mana, int intelligence) {
        super(name, idParty);
        this.hp = hp;
        this.isAlive = isAlive;
        setMana(mana);
        setIntelligence(intelligence);
    }

    public int getMana() {
        return mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    private void initAtributes(){
        this.intelligence = new Random().nextInt(1, 51);
        this.mana = new Random().nextInt(10, 51);
        this.hp = new Random().nextInt(50, 101);
    }

    public int attackNormal() {
        setMana(getMana()-5);
        return getIntelligence();
    }

    public int attackEspecial() {
        setMana(getMana()+1);
        return 2;
    }

}