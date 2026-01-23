package org.example.model;

public class Owner {

    private int ownerId;
    private String name;
    private String phone;
    private int numberOfPets;

    public Owner(int ownerId, String name, String phone, int numberOfPets) {
        setOwnerId(ownerId);
        setName(name);
        setPhone(phone);
        setNumberOfPets(numberOfPets);
    }

    public Owner() {
        this(1, "Unknown", "N/A", 0);
    }

    public int getOwnerId() { return ownerId; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public int getNumberOfPets() { return numberOfPets; }

    public void setOwnerId(int ownerId) {
        if (ownerId <= 0)
            throw new IllegalArgumentException("Owner ID must be positive");
        this.ownerId = ownerId;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Owner name cannot be empty");
        this.name = name;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\+?[0-9 ]{7,15}"))
            throw new IllegalArgumentException("Invalid phone number");
        this.phone = phone;
    }

    public void setNumberOfPets(int numberOfPets) {
        if (numberOfPets < 0)
            throw new IllegalArgumentException("Pets count cannot be negative");
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
        return "Owner{" +
                "ID=" + ownerId +
                ", Name='" + name + '\'' +
                ", Phone='" + phone + '\'' +
                ", Pets=" + numberOfPets +
                '}';
    }
}


