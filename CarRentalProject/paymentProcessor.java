// File: PaymentProcessor.java
class PaymentProcessor {
    boolean processPayment(String customerName, double amount) {
        System.out.println("Processing payment for " + customerName + " of ₹" + amount);
        System.out.println("Payment Successful!");
        return true;
    }
}

