import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 1. Abstraction & Inheritance: Abstract Passenger class
abstract class Passenger {
    private String name;
    private int age;

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Abstract method to enforce discount contract
    public abstract double getDiscountPercentage();
}

class RegularPassenger extends Passenger {
    public RegularPassenger(String name, int age) {
        super(name, age);
    }

    @Override
    public double getDiscountPercentage() {
        return 0.0; // 0% discount[cite: 3]
    }
}

class StudentPassenger extends Passenger {
    public StudentPassenger(String name, int age) {
        super(name, age);
    }

    @Override
    public double getDiscountPercentage() {
        return 0.10; // 10% discount[cite: 3]
    }
}

// 2. Flight Class (Encapsulation)
class Flight {
    private String code;
    private String airline;
    private String source;
    private String destination;
    private int availableSeats;
    private double baseFare;

    public Flight(String code, String airline, String source, String destination, int availableSeats, double baseFare) {
        this.code = code;
        this.airline = airline;
        this.source = source;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.baseFare = baseFare;
    }

    public String getCode() { return code; }
    public String getAirline() { return airline; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public int getAvailableSeats() { return availableSeats; }
    public double getBaseFare() { return baseFare; }

    public void bookSeats(int count) {
        this.availableSeats -= count; // Controlled modification
    }
}

// 3. Booking Class
class Booking {
    private String bookingId;
    private Flight flight;
    private Passenger passenger;
    private int tickets;
    private double subtotal;
    private double discount;
    private double finalAmount;

    public Booking(String bookingId, Flight flight, Passenger passenger, int tickets, double subtotal, double discount, double finalAmount) {
        this.bookingId = bookingId;
        this.flight = flight;
        this.passenger = passenger;
        this.tickets = tickets;
        this.subtotal = subtotal;
        this.discount = discount;
        this.finalAmount = finalAmount;
    }

    public void displaySummary() {
        String passengerTypeStr = (passenger instanceof StudentPassenger) ? "Student" : "Regular";
        System.out.println("\nBooking confirmed!");
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Flight: " + flight.getCode() + " | " + flight.getSource() + " to " + flight.getDestination());
        System.out.println("Passenger: " + passenger.getName());
        System.out.println("Passenger type: " + passengerTypeStr);
        System.out.println("Tickets: " + tickets);
        System.out.printf("Base fare per ticket: %,.0f%n", flight.getBaseFare());
        System.out.printf("Subtotal: %,.0f%n", subtotal);
        int discountPercentInt = (int) (passenger.getDiscountPercentage() * 100);
        System.out.printf("%s discount (%d%%): %,.0f%n", passengerTypeStr, discountPercentInt, discount);
        System.out.printf("Final amount: %,.0f%n\n", finalAmount);
    }
}

// 4. Main System Class
public class 1 {
    private List<Flight> flights;
    private Booking latestBooking;
    private int bookingCounter;
    private Scanner scanner;

    public FlightBookingSystem() {
        flights = new ArrayList<>();
        // Predefined flights[cite: 3]
        flights.add(new Flight("PN101", "Kiran Air", "Pune", "Delhi", 50, 4000));
        flights.add(new Flight("MB202", "Kiran Air", "Mumbai", "Bengaluru", 40, 4500));
        flights.add(new Flight("PH303", "Kiran Air", "Pune", "Hyderabad", 30, 3500));
        latestBooking = null;
        bookingCounter = 1000;
        scanner = new Scanner(System.in);
    }

    public void viewFlights() {
        System.out.println("\n--- Available Flights ---");
        System.out.printf("%-8s %-12s %-22s %-8s %-10s%n", "Code", "Airline", "Route", "Seats", "Base Fare");
        System.out.println("--------------------------------------------------------------");
        for (Flight f : flights) {
            String route = f.getSource() + " -> " + f.getDestination();
            System.out.printf("%-8s %-12s %-22s %-8d %,.0f%n", f.getCode(), f.getAirline(), route, f.getAvailableSeats(), f.getBaseFare());
        }
        System.out.println();
    }

    public Flight findFlight(String code) {
        for (Flight f : flights) {
            if (f.getCode().equalsIgnoreCase(code)) {
                return f;
            }
        }
        return null;
    }

    public void bookFlight() {
        System.out.println("\n--- Book Flight ---");
        System.out.print("Enter flight code: ");
        String code = scanner.nextLine().trim();
        Flight flight = findFlight(code);
        if (flight == null) {
            System.out.println("Booking failed: Flight code does not exist.");
            return;
        }

        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Booking failed: Passenger name cannot be blank[cite: 3].");
            return;
        }

        int age = 0;
        try {
            System.out.print("Enter age: ");
            age = Integer.parseInt(scanner.nextLine().trim());
            if (age <= 0) {
                System.out.println("Booking failed: Age must be greater than 0[cite: 3].");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Booking failed: Invalid age input.");
            return;
        }

        System.out.print("Passenger type (Regular/Student): ");
        String pType = scanner.nextLine().trim();
        Passenger passenger;
        if (pType.equalsIgnoreCase("Student")) {
            passenger = new StudentPassenger(name, age);
        } else if (pType.equalsIgnoreCase("Regular")) {
            passenger = new RegularPassenger(name, age);
        } else {
            System.out.println("Booking failed: Invalid passenger type. Choose Regular or Student.");
            return;
        }

        int tickets = 0;
        try {
            System.out.print("Enter number of tickets: ");
            tickets = Integer.parseInt(scanner.nextLine().trim());
            if (tickets <= 0) {
                System.out.println("Booking failed: Ticket count must be greater than 0[cite: 3].");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Booking failed: Invalid ticket count input.");
            return;
        }

        if (tickets > flight.getAvailableSeats()) {
            System.out.println("Booking failed: Not enough seats available[cite: 3].");
            System.out.println("No booking was created. Available seats remain unchanged[cite: 3].");
            return;
        }

        // Fare Calculation using polymorphism for discount rate[cite: 2, 3]
        double subtotal = flight.getBaseFare() * tickets;
        double discountRate = passenger.getDiscountPercentage();
        double discount = subtotal * discountRate;
        double finalAmount = subtotal - discount;

        // Update seats and save booking[cite: 3]
        flight.bookSeats(tickets);
        bookingCounter++;
        String bookingId = "BK" + bookingCounter;

        latestBooking = new Booking(bookingId, flight, passenger, tickets, subtotal, discount, finalAmount);
        latestBooking.displaySummary();
    }

    public void viewBooking() {
        if (latestBooking == null) {
            System.out.println("\nNo booking exists yet[cite: 1].\n");
        } else {
            latestBooking.displaySummary();
        }
    }

    public void run() {
        System.out.println("Welcome to Kiran Air Booking");
        while (true) {
            System.out.println("1. View Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. View Booking");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                viewFlights();
            } else if (choice.equals("2")) {
                bookFlight();
            } else if (choice.equals("3")) {
                viewBooking();
            } else if (choice.equals("4")) {
                System.out.println("Thank you for using Kiran Air Booking!");
                break;
            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and 4.\n");
            }
        }
    }

    public static void main(String[] args) {
        FlightBookingSystem system = new FlightBookingSystem();
        system.run();
    }
}