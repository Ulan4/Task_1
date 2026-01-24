package org.example.menu;
import org.example.model.*;
import org.example.exception.InvalidInputException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    private ArrayList<Pet> pets = new ArrayList<>();
    private ArrayList<Owner> owners = new ArrayList<>();
    private ArrayList<Veterinarian> vets = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("""
        ===== VETERINARY CLINIC =====
        1. Add Dog
        2. Add Cat
        3. View Pets
        4. Pets Make Sound (Polymorphism)
        5. Add Owner
        6. View Owners
        7. Add Veterinarian
        8. View Veterinarians
        9. Check Vet Can Treat Pet
        0. Exit
        """);
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> addDog();
                    case 2 -> addCat();
                    case 3 -> viewPets();
                    case 4 -> pets.forEach(Pet::makeSound);
                    case 5 -> addOwner();
                    case 6 -> viewOwners();
                    case 7 -> addVeterinarian();
                    case 8 -> viewVets();
                    case 9 -> checkTreatment();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a number.");

            } catch (IllegalArgumentException | InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());

            }
        }
    }


    private void addDog() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Breed: ");
        String breed = scanner.nextLine();

        pets.add(new Dog(id, name, age, breed));
    }

    private void addCat() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Indoor: ");
        boolean indoor = Boolean.parseBoolean(scanner.nextLine());

        pets.add(new Cat(id, name, age, indoor));
    }

    private void viewPets() {
        for (Pet p : pets) {
            System.out.println(p);

            if (p instanceof Dog d) d.fetch();
            if (p instanceof Cat c) c.scratch();
        }
    }

    private void addOwner() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Pets count: ");
        int count = Integer.parseInt(scanner.nextLine());

        owners.add(new Owner(id, name, phone, count));
    }

    private void viewOwners() {
        for (Owner o : owners) {
            System.out.println(o);
            if (o.isFrequentClient())
                System.out.println("⭐ Frequent Client");
        }
    }

    private void addVeterinarian() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Specialization: ");
        String spec = scanner.nextLine();

        System.out.print("Experience: ");
        int exp = Integer.parseInt(scanner.nextLine());

        vets.add(new Veterinarian(id, name, spec, exp));
    }

    private void viewVets() {
        for (Veterinarian v : vets) {
            System.out.println(v);
            if (v.isExperienced())
                System.out.println("⭐ Experienced Vet");
        }
    }

    private void checkTreatment() throws InvalidInputException {
        if (pets.isEmpty() || vets.isEmpty())
            throw new InvalidInputException("No pets or vets available");

        Veterinarian v = vets.getFirst();
        Pet p = pets.getFirst();

        System.out.println("Vet can treat pet: " + v.canTreat(p.getType()));
    }
}

