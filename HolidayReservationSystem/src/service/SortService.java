package service;

import model.Flight;
import model.Hotel;

import java.util.List;

public class SortService {

    // Sort flights by price (ascending)
    public void sortFlightsByPrice(List<Flight> flights) {
        int n = flights.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (flights.get(j).getPrice() > flights.get(j + 1).getPrice()) {
                    // swap
                    Flight temp = flights.get(j);
                    flights.set(j, flights.get(j + 1));
                    flights.set(j + 1, temp);
                }
            }
        }
    }

    // Sort hotels by rating (descending)
    public void sortHotelsByRating(List<Hotel> hotels) {
        int n = hotels.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (hotels.get(j).getRating() < hotels.get(j + 1).getRating()) {
                    Hotel temp = hotels.get(j);
                    hotels.set(j, hotels.get(j + 1));
                    hotels.set(j + 1, temp);
                }
            }
        }
    }

    // Sort hotels by price (ascending)
    public void sortHotelsByPrice(List<Hotel> hotels) {
        int n = hotels.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (hotels.get(j).getPricePerNight() > hotels.get(j + 1).getPricePerNight()) {
                    Hotel temp = hotels.get(j);
                    hotels.set(j, hotels.get(j + 1));
                    hotels.set(j + 1, temp);
                }
            }
        }
    }
}
