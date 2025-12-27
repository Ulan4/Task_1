package org.example;
public class Veterinarian {

    private int vetId;
    private String name;
    private String specialization;
    private int experienceYears;

    public Veterinarian(int vetId, String name, String specialization, int experienceYears) {
        this.vetId = vetId;
        this.name = name;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
    }

    public int getVetId() {
        return vetId;
    }

    public String getName() {
        return name;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setVetId(int vetId) {
        this.vetId = vetId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


    public boolean isExperienced() {
        return experienceYears >= 5;
    }

    public boolean canTreat(String species) {
        return specialization.equalsIgnoreCase(species);
    }

    @Override
    public String toString() {
        return "Veterinarian{vetId=" + vetId + ", name='" + name +
                "', specialization='" + specialization +
                "', experienceYears=" + experienceYears + "}";
    }
}
