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
