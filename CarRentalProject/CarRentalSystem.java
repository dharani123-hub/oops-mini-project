// File: CarRentalSystem.java
import java.util.*;

public class CarRentalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        PaymentProcessor payment = new PaymentProcessor();

        // --- Add sample cars ---
        cars.add(new Car("C101", "Swift", 1500));
        cars.add(new LuxuryCar("L202", "BMW X5", 5000));

        System.out.println("=======================================");
        System.out.println("       Welcome to Car Rental System    ");
        System.out.println("=======================================");
        System.out.println("\nAvailable Cars:");
        for (Car c : cars) {
            c.display();
        }

        // --- Customer input section ---
        System.out.print("\nEnter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        // Create and display customer info
        Customer customer = new Customer("CU1", name, phone);
        System.out.println("\nCustomer Details:");
        customer.display();

        // --- Select car and rental days ---
        System.out.print("\nEnter Car ID to rent: ");
        String cid = sc.nextLine();
        System.out.print("Enter number of rental days: ");
        int days = sc.nextInt();

        boolean found = false;

        for (Car c : cars) {
            if (c.carId.equalsIgnoreCase(cid)) {
                found = true;
                double cost = c.calculateRentalCost(days);
                System.out.println("\nTotal Rental Cost: ₹" + cost);
                payment.processPayment(customer.name, cost);
                System.out.println("✅ Car rented successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("\n❌ Invalid Car ID! Please try again.");
        }

        sc.close();
    }
}


