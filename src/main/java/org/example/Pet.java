package org.example;
public class Pet {

    private int petId;
    private String name;
    private String species;
    private int age;

    public Pet(int petId, String name, String species, int age) {
        this.petId = petId;
        setName(name);
        setSpecies(species);
        setAge(age);
    }

    public Pet() {
        this.petId = 0;
        this.name = "Unknown";
        this.species = "Unknown";
        this.age = 0;
    }

    public int getPetId() {
        return petId;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid pet name. Keeping previous value.");
        }
    }

    public void setSpecies(String species) {
        if (species != null && !species.trim().isEmpty()) {
            this.species = species;
        }
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative. Setting age to 0.");
            this.age = 0;
        }
    }

    public boolean isYoung() {
        return age < 2;
    }

    public String getLifeStage() {
        if (age < 2) return "Young";
        else if (age <= 7) return "Adult";
        else return "Senior";
    }


    @Override
    public String toString() {
        return "Pet{petId=" + petId + ", name='" + name +
                "', species='" + species + "', age=" + age + "}";
    }
}
