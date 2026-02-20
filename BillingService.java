// Handles payment processing using different strategies
public class BillingService {

    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public PaymentStrategy getPaymentStrategy() {
        return strategy;
    }


    public boolean processPayment(double amount, Order order){

        if (strategy == null) {
            System.out.println("Error: No payment strategy set!");
            return false;
        }
        boolean success = strategy.pay(amount);
        
        return success;
    }
}