**Train Ticket Booking System**

The Train Ticket Booking System is a Java application designed to facilitate the booking, cancellation, and management of train tickets across multiple trains. 
It provides a user-friendly interface through a console-based menu, allowing users to interactively perform various actions related to booking and managing train seats.

Key Features:

*Display Available Seats*:

Users can view a list of available seats for each train. The system displays the train number, train name, and a list of available seat numbers for each train.

*Book A Seat*:

Users can select a train and choose from the available seats to book a seat. They enter their name and confirm the booking, which updates the system's records.

*Cancel A Seat Booking*:

If a user needs to cancel a booked seat, they can specify the train number and seat number to cancel the booking. The system then frees up the seat for future bookings.

*Print A Ticket*:

Users can print a ticket for a booked seat by entering the train number and seat number. The system retrieves the booking details and prints them along with the train's name, source, and destination.

*Exit Program*:

Users can exit the program when done with their transactions.

Implementation Details:

*Train Class*:

Represents each train with attributes such as train number, name, source, destination, total seats, and booked seats.
Provides methods to get available seats, book a seat, and cancel a booking.

*TrainBookingSystem Class*:

Manages a collection of trains (ArrayList<Train> trains) and bookings (ArrayList<Booking> bookings).
Provides methods to add trains, display available seats, book a seat, cancel a booking, and print a ticket.
Uses a console-based menu system (main() method) to interact with users and handle their requests.

*Booking Class*:

Represents a booking with details including passenger name, train number, and seat number.
Provides methods to display booking details.

Usage:
Setup:

Users run the Main class to start the application.
The system initializes with demo data, including multiple trains with varying numbers of seats.

Interaction:

Users choose options from the menu (1 to 5) to perform actions like viewing available seats, booking a seat, canceling a booking, printing a ticket, or exiting the program.
Each action is validated and processed based on user inputs, ensuring accurate handling of bookings and seat availability.
Flexibility:

The system accommodates changes in seat availability dynamically as bookings are made and canceled.
Users receive feedback on successful actions (e.g., seat booked successfully) or notifications for unsuccessful actions (e.g., no available seats).

*Benefits*:

User-Friendly Interface: Provides a straightforward menu-driven interface for users to manage train bookings easily.
Data Integrity: Ensures accurate tracking of seat availability and bookings across multiple trains.
Scalability: Can be expanded to handle additional features like user authentication, multiple bookings per user, or integration with online payment systems.

The Train Ticket Booking System serves as a practical demonstration of object-oriented programming principles in Java, emphasizing encapsulation, data abstraction, and user interaction through a command-line interface. 
It's suitable for learning purposes or as a foundational module for more complex ticketing systems in Java-based applications.
