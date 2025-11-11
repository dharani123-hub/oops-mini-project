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
