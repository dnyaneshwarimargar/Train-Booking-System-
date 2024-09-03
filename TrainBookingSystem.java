import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainBookingSystem {
    private ArrayList<Train> trains = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addTrain(Train train) {
        trains.add(train);
    }

    public void displayAvailableSeats() {
        System.out.println("Available Seats:");
        for (Train train : trains) {
            System.out.println("Train Number: " + train.getTrainNumber() + ", Train Name: " + train.getTrainName());
            List<Integer> availableSeats = train.getAvailableSeats();
            if (availableSeats.isEmpty()) {
                System.out.println("No seats available for this train.");
            } else {
                System.out.println("Available Seats: " + availableSeats);
            }
            System.out.println("------------------------------------");
        }
    }

    public Train findTrainByNumber(int trainNumber) {
        for (Train train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                return train;
            }
        }
        return null;
    }

    public void bookSeat() {
        System.out.println("Enter Train Number to book a seat:");
        int trainNumber = scanner.nextInt();
        Train train = findTrainByNumber(trainNumber);

        if (train != null) {
            List<Integer> availableSeats = train.getAvailableSeats();
            if (!availableSeats.isEmpty()) {
                System.out.println("Available Seats: " + availableSeats);
                System.out.println("Enter Seat Number:");
                int seatNumber = scanner.nextInt();
                if (train.bookSeat(seatNumber)) {
                    scanner.nextLine(); // consume newline
                    System.out.println("Enter Passenger Name:");
                    String passengerName = scanner.nextLine();
                    Booking booking = new Booking(passengerName, trainNumber, seatNumber);
                    bookings.add(booking);
                    System.out.println("Seat booked successfully!");
                } else {
                    System.out.println("Invalid seat number or seat already booked.");
                }
            } else {
                System.out.println("No seats available for this train.");
            }
        } else {
            System.out.println("Train not found.");
        }
    }

    public void cancelBooking() {
        System.out.println("Enter Train Number:");
        int trainNumber = scanner.nextInt();
        System.out.println("Enter Seat Number:");
        int seatNumber = scanner.nextInt();

        Booking bookingToRemove = null;
        for (Booking booking : bookings) {
            if (booking.getTrainNumber() == trainNumber && booking.getSeatNumber() == seatNumber) {
                bookingToRemove = booking;
                break;
            }
        }

        if (bookingToRemove != null) {
            bookings.remove(bookingToRemove);
            Train train = findTrainByNumber(trainNumber);
            if (train != null) {
                train.cancelSeat(seatNumber);
                System.out.println("Booking cancelled successfully.");
            } else {
                System.out.println("Train not found.");
            }
        } else {
            System.out.println("Booking not found.");
        }
    }

    public void printTicket() {
        System.out.println("Enter Train Number:");
        int trainNumber = scanner.nextInt();
        System.out.println("Enter Seat Number:");
        int seatNumber = scanner.nextInt();

        Booking bookingToPrint = null;
        for (Booking booking : bookings) {
            if (booking.getTrainNumber() == trainNumber && booking.getSeatNumber() == seatNumber) {
                bookingToPrint = booking;
                break;
            }
        }

        if (bookingToPrint != null) {
            System.out.println("Ticket Details:");
            bookingToPrint.displayBookingDetails();
            Train train = findTrainByNumber(trainNumber);
            if (train != null) {
                System.out.println("Train Name: " + train.getTrainName());
                System.out.println("Source: " + train.getSource());
                System.out.println("Destination: " + train.getDestination());
            }
        } else {
            System.out.println("Booking not found.");
        }
    }

    public static void main(String[] args) {
        TrainBookingSystem system = new TrainBookingSystem();
        system.setupDemoData(); // Initialize demo data

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nTrain Ticket Booking System");
            System.out.println("1. Display Available Seats");
            System.out.println("2. Book A Seat");
            System.out.println("3. Cancel A Seat Booking");
            System.out.println("4. Print A Ticket");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.displayAvailableSeats();
                    break;
                case 2:
                    system.bookSeat();
                    break;
                case 3:
                    system.cancelBooking();
                    break;
                case 4:
                    system.printTicket();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }

    public void setupDemoData() {
        Train train1 = new Train(1, "Express 101", "City A", "City B", 50);
        Train train2 = new Train(2, "Local 202", "City C", "City D", 40);
        Train train3 = new Train(3, "Rapid 303", "City E", "City F", 60);

        addTrain(train1);
        addTrain(train2);
        addTrain(train3);
    }
}
