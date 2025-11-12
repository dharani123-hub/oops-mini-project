Skip to content
Navigation Menu
dharani123-hub
oops-mini-project

Code
Issues
Pull requests
Actions
Projects
Wiki
Security
Commit d7b3008
dharani123-hub
dharani123-hub
authored
yesterday
Verified
Add files via upload
main
0 parents  commit 
d7b3008
11 files changed
+150
-0
lines changed
Search within code
 
‎CarRentalProject/Car.class‎
1.16 KB
Binary file not shown.
‎CarRentalProject/Car.java‎
Original file line number	Diff line number	Diff line change
@@ -0,0 +1,34 @@
// File: Car.java
class Car {
    String carId, model;
    double ratePerDay;
    boolean available;
    Car(String carId, String model, double ratePerDay) {
        this.carId = carId;
        this.model = model;
        this.ratePerDay = ratePerDay;
        this.available = true;
    }
    double calculateRentalCost(int days) {
        return ratePerDay * days;
    }
    void display() {
        System.out.println("Car ID: " + carId + ", Model: " + model + ", Rate per day: " + ratePerDay);
    }
}
// Subclass for Luxury Cars
class LuxuryCar extends Car {
    double luxuryTax = 500;
    LuxuryCar(String carId, String model, double ratePerDay) {
        super(carId, model, ratePerDay);
    }
    double calculateRentalCost(int days) {
        return super.calculateRentalCost(days) + luxuryTax;
    }
}
‎CarRentalProject/CarRentalSystem.class‎
2.66 KB
Binary file not shown.
‎CarRentalProject/CarRentalSystem.java‎
Original file line number	Diff line number	Diff line change
@@ -0,0 +1,60 @@
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
‎CarRentalProject/Customer.class‎
1.08 KB
Binary file not shown.
‎CarRentalProject/Customer.java‎
Original file line number	Diff line number	Diff line change
@@ -0,0 +1,14 @@
// File: Customer.java
class Customer {
    String customerId, name, phone;
    Customer(String customerId, String name, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
    }
    void display() {
        System.out.println("Customer ID: " + customerId + ", Name: " + name + ", Phone: " + phone);
    }
}
‎CarRentalProject/DataHandler.class‎
2.09 KB
Binary file not shown.
‎CarRentalProject/DataHandler.java‎
Original file line number	Diff line number	Diff line change
@@ -0,0 +1,33 @@
// File: DataHandler.java
import java.io.*;
import java.util.*;
class DataHandler {
    // Save cars to file
    static void saveCars(List<Car> cars) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cars.dat"))) {
            oos.writeObject(new ArrayList<>(cars));
            System.out.println("Cars saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving cars: " + e.getMessage());
        }
    }
    // Load cars from file
    @SuppressWarnings("unchecked") // ✅ Removes warning safely
    static List<Car> loadCars() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cars.dat"))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                return (List<Car>) obj;
            } else {
                return new ArrayList<>();
            }
        } catch (Exception e) {
            System.out.println("No saved cars found. Starting fresh.");
            return new ArrayList<>();
        }
    }
}
‎CarRentalProject/LuxuryCar.class‎
359 Bytes
Binary file not shown.
‎CarRentalProject/PaymentProcessor.class‎
952 Bytes
Binary file not shown.
‎CarRentalProject/paymentProcessor.java‎
Original file line number	Diff line number	Diff line change
@@ -0,0 +1,9 @@
// File: PaymentProcessor.java
class PaymentProcessor {
    boolean processPayment(String customerName, double amount) {
        System.out.println("Processing payment for " + customerName + " of ₹" + amount);
        System.out.println("Payment Successful!");
        return true;
    }
}
0 commit comments
Comments
0
 (0)
Comment
You're not receiving notifications from this thread.

Add files via upload · dharani123-hub/oops-mini-project@d7b3008
