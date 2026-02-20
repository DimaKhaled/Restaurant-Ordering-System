public class MeatDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(Order item) {
        double total = item.getTotal();
        if (total > 100.0) {
            double discountAmount = total * 0.30;
            return total - discountAmount;
        }
        return total;
    }
}