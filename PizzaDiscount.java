public class PizzaDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(Order item) {
        double total = item.getTotal();
        if (total > 50.0) {
            double discountAmount = total * 0.20;
            return total - discountAmount;
        }
        return total;
    }
}
