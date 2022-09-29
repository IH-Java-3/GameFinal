import java.util.Random;

public class Warrior extends Character implements Attacker{

    int stamina;
    int strength;

    public Warrior(String name, int idParty) {
        super(name, idParty);
        initAttributes();
    }

    public Warrior(String name, int idParty, int hp, boolean isAlive,int stamina, int strength) {
        super(name, idParty);
        this.hp = hp;
        this.isAlive = isAlive;
        this.stamina = stamina;
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    private void initAttributes(){
        this.stamina = new Random().nextInt(10, 51);
        this.strength = new Random().nextInt(1, 11);
        this.hp = new Random().nextInt(100, 201);
    }

    public int attackNormal() {
        setStamina(getStamina()-5);
        //System.out.println("Daño1 " + character.getStrength());
        return getStrength();
    }

    public int attackEspecial() {
        setStamina(getStamina()+1);
        //System.out.println("Daño2 " + (int) (character.getStrength()/2));
        return (int) (getStrength()/2);
    }
}
