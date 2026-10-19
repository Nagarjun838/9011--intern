
    

import java.util.Scanner;

public class CabBookingChatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== CAB BOOKING CHATBOT =====");
            System.out.println("1. Book Ride");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            if (choice == 2) {
                System.out.println("Thank you for using our cab service!");
                break;
            }

            if (choice != 1) {
                System.out.println("Invalid menu choice!");
                continue;
            }

            System.out.println("\nChoose Cab Type:");
            System.out.println("1. Auto - Rs.12/km");
            System.out.println("2. Sedan - Rs.18/km");
            System.out.println("3. SUV - Rs.25/km");
            System.out.print("Enter cab choice: ");

            int cabChoice = sc.nextInt();

            String cabType;
            int rate;

            if (cabChoice == 1) {
                cabType = "Auto";
                rate = 12;
            } else if (cabChoice == 2) {
                cabType = "Sedan";
                rate = 18;
            } else if (cabChoice == 3) {
                cabType = "SUV";
                rate = 25;
            } else {
                System.out.println("Invalid cab choice!");
                continue;
            }

            System.out.println("\nChoose Pickup Location:");
            System.out.println("1. Pune Station");
            System.out.println("2. Swargate");
            System.out.println("3. Hinjawadi");
            System.out.print("Enter pickup choice: ");

            int pickupChoice = sc.nextInt();

            String source;

            if (pickupChoice == 1) {
                source = "Pune Station";
            } else if (pickupChoice == 2) {
                source = "Swargate";
            } else if (pickupChoice == 3) {
                source = "Hinjawadi";
            } else {
                System.out.println("Invalid pickup choice!");
                continue;
            }

            System.out.println("\nChoose Destination:");
            System.out.println("1. Shivajinagar - 5 km");
            System.out.println("2. Kothrud - 8 km");
            System.out.println("3. Wakad - 10 km");
            System.out.print("Enter destination choice: ");

            int destinationChoice = sc.nextInt();

            String destination;
            int distance;

            if (destinationChoice == 1) {
                destination = "Shivajinagar";
                distance = 5;
            } else if (destinationChoice == 2) {
                destination = "Kothrud";
                distance = 8;
            } else if (destinationChoice == 3) {
                destination = "Wakad";
                distance = 10;
            } else {
                System.out.println("Invalid destination choice!");
                continue;
            }

            int fare = rate * distance;

            System.out.println("\n===== RIDE DETAILS =====");
            System.out.println("Cab Type: " + cabType);
            System.out.println("Source: " + source);
            System.out.println("Destination: " + destination);
            System.out.println("Distance: " + distance + " km");
            System.out.println("Rate: Rs." + rate + "/km");
            System.out.println("Total Fare: Rs." + fare);

            System.out.println("\n1. Confirm & Share OTP");
            System.out.println("2. Cancel Ride");
            System.out.print("Enter your choice: ");

            int confirmChoice = sc.nextInt();

            if (confirmChoice == 2) {
                System.out.println("Ride cancelled before OTP sharing.");
                continue;
            } else if (confirmChoice == 1) {
                int otp = 1000 + (int)(Math.random() * 9000);

                System.out.println("Your OTP is: " + otp);
                System.out.println("OTP shared successfully.");
                System.out.println("Ride cannot be cancelled after OTP sharing.");
                System.out.println("Cab booking confirmed!");
            } else {
                System.out.println("Invalid confirmation choice!");
                continue;
            }

            System.out.println("Returning to main menu...");
        }

        sc.close();
    }
}
