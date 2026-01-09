package org.example;
public class Dog extends Pet {

    private String breed;

    public Dog(int id, String name, int age, String breed) {
        super(id, name, age, "Dog");
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Dog " + name + " barks 🐕");
    }

    @Override
    public String getType() {
        return "Dog";
    }

    public boolean isServiceDog() {
        return breed.equalsIgnoreCase("Labrador");
    }

    public void fetch() {
        System.out.println(name + " is fetching a ball 🎾");
    }

    @Override
    public String toString() {
        return super.toString() + ", Breed=" + breed;
    }
}
