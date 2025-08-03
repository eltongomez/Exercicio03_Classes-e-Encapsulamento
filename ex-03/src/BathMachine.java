public class BathMachine {

    private boolean clean;
    private int water;
    private int shampoo;
    private Pet pet;

    public void showering(){
        if (pet == null) {
            System.out.println("No pet to shower.");
            return;
        }
        if (water <= 0) {
            System.out.println("No water available.");
            return;
        }
        if (shampoo <= 0) {
            System.out.println("No shampoo available.");
            return;
        }

        System.out.println("Showering " + pet.getName() + "...");
        pet.setClean(true);
        clean = true;
        water -= 10;
        shampoo -= 2;
        System.out.println(pet.getName() + " is now clean.");
    }

    public void addWater() {
        if (water == 30){
            System.out.println("O reservatório de água está completo. Total: " + water);
        } else {
            water += 2;
            System.out.println("Adicionado 2 litros de água. Total: " + water);
        }
    }

    public void addShampoo() {
        if (shampoo == 10){
            System.out.println("O reservatório de shampoo está completo. Total: " + shampoo);
        } else {
            shampoo += 2;
            System.out.println("Adicionado 2 litros de shampoo. Total: " + shampoo);
        }
    }

    public int getWater() {
        return water;
    }

    public int getShampoo() {
        return shampoo;
    }
}
