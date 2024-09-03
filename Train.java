import java.util.ArrayList;
import java.util.List;

public class Train {
    private int trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private final int totalSeats; // Fixed total seats
    private ArrayList<Integer> bookedSeats; // List to keep track of booked seats

    public Train(int trainNumber, String trainName, String source, String destination, int totalSeats) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats; // Initialize fixed total seats
        this.bookedSeats = new ArrayList<>();
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public List<Integer> getAvailableSeats() {
        List<Integer> availableSeats = new ArrayList<>();
        for (int i = 1; i <= totalSeats; i++) {
            if (!bookedSeats.contains(i)) {
                availableSeats.add(i);
            }
        }
        return availableSeats;
    }

    public boolean bookSeat(int seatNumber) {
        if (seatNumber >= 1 && seatNumber <= totalSeats && !bookedSeats.contains(seatNumber)) {
            bookedSeats.add(seatNumber);
            return true;
        }
        return false;
    }

    public void cancelSeat(int seatNumber) {
        if (bookedSeats.contains(seatNumber)) {
            bookedSeats.remove(Integer.valueOf(seatNumber));
        }
    }

    public void displayTrainDetails() {
        System.out.println("Train Number: " + trainNumber);
        System.out.println("Train Name: " + trainName);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("Total Seats: " + totalSeats);
    }
}
