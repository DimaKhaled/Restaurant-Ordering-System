public class CreditCardPayment implements PaymentStrategy {
    // private String cardNumber;
    public CreditCardPayment(String cardNumber) {
        // this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        return true;
    }
}