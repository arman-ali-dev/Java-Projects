package service;

import model.Booking;
import model.User;

import java.time.LocalDate;
import java.util.List;

public class BookingService {

    public void bookFlight(User user, String flightNumber) {
        Booking booking = new Booking(
                user.getUsername(),
                "flight",
                "Flight No: " + flightNumber,
                LocalDate.now());
        user.addBooking(booking);
        System.out.println("Flight booked successfully!\n" + booking);
    }

    public void bookHotel(User user, String hotelName) {
        Booking booking = new Booking(
                user.getUsername(),
                "hotel",
                "Hotel Name: " + hotelName,
                LocalDate.now());
        user.addBooking(booking);
        System.out.println("Hotel booked successfully!\n" + booking);
    }

    public void viewBookings(User user) {
        System.out.println("\n Your Bookings:");
        user.showBookings();
    }

    public void cancelBooking(User user, int bookingId) {
        List<Booking> bookings = user.getBookings();
        boolean removed = bookings.removeIf(b -> b.getBookingId() == bookingId);
        if (removed) {
            System.out.println(" Booking ID " + bookingId + " cancelled successfully.");
        } else {
            System.out.println(" Booking ID not found.");
        }
    }
}
