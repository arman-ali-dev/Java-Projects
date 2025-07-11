import model.*;
import service.*;
import util.DataLoader;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<User> users;
    private static List<Flight> flights;
    private static List<Hotel> hotels;

    private static User currentUser;

    private static final Scanner scanner = new Scanner(System.in);
    private static final SearchService searchService = new SearchService();
    private static final SortService sortService = new SortService();
    private static final BookingService bookingService = new BookingService();

    public static void main(String[] args) {
        // Step 1: Load data
        users = DataLoader.loadUsers("data/users.txt");
        flights = DataLoader.loadFlights("data/flights.txt");
        hotels = DataLoader.loadHotels("data/hotels.txt");

        // Step 2: User login
        login();

        // Step 3: Main menu
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> searchFlights();
                case 2 -> searchHotels();
                case 3 -> bookFlight();
                case 4 -> bookHotel();
                case 5 -> bookingService.viewBookings(currentUser);
                case 6 -> cancelBooking();
                case 7 -> sortFlightsByPrice();
                case 8 -> sortHotelsByPrice();
                case 9 -> sortHotelsByRating();
                case 0 -> {
                    System.out.println("👋 Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }

        }
    }

    private static void sortFlightsByPrice() {
        sortService.sortFlightsByPrice(flights);
        System.out.println("\nFlights sorted by price (ascending):");
        for (Flight f : flights) {
            System.out.println("----------------------");
            System.out.println(f);
        }
    }

    private static void sortHotelsByPrice() {
        sortService.sortHotelsByPrice(hotels);
        System.out.println("\nHotels sorted by price (ascending):");
        for (Hotel h : hotels) {
            System.out.println("----------------------");
            System.out.println(h);
        }
    }

    private static void sortHotelsByRating() {
        sortService.sortHotelsByRating(hotels);
        System.out.println("\nHotels sorted by rating (descending):");
        for (Hotel h : hotels) {
            System.out.println("----------------------");
            System.out.println(h);
        }
    }

    private static void cancelBooking() {
        List<Booking> bookings = currentUser.getBookings();
        if (bookings.isEmpty()) {
            System.out.println("You have no bookings to cancel.");
            return;
        }

        System.out.println("\nYour current bookings:");
        for (Booking b : bookings) {
            System.out.println("----------------------");
            System.out.println(b);
        }

        System.out.print("\nEnter Booking ID to cancel: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        bookingService.cancelBooking(currentUser, id);
    }

    private static void bookFlight() {
        System.out.print("Enter flight number to book: ");
        String flightNumber = scanner.nextLine();

        Flight flight = searchService.searchFlightByNumber(flights, flightNumber);
        if (flight == null) {
            System.out.println("Flight not found.");
            return;
        }

        bookingService.bookFlight(currentUser, flightNumber);
    }

    private static void bookHotel() {
        System.out.print("Enter hotel name to book: ");
        String hotelName = scanner.nextLine();

        Hotel hotel = searchService.searchHotelByName(hotels, hotelName);
        if (hotel == null) {
            System.out.println("Hotel not found.");
            return;
        }

        bookingService.bookHotel(currentUser, hotelName);
    }

    private static void searchFlights() {
        System.out.print("Enter source city: ");
        String source = scanner.nextLine();
        System.out.print("Enter destination city: ");
        String destination = scanner.nextLine();

        List<Flight> result = searchService.searchFlights(flights, source, destination);
        if (result.isEmpty()) {
            System.out.println("No flights found for this route.");
        } else {
            System.out.println("\nAvailable Flights:");
            for (Flight f : result) {
                System.out.println("----------------------");
                System.out.println(f);
            }
        }
    }

    private static void searchHotels() {
        System.out.print("Enter city/location to search hotels: ");
        String location = scanner.nextLine();

        List<Hotel> result = searchService.searchHotelsByLocation(hotels, location);
        if (result.isEmpty()) {
            System.out.println("No hotels found in this location.");
        } else {
            System.out.println("\nAvailable Hotels:");
            for (Hotel h : result) {
                System.out.println("----------------------");
                System.out.println(h);
            }
        }
    }

    private static void login() {
        System.out.println("Welcome to Holiday Reservation System");
        while (true) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            for (User user : users) {
                if (user.getUsername().equalsIgnoreCase(username) && user.checkPassword(password)) {
                    currentUser = user;
                    System.out.println("Login successful!");
                    return;
                }
            }
            System.out.println("Invalid credentials. Try again.\n");
        }
    }

    private static void showMenu() {
        System.out.println("\n======= MENU =======");
        System.out.println("1. Search Flights");
        System.out.println("2. Search Hotels");
        System.out.println("3. Book a Flight");
        System.out.println("4. Book a Hotel");
        System.out.println("5. View My Bookings");
        System.out.println("6. Cancel Booking");
        System.out.println("7. Sort Flights by Price");
        System.out.println("8. Sort Hotels by Price");
        System.out.println("9. Sort Hotels by Rating");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

}
