package service;

import model.Flight;
import model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class SearchService {

    public List<Flight> searchFlights(List<Flight> flights, String source, String destination) {
        List<Flight> results = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getSource().equalsIgnoreCase(source) &&
                    flight.getDestination().equalsIgnoreCase(destination)) {
                results.add(flight);
            }
        }
        return results;
    }

    public List<Hotel> searchHotelsByLocation(List<Hotel> hotels, String location) {
        List<Hotel> results = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (hotel.getLocation().equalsIgnoreCase(location)) {
                results.add(hotel);
            }
        }
        return results;
    }

    public Hotel searchHotelByName(List<Hotel> hotels, String name) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equalsIgnoreCase(name)) {
                return hotel;
            }
        }
        return null; // not found
    }

    public Flight searchFlightByNumber(List<Flight> flights, String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                return flight;
            }
        }
        return null;
    }
}
