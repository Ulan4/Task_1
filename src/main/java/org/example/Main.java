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

        Pet pet1 = new Pet(1, "StudyBuddy", "CatDog.", 1);
        Pet pet2 = new Pet();
        Owner owner1 = new Owner(101, "Brown Brown", "+7 777 777 7777", 7);
        Owner owner2 = new Owner();

        Veterinarian vet1 = new Veterinarian(201, "Dr. Smith", "Dog", 6);

        System.out.println("--- PETS ---");
        pet1.setName("StudyBuddy");
        pet1.setPetId(1);
        pet1.setAge(1);
        pet1.setSpecies("CatDog");
        System.out.println(pet1);
        System.out.println(pet2);

        System.out.println("\n--- OWNERS ---");
        owner1.setOwnerId(101);
        owner1.setName("Brown Brown");
        owner1.setPhoneNumber("+7 777 777 7777");
        owner1.setNumberOfPets(7);
        System.out.println(owner1);
        System.out.println(owner2);

        System.out.println("\n--- VETERINARIAN ---");
        vet1.setVetId(201);
        vet1.setName("Dr. Smith");
        vet1.setExperienceYears(6);
        vet1.setSpecialization("Dog");
        System.out.println(vet1);

        System.out.println("\n--- TESTING METHODS ---");
        System.out.println(pet1.getName() + " life stage: " + pet1.getLifeStage());
        System.out.println("Is young: " + pet1.isYoung());
        System.out.println("Pet ID: " + pet1.getPetId());
        System.out.println("Age: " + pet1.getAge());
        System.out.println("Species: " + pet1.getSpecies());

        owner1.addPet();
        System.out.println(owner1.getName() + " frequent client: " + owner1.isFrequentClient());
        System.out.println("Owner ID: " + owner1.getOwnerId());
        System.out.println("Name: " + owner1.getName());
        System.out.println("Phone: " + owner1.getPhoneNumber());
        System.out.println("Number of pets: " + owner1.getNumberOfPets());

        System.out.println(vet1.getName() + " experienced: " + vet1.isExperienced());
        System.out.println("Can treat dogs: " + vet1.canTreat("Dog"));
        System.out.println("Vet ID: " + vet1.getVetId());
        System.out.println("Name: " + vet1.getName());
        System.out.println("Experience (years): " + vet1.getExperienceYears());
        System.out.println("Specialization: " + vet1.getSpecialization());

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

