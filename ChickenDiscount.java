// Concrete discount strategies
public class ChickenDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(Order item) {
        double total = item.getTotal();
        if (total > 20.0) {
            double discountAmount = total * 0.10;
            return total - discountAmount;
        }
        return total;
    }
}