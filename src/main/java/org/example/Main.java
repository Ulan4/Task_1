package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Pet> pets = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("🐾 VETERINARY CLINIC MANAGEMENT 🐾");
        System.out.println("====================================");

        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addPet();
                    break;
                case 2:
                    viewAllPets();
                    break;
                case 0:
                    System.out.println("\n👋 Goodbye! Stay healthy!");
                    running = false;
                    break;
                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
            if (running) {
                System.out.println("\n👉 Press Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
        // Create objects
        Pet pet1 = new Pet(1, "Buddy", "Dog", 1);
        Pet pet2 = new Pet();
        Owner owner1 = new Owner(101, "Alice Brown", "+77011234567", 2);
        Owner owner2 = new Owner();

        Veterinarian vet1 = new Veterinarian(201, "Dr. Smith", "Dog", 6);

        System.out.println("--- PETS ---");
        System.out.println(pet1);
        System.out.println(pet2);

        System.out.println("\n--- OWNERS ---");
        System.out.println(owner1);
        System.out.println(owner2);

        System.out.println("\n--- VETERINARIAN ---");
        System.out.println(vet1);

        System.out.println("\n--- TESTING METHODS ---");
        System.out.println(pet1.getName() + " life stage: " + pet1.getLifeStage());
        System.out.println("Is young: " + pet1.isYoung());

        owner1.addPet();
        System.out.println(owner1.getName() + " frequent client: " + owner1.isFrequentClient());

        System.out.println(vet1.getName() + " experienced: " + vet1.isExperienced());
        System.out.println("Can treat dogs: " + vet1.canTreat("Dog"));

        System.out.println("\n=== Program Complete ===");
    }


    private static void displayMenu() {
        System.out.println("\n------------------------------------");
        System.out.println("1️⃣ Add new pet");
        System.out.println("2️⃣ View all pets");
        System.out.println("0️⃣ Exit and test program by creating object");
        System.out.print("👉 Enter your choice: ");
    }
    private static void addPet() {
        System.out.println("\n🐶 ADD NEW PET");

        System.out.print("Enter pet ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter pet name: ");
        String name = scanner.nextLine();

        System.out.print("Enter species: ");
        String species = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        Pet pet = new Pet(id, name, species, age);
        pets.add(pet);

        System.out.println("✅ Pet added successfully!");
    }
    private static void viewAllPets() {
        System.out.println("\n🌟 LIST OF PETS 🌟");

        if (pets.isEmpty()) {
            System.out.println("❌ No pets found.");
            return;
        }

        for (int i = 0; i < pets.size(); i++) {
            System.out.println((i + 1) + ". " + pets.get(i));
        }
    }
}

