import java.util.ArrayList;
import java.util.List;

public abstract class Personaje {

    final int id;
    String name;
    int hp;
    boolean isAlive;

    int idParty;

    int counter = 0;

    ArrayList<String> listaNombres = new ArrayList <String>(List.of("Pikachu", "Raichu", "Snorlax", "Rattata", "Squirtle", "Charmander",
            "Bacu", "Arceus", "Zygarde", "Gengar", "11","12","13","14", "15", "16", "17", "18", "19", "20"));

    public Personaje(String name, int idParty) {
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

    protected void setHp() {
    }
}
