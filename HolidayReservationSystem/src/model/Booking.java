package model;

import java.time.LocalDate;

public class Booking {
    private static int idCounter = 1;

    private int bookingId;
    private String username;
    private String bookingType; // "flight" or "hotel"
    private String bookingDetails;
    private LocalDate bookingDate;

    public Booking(String username, String bookingType, String bookingDetails, LocalDate bookingDate) {
        this.bookingId = idCounter++;
        this.username = username;
        this.bookingType = bookingType;
        this.bookingDetails = bookingDetails;
        this.bookingDate = bookingDate;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getUsername() {
        return username;
    }

    public String getBookingType() {
        return bookingType;
    }

    public String getBookingDetails() {
        return bookingDetails;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId +
                "\nUser: " + username +
                "\nType: " + bookingType +
                "\nDetails: " + bookingDetails +
                "\nDate: " + bookingDate;
    }
}
