package org.example.model;

public abstract class Pet {

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

    public abstract void makeSound();   // REQUIRED
    public abstract String getType();   // REQUIRED

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getSpecies() { return species; }

    public void setId(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("Pet ID must be positive");
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Pet name cannot be empty");
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0)
            throw new IllegalArgumentException("Age cannot be negative");
        this.age = age;
    }

    public void setSpecies(String species) {
        if (species == null || species.trim().isEmpty())
            throw new IllegalArgumentException("Species required");
        this.species = species;
    }

    @Override
    public String toString() {
        return "[" + getType() + "] ID=" + id +
                ", Name=" + name +
                ", Age=" + age +
                ", Species=" + species;
    }
}
