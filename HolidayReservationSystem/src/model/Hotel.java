package model;

public class Hotel {
    private String name;
    private String location;
    private int rating;
    private double pricePerNight;

    public Hotel(String name, String location, int rating, double pricePerNight) {
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.pricePerNight = pricePerNight;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getRating() {
        return rating;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    @Override
    public String toString() {
        return "Hotel Name: " + name +
                "\nLocation: " + location +
                "\nRating: " + rating + "/5" +
                "\nPrice per Night: ₹" + pricePerNight;
    }
}
