package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Booking> bookings;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.bookings = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void showBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            for (Booking b : bookings) {
                System.out.println("-------------------------");
                System.out.println(b);
            }
        }
    }
}
