// Concrete payment strategies
public class CashPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        return true;
    }
}