package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Pet> pets = new ArrayList<>();
    private static ArrayList<Owner> owners = new ArrayList<>();
    private static ArrayList<Veterinarian> veterinarians = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            menu();
            int choice = readInt();

            switch (choice) {
                case 1 -> addPet();
                case 2 -> viewPets();
                case 3 -> addOwner();
                case 4 -> viewOwners();
                case 5 -> addVet();
                case 6 -> viewVets();
                case 9 -> runAllTests();
                case 0 -> running = false;
            }
        }
        scanner.close();
    }

    private static void menu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1 Add Pet");
        System.out.println("2 View Pets");
        System.out.println("3 Add Owner");
        System.out.println("4 View Owners");
        System.out.println("5 Add Veterinarian");
        System.out.println("6 View Veterinarians");
        System.out.println("9 TEST EVERYTHING");
        System.out.println("0 Exit");
    }

    private static void addPet() {
        System.out.print("1 Dog | 2 Cat: ");
        int type = readInt();

        System.out.print("ID: ");
        int id = readInt();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = readInt();

        if (type == 1) {
            System.out.print("Breed: ");
            String breed = scanner.nextLine();
            pets.add(new Dog(id, name, age, breed));
        } else {
            System.out.print("Indoor (true/false): ");
            boolean indoor = Boolean.parseBoolean(scanner.nextLine());
            pets.add(new Cat(id, name, age, indoor));
        }
    }

    private static void viewPets() {
        for (Pet p : pets) {
            System.out.println(p.getId() + " " + p.getName() + " " + p.getSpecies());
            p.makeSound();

            if (p instanceof Dog d) {
                System.out.println("Breed: " + d.getBreed());
                System.out.println("Service dog: " + d.isServiceDog());
                d.fetch();
            }

            if (p instanceof Cat c) {
                System.out.println("Indoor: " + c.isIndoor());
                System.out.println("Needs outdoor care: " + c.needsOutdoorCare());
                c.scratch();
            }
        }
    }


    private static void addOwner() {
        System.out.print("1 Default | 2 With data: ");
        int type = readInt();

        Owner o;

        if (type == 1) {
            o = new Owner();
        } else {
            System.out.print("ID: ");
            int id = readInt();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Phone: ");
            String phone = scanner.nextLine();
            System.out.print("Pets count: ");
            int count = readInt();

            o = new Owner(id, name, phone, count);
        }
        owners.add(o);
    }

    private static void viewOwners() {
        for (Owner o : owners) {
            System.out.println(
                    o.getOwnerId() + " " +
                            o.getName() + " " +
                            o.getPhone() + " pets=" +
                            o.getNumberOfPets()
            );
            o.addPet();
            System.out.println("Frequent client: " + o.isFrequentClient());
        }
    }


    private static void addVet() {
        System.out.print("1 Default | 2 With data: ");
        int type = readInt();

        Veterinarian v;

        if (type == 1) {
            v = new Veterinarian();
        } else {
            System.out.print("ID: ");
            int id = readInt();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Spec: ");
            String spec = scanner.nextLine();
            System.out.print("Experience: ");
            int exp = readInt();

            v = new Veterinarian(id, name, spec, exp);
        }
        veterinarians.add(v);
    }

    private static void viewVets() {
        for (Veterinarian v : veterinarians) {
            System.out.println(
                    v.getVetId() + " " +
                            v.getName() + " spec=" +
                            v.getSpecialization() +
                            " exp=" + v.getExperienceYears()
            );
            System.out.println("Experienced: " + v.isExperienced());
            System.out.println("Can treat dogs: " + v.canTreat("Dog"));
        }
    }

    private static void runAllTests() {
        System.out.println("\n=== FULL TEST ===");

        Owner o = new Owner();
        o.getOwnerId(); o.getName(); o.getPhone(); o.getNumberOfPets();
        System.out.println("\n Owner class work");
        for (Owner o1 : owners) {
            System.out.println(o1);
        }


        Veterinarian v = new Veterinarian();
        v.getVetId(); v.getName(); v.getExperienceYears(); v.getSpecialization();
        System.out.println("\n Veterinarian class work");
        for (Veterinarian v1 : veterinarians) {
            System.out.println(v1);
        }

        Dog d = new Dog(1, "Max", 4, "Labrador");
        d.getBreed(); d.fetch(); d.isServiceDog();
        System.out.println("\n Dog class work");


        Cat c = new Cat(2, "Luna", 2, true);
        c.isIndoor(); c.needsOutdoorCare(); c.scratch();
        System.out.println("\n Cat class work");

        for (Pet p : pets) {
            System.out.println(p);
        }

        System.out.println("=== ALL USED ===");
    }

    private static int readInt() {
        while (!scanner.hasNextInt()) scanner.next();
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }
}
