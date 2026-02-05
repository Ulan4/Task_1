package org.example.database;

import org.example.model.Cat;
import org.example.model.Dog;
import org.example.model.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {


    public boolean insertPet(Pet pet, String ownerName) {
        String sql = """
                INSERT INTO animal (name, species, age, owner_name)
                VALUES (?, ?, ?, ?)
                """;

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pet.getName());
            ps.setString(2, pet.getSpecies());
            ps.setInt(3, pet.getAge());
            ps.setString(4, ownerName);

            int rows = ps.executeUpdate();
            ps.close();

            return rows > 0;

        } catch (SQLException e) {
            System.out.println(" Insert failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }


    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM animal ORDER BY animal_id";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pets.add(mapRowToPet(rs));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println(" Select failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return pets;
    }


    public Pet getPetById(int id) {
        String sql = "SELECT * FROM animal WHERE animal_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return null;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapRowToPet(rs);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println(" Select by ID failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return null;
    }


    public boolean updatePet(int id, String name, int age) {
        String sql = """
                UPDATE animal
                SET name = ?, age = ?
                WHERE animal_id = ?
                """;

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, id);

            int rowsUpdated = ps.executeUpdate();
            ps.close();

            return rowsUpdated > 0;

        } catch (SQLException e) {
            System.out.println(" Update failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }


    public boolean deletePet(int id) {
        String sql = "DELETE FROM animal WHERE animal_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            int rowsDeleted = ps.executeUpdate();
            ps.close();

            return rowsDeleted > 0;

        } catch (SQLException e) {
            System.out.println(" Delete failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }


    public List<Pet> searchByName(String name) {
        List<Pet> pets = new ArrayList<>();
        String sql = """
                SELECT * FROM animal
                WHERE name ILIKE ?
                ORDER BY name
                """;

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return pets;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pets.add(mapRowToPet(rs));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println(" Search by name failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return pets;
    }


    public List<Pet> searchByAgeRange(int minAge, int maxAge) {
        List<Pet> pets = new ArrayList<>();
        String sql = """
                SELECT * FROM animal
                WHERE age BETWEEN ? AND ?
                ORDER BY age DESC
                """;

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return pets;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, minAge);
            ps.setInt(2, maxAge);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pets.add(mapRowToPet(rs));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println(" Search by age range failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return pets;
    }

    public List<Pet> searchByMinAge(int minAge) {
        List<Pet> pets = new ArrayList<>();
        String sql = """
                SELECT * FROM animal
                WHERE age >= ?
                ORDER BY age DESC
                """;

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return pets;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, minAge);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pets.add(mapRowToPet(rs));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println(" Search by min age failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return pets;
    }


    private Pet mapRowToPet(ResultSet rs) throws SQLException {
        int id = rs.getInt("animal_id");
        String name = rs.getString("name");
        int age = rs.getInt("age");
        String species = rs.getString("species");

        return switch (species.toLowerCase()) {
            case "dog" -> new Dog(id, name, age, "Unknown");
            case "cat" -> new Cat(id, name, age, true);
            default -> new Dog(id, name, age, "Unknown");
        };
    }
}


