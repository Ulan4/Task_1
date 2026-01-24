package org.example.model;

public class Cat extends Pet {

    private boolean indoor;

    public Cat(int id, String name, int age, boolean indoor) {
        super(id, name, age, "Cat");

        this.indoor = indoor;
    }

    public boolean isIndoor() {
        return indoor;
    }

    @Override
    public void makeSound() {
        System.out.println("Cat " + name + " meows 🐱");
    }

    @Override
    public String getType() {
        return "Cat";
    }

    public void scratch() {
        System.out.println(name + " is scratching furniture 😼");
    }

    public boolean needsOutdoorCare() {
        return !indoor;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Indoor=" + (indoor ? "Yes" : "No");
    }
}


