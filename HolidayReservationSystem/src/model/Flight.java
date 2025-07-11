package model;

public class Flight {
    private String flightNumber;
    private String source;
    private String destination;
    private String date; // format: YYYY-MM-DD
    private String time; // format: HH:MM
    private double price;

    public Flight(String flightNumber, String source, String destination, String date, String time, double price) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.price = price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Flight No: " + flightNumber +
                "\nFrom: " + source +
                "\nTo: " + destination +
                "\nDate: " + date +
                "\nTime: " + time +
                "\nPrice: ₹" + price;
    }
}
