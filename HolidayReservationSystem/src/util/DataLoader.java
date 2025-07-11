package util;

import model.Flight;
import model.Hotel;
import model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    public static List<User> loadUsers(String filePath) {
        List<User> users = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    users.add(new User(username, password));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
        return users;
    }

    public static List<Flight> loadFlights(String filePath) {
        List<Flight> flights = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String flightNumber = parts[0].trim();
                    String source = parts[1].trim();
                    String destination = parts[2].trim();
                    String date = parts[3].trim();
                    String time = parts[4].trim();
                    double price = Double.parseDouble(parts[5].trim());

                    flights.add(new Flight(flightNumber, source, destination, date, time, price));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading flights: " + e.getMessage());
        }
        return flights;
    }

    public static List<Hotel> loadHotels(String filePath) {
        List<Hotel> hotels = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0].trim();
                    String location = parts[1].trim();
                    int rating = Integer.parseInt(parts[2].trim());
                    double pricePerNight = Double.parseDouble(parts[3].trim());

                    hotels.add(new Hotel(name, location, rating, pricePerNight));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading hotels: " + e.getMessage());
        }
        return hotels;
    }
}
