public class Booking {
    private String passengerName;
    private int trainNumber;
    private int seatNumber;

    public Booking(String passengerName, int trainNumber, int seatNumber) {
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
        this.seatNumber = seatNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void displayBookingDetails() {
        System.out.println("Passenger Name: " + passengerName);
        System.out.println("Train Number: " + trainNumber);
        System.out.println("Seat Number: " + seatNumber);
    }
}
