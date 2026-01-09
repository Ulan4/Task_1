package org.example;
public class Pet {

    protected int id;
    protected String name;
    protected int age;
    protected String species;

    public Pet(int id, String name, int age, String species) {
        setId(id);
        setName(name);
        setAge(age);
        setSpecies(species);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecies() {
        return species;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("Invalid ID. Setting to 0.");
            this.id = 0;
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Name cannot be empty.");
            this.name = "Unknown";
        }
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative. Setting to 0.");
            this.age = 0;
        }
    }

    public void setSpecies(String species) {
        if (species != null && !species.trim().isEmpty()) {
            this.species = species;
        } else {
            this.species = "Unknown";
        }
    }


    public void makeSound() {
        System.out.println(name + " makes a sound.");
    }

    public String getType() {
        return "Pet";
    }

    @Override
    public String toString() {
        return "[" + getType() + "] ID=" + id +
                ", Name=" + name +
                ", Age=" + age +
                ", Species=" + species;
    }
}

