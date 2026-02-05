package org.example.menu;

import org.example.database.AnimalDAO;
import org.example.exception.InvalidInputException;
import org.example.model.Cat;
import org.example.model.Dog;
import org.example.model.Pet;

import java.util.List;
import java.util.Scanner;

public class MenuManager implements Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final AnimalDAO animalDAO = new AnimalDAO();

    @Override
    public void displayMenu() {
        System.out.println("""
        
        VETERINARY CLINIC
        ┌─ PET MANAGEMENT ──────────────────────┐
        │ 1. Add Dog                            │
        │ 2. Add Cat                            │
        │ 3. View All Pets                      │
        │ 4. Update Pet                         │
        │ 5. Delete Pet                         │
        ├─ SEARCH & FILTER ─────────────────────┤
        │ 6. Search Pet by Name                 │
        │ 7. Search Pet by Age Range            │
        │ 8. Search Pet by Minimum Age          │
        ├─ DEMO ───────────────────────────────┤
        │ 9. Pets Make Sound (Polymorphism)     │
        │ 0. Exit                               │
        └────────────────────────────────────────┘
        """);
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            try {
                System.out.print("Choose option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> addDog();
                    case 2 -> addCat();
                    case 3 -> viewAllPets();
                    case 4 -> updatePet();
                    case 5 -> deletePet();
                    case 6 -> searchByName();
                    case 7 -> searchByAgeRange();
                    case 8 -> searchByMinAge();
                    case 9 -> polymorphismDemo();
                    case 0 -> running = false;
                    default -> System.out.println(" Invalid option!");
                }

            } catch (NumberFormatException e) {
                System.out.println(" Please enter a valid number!");
            } catch (IllegalArgumentException e) {
                System.out.println(" Error: " + e.getMessage());
            }
        }

        System.out.println(" Program finished.");
    }


    private void addDog() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Breed: ");
        String breed = scanner.nextLine();

        System.out.print("Owner name: ");
        String owner = scanner.nextLine();

        Dog dog = new Dog(1, name, age, breed);
        animalDAO.insertPet(dog, owner);

        System.out.println(" Dog added successfully!");
    }

    private void addCat() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Indoor (true/false): ");
        boolean indoor = Boolean.parseBoolean(scanner.nextLine());

        System.out.print("Owner name: ");
        String owner = scanner.nextLine();

        Cat cat = new Cat(1, name, age, indoor);
        animalDAO.insertPet(cat, owner);

        System.out.println(" Cat added successfully!");
    }


    private void viewAllPets() {
        List<Pet> pets = animalDAO.getAllPets();

        if (pets.isEmpty()) {
            System.out.println(" No pets in database.");
            return;
        }

        System.out.println("\n--- ALL PETS ---");
        pets.forEach(System.out::println);
    }



    private void updatePet() {
        System.out.print("Enter pet ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        Pet existing = animalDAO.getPetById(id);
        if (existing == null) {
            System.out.println(" Pet not found!");
            return;
        }

        System.out.println("Current info:");
        System.out.println(existing);

        System.out.print("New name [" + existing.getName() + "]: ");
        String newName = scanner.nextLine();
        if (newName.isBlank()) newName = existing.getName();

        System.out.print("New age [" + existing.getAge() + "]: ");
        String ageInput = scanner.nextLine();
        int newAge = ageInput.isBlank()
                ? existing.getAge()
                : Integer.parseInt(ageInput);


        animalDAO.updatePet(id, newName, newAge);
        System.out.println(" Pet updated!");
    }


    private void deletePet() {
        System.out.print("Enter pet ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        Pet pet = animalDAO.getPetById(id);
        if (pet == null) {
            System.out.println(" Pet not found!");
            return;
        }

        System.out.println("Pet to delete:");
        System.out.println(pet);

        System.out.print("Are you sure? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            animalDAO.deletePet(id);
            System.out.println(" Pet deleted!");
        } else {
            System.out.println(" Deletion cancelled.");
        }
    }


    private void searchByName() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        List<Pet> pets = animalDAO.searchByName(name);
        pets.forEach(System.out::println);
    }

    private void searchByAgeRange() {
        System.out.print("Min age: ");
        int min = Integer.parseInt(scanner.nextLine());

        System.out.print("Max age: ");
        int max = Integer.parseInt(scanner.nextLine());

        List<Pet> pets = animalDAO.searchByAgeRange(min, max);
        pets.forEach(System.out::println);
    }

    private void searchByMinAge() {
        System.out.print("Minimum age: ");
        int min = Integer.parseInt(scanner.nextLine());

        List<Pet> pets = animalDAO.searchByMinAge(min);
        pets.forEach(System.out::println);
    }

    private void polymorphismDemo() {
        List<Pet> pets = animalDAO.getAllPets();

        if (pets.isEmpty()) {
            System.out.println(" No pets available.");
            return;
        }

        pets.forEach(Pet::makeSound);
    }
}
