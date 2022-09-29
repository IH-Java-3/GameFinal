public class Main {
    public static void main(String[] args) throws Exception {
        boolean exit = false;
        while (!exit) {
                exit = Menu.mainMenu();
            }
        }
}

//2 parties de 5 personajes cada uno.
//Verificación de existencia de party, si existe sobreescribir o volver al menú anterior.
//1. Creación manual de jugadorya
//Estas en party 1 ya
//Crear jugardor 1 ya
//tipo de jugador enum MAGO o GUERRERO ya
//si MAGO -> createWizard pida los datos de wizard nombre, salud, att1(mana), att2(int)
//si Guerrero -> createWarrior pida los datos de guerrero nombre, salud, att1(streght), att2(stamina)
//2. Creación aleatoria de jugador ya
