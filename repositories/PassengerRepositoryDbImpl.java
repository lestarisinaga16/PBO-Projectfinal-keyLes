package repositories;

import config.Database;
import entities.Passengers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class PassengerRepositoryDbImpl implements PassengersRepository {
    private final Database database;

    public PassengerRepositoryDbImpl(Database database) {
        this.database = database;
    }

    @Override
    public Passengers[] getAll() {
        String sqlStatement = "SELECT * FROM passengers";
        List<Passengers> passengersList = new ArrayList<>();
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Passengers passenger = new Passengers();
                passenger.setId(resultSet.getInt("id"));
                passenger.setName(resultSet.getString("name"));
                passenger.setAge(resultSet.getInt("age"));
                passenger.setGender(resultSet.getString("gender"));
                passenger.setPassportNumber(resultSet.getString("passport_number"));
                passenger.setKtpNumber(resultSet.getString("ktp_number"));
                passengersList.add(passenger);
            }
        } catch (Exception e) {
            System.out.println("Error fetching passengers: " + e.getMessage());
        }
        return passengersList.toArray(new Passengers[0]);
    }

    @Override
    public void add(Passengers passenger) {
        String sqlStatement = "INSERT INTO passengers (name, age, gender, passport_number, ktp_number) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setString(1, passenger.getName());
            preparedStatement.setInt(2, passenger.getAge());
            preparedStatement.setString(3, passenger.getGender());
            preparedStatement.setString(4, passenger.getPassportNumber());
            preparedStatement.setString(5, passenger.getKtpNumber());
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Passenger added successfully!");
            }
        } catch (Exception e) {
            System.out.println("Error adding passenger: " + e.getMessage());
        }
    }

    @Override
    public Boolean remove(Integer id) {
        String sqlStatement = "DELETE FROM passengers WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (Exception e) {
            System.out.println("Error removing passenger: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean edit(Passengers passenger) {
        String sqlStatement = "UPDATE passengers SET name = ?, age = ?, gender = ?, passport_number = ?, ktp_number = ? WHERE id = ?";
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            preparedStatement.setString(1, passenger.getName());
            preparedStatement.setInt(2, passenger.getAge());
            preparedStatement.setString(3, passenger.getGender());
            preparedStatement.setString(4, passenger.getPassportNumber());
            preparedStatement.setString(5, passenger.getKtpNumber());
            preparedStatement.setInt(6, passenger.getId());
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            System.out.println("Error editing passenger: " + e.getMessage());
            return false;
        }
    }
}
