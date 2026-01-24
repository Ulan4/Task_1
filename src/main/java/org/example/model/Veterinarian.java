package org.example.model;

import org.example.interfaces.Treatable;

public class Veterinarian implements Treatable {

    private int vetId;
    private String name;
    private String specialization;
    private int experienceYears;

    public Veterinarian(int vetId, String name, String specialization, int experienceYears) {
        setVetId(vetId);
        setName(name);
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
    }

    public int getVetId() { return vetId; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public int getExperienceYears() { return experienceYears; }

    public void setVetId(int vetId) {
        if (vetId <= 0)
            throw new IllegalArgumentException("Vet ID must be positive");
        this.vetId = vetId;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Vet name cannot be empty");
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.isBlank())
            throw new IllegalArgumentException("Specialization required");
        this.specialization = specialization;
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0)
            throw new IllegalArgumentException("Experience cannot be negative");
        this.experienceYears = experienceYears;
    }

    public boolean isExperienced() {
        return experienceYears >= 5;
    }

    @Override
    public boolean canTreat(String species) {
        return specialization.equalsIgnoreCase(species);
    }


    @Override
    public String toString() {
        return "Veterinarian{" +
                "ID=" + vetId +
                ", Name='" + name + '\'' +
                ", Spec='" + specialization + '\'' +
                ", Exp=" + experienceYears +
                '}';
    }
}

