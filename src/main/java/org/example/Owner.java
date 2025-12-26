package org.example;
public class Owner {

    private int ownerId;
    private String name;
    private String phone;
    private int numberOfPets;

    public Owner(int ownerId, String name, String phone, int numberOfPets) {
        this.ownerId = ownerId;
        this.name = name;
        this.phone = phone;
        this.numberOfPets = numberOfPets;
    }

    public Owner() {
        this.ownerId = 0;
        this.name = "Unknown";
        this.phone = "N/A";
        this.numberOfPets = 0;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPets() {
        return numberOfPets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfPets(int numberOfPets) {
        this.numberOfPets = numberOfPets;
    }

    public void addPet() {
        numberOfPets++;
    }

    public boolean isFrequentClient() {
        return numberOfPets >= 3;
    }

    @Override
    public String toString() {
        return "Owner{ownerId=" + ownerId + ", name='" + name +
                "', phone='" + phone + "', numberOfPets=" + numberOfPets + "}";
    }
}
