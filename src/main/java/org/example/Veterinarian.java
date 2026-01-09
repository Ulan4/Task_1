package org.example;
public class Veterinarian {

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

    public Veterinarian() {
        this.vetId = 0;
        this.name = "Unknown";
        this.specialization = "General";
        this.experienceYears = 0;
    }

    public int getVetId() {
        return vetId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setVetId(int vetId) {
        if (vetId > 0) {
            this.vetId = vetId;
        } else {
            this.vetId = 0;
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public void setSpecialization(String specialization) {
        if (specialization != null && !specialization.trim().isEmpty()) {
            this.specialization = specialization;
        }
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears >= 0) {
            this.experienceYears = experienceYears;
        }
    }

    public boolean isExperienced() {
        return experienceYears >= 5;
    }

    public boolean canTreat(String species) {
        return specialization.equalsIgnoreCase(species);
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "vetId=" + vetId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experienceYears=" + experienceYears +
                '}';
    }
}
