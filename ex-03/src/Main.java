import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static BathMachine bathMachine = new BathMachine();

    public static void main(String[] args) {

        var option = -1;

        do {
            System.out.println("+++ Bem-vindo ao sistema de banho de pets! +++");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Dar Banho no Pet");
            System.out.println("2. Adicionar Água na Máquina");
            System.out.println("3. Adicionar Shampoo na Máquina");
            System.out.println("4. Verificar Água na Máquina");
            System.out.println("5. Verificar Shampoo na Máquina");
            System.out.println("6. Tem Pet na Máquina?");
            System.out.println("7. Colocar Pet na Máquina");
            System.out.println("8. Retirar Pet da Máquina");
            System.out.println("9. Limpar a Máquina");
            System.out.println("0. Sair");

            option = scanner.nextInt();

            switch (option){
                case 1 -> bathingInPet();
                case 2 -> addWaterToTheBathMachine();
                case 3 -> addShampooToTheBathMachine();
                case 4 -> checkWaterLevel();
                case 5 -> checkShampooLevel();
                case 6 -> checkPetOnTheBathMachine();
                case 7 -> putPetInMachine();
                case 8 -> removePetFromMachine();
                case 9 -> washMachine();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);

    }

    public static void putPetInMachine(){

        String petName = "";

        while (petName.isEmpty() || petName == null) {
            System.out.println("Digite o nome do Pet:");
            petName = scanner.next();
        }

        Pet pet = new Pet(petName);
        bathMachine.setPet(pet);
        System.out.println("Pet " + pet.getName() + " colocado na máquina.");
    }

    public static void removePetFromMachine(){
        if (!bathMachine.hasPet()){
            System.out.println("Não há pet na máquina.");
            return;
        }

        System.out.println("Pet " + bathMachine.getPet().getName() + " retirado da máquina.");
        bathMachine.removePet();
    }

    public static void washMachine(){
        bathMachine.washMachine();
    }

    public static void checkPetOnTheBathMachine(){
        boolean hasPet = bathMachine.hasPet();
        System.out.println(hasPet ? "Há um pet na máquina: " + bathMachine.getPet().getName() + "." : "Não há pet na máquina.");
    }

    public static void checkShampooLevel(){
        System.out.println("Nível de shampoo na máquina: " + bathMachine.getShampoo() + " litros.");
    }

    public static void checkWaterLevel() {
        System.out.println("Nível de água na máquina: " + bathMachine.getWater() + " litros.");
    }

    public static void addShampooToTheBathMachine() {
        System.out.println("Adicionando shampoo à máquina de banho...");
        bathMachine.addShampoo();
    }

    public static void addWaterToTheBathMachine() {
        System.out.println("Adicionando água à máquina de banho...");
        bathMachine.addWater();
    }

    public static void bathingInPet(){
        System.out.println("Iniciando o banho do pet...");
        bathMachine.showering();
    }
}