public class MobileWallet implements PaymentStrategy{
    // private String phoneNumber;
    public MobileWallet(String phoneNumber) {
        // this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean pay(double amount) {
        return true;
    }
}