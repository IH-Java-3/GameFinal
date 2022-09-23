import java.util.ArrayList;
import java.util.List;

public abstract class Personaje {

    final int id;
    String name;
    int hp;
    boolean isAlive;

    int

    ArrayList<String> listaNombres = new ArrayList <String>(List.of("Pikachu", "Raichu", "Snorlax", "Rattata", "Squirtle", "Charmander",
            "Bacu", "Arceus", "Zygarde", "Gengar", "11","12","13","14", "15", "16", "17", "18", "19", "20"));

    public Personaje(int id, String name, int hp, boolean isAlive) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.isAlive = isAlive;
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
}
