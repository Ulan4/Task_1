package org.example;
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

    public String getPhone() {
        return phone;
    }

    public int getNumberOfPets() {
        return numberOfPets;
    }

    public void setOwnerId(int ownerId) {
        if (ownerId > 0) {
            this.ownerId = ownerId;
        } else {
            this.ownerId = 0;
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public void setPhone(String phone) {
        if (phone != null && phone.matches("\\+?[0-9 ]{7,15}")) {
            this.phone = phone;
        } else {
            this.phone = "N/A";
        }
    }

    public void setNumberOfPets(int numberOfPets) {
        if (numberOfPets >= 0) {
            this.numberOfPets = numberOfPets;
        }
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
                "ownerId=" + ownerId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", numberOfPets=" + numberOfPets +
                '}';
    }
}

