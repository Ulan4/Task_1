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
    }

    // Menu
    private static void displayMenu() {
        System.out.println("\n------------------------------------");
        System.out.println("1️⃣ Add new pet");
        System.out.println("2️⃣ View all pets");
        System.out.println("0️⃣ Exit");
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

