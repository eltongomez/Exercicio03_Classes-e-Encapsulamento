public class BathMachine {

    private boolean clean;
    private int water;
    private int shampoo;
    private Pet pet;

    public BathMachine() {
        this.clean = true; // A máquina começa limpa
        this.water = 30; // Capacidade máxima de água
        this.shampoo = 10; // Capacidade máxima de shampoo
        this.pet = null; // Inicialmente, não há pet na máquina
    }

    public void showering(){
        if (pet == null) {
            System.out.println("Não há pet na máquina.");
            return;
        }
        if (water <= 0) {
            System.out.println("Água insuficiente para o banho.");
            return;
        }
        if (shampoo <= 0) {
            System.out.println("Shampoo insuficiente para o banho.");
            return;
        }

        System.out.println("Showering " + pet.getName() + "...");
        pet.setClean(true);
        clean = true;
        water -= 10;
        shampoo -= 2;
        System.out.println(pet.getName() + " O pet está limpo.");
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

    public boolean hasPet() {
        return pet != null;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {

        if(hasPet()){
            System.out.println("O Pet: "+ this.pet.getName() + " está tomando banho.");
            return;
        }

        if(!this.clean){
            System.out.println("A máquina de banho não está limpa. Por favor, limpe-a antes de adicionar um novo pet.");
            return;
        }
        this.pet = pet;
    }

    public void removePet() {
        if (this.pet == null) {
            System.out.println("Nenhum pet para remover.");
            return;
        }
        System.out.println("Removendo " + this.pet.getName() + " da máquina de banho.");
        this.clean = this.pet.isClean();
        this.pet = null;
    }

    public void washMachine() {
        if (hasPet()) {
            System.out.println("Antes de lavar a máquina, remova o pet: " + this.pet.getName());
            return;
        }
        if (water < 10 || shampoo < 2) {
            System.out.println("Não há água ou shampoo suficiente para lavar a máquina.");
            return;
        }
        if(!this.clean) {
            System.out.println("Lavando a máquina de banho...");
            this.water -= 10;
            this.shampoo -= 2;
            this.clean = true;
            System.out.println("Máquina de banho lavada com sucesso.");
        }
    }
}
