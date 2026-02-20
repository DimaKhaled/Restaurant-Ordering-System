public class NoDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(Order item) {
        System.out.println("No discount applied.");
        return item.getTotal();
    }
}