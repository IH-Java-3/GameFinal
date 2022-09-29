import java.util.ArrayList;
import java.util.List;

public abstract class Character {

    final int id;
    String name;
    int hp;
    boolean isAlive;
    int idParty;
    static int counter = 0;

    static ArrayList<String> namesList = new ArrayList <String>(List.of("Pikachu", "Raichu", "Snorlax", "Rattata",
            "Squirtle", "Charmander", "Bacu", "Arceus", "Zygarde", "Gengar", "Blastoise","Caterpie","Metapod","Butterfree",
            "Charizard", "Wartortle", "Ivysaur", "Venusaur", "Clefable", "Primeape"));

    public Character(String name, int idParty) {
        this.id = counter++;
        this.name = name;
        this.isAlive = true;
        setIdParty(idParty);
    }

    public int getIdParty() {
        return idParty;
    }

    public void setIdParty(int idParty) {
        this.idParty = idParty;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", isAlive=" + isAlive +
                ", idParty=" + idParty +
                '}';
    }

}