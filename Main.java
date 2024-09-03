import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TrainBookingSystem system = new TrainBookingSystem();
        system.setupDemoData(); // Initialize demo data

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nTrain Ticket Booking System");
            System.out.println("1. Display Available Trains");
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
}
