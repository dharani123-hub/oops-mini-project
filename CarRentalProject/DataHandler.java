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


