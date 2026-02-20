// Manages discount strategies for orders
public class DiscountManger {
    private DiscountStrategy strategy = new NoDiscount();
    public void setStrategy(DiscountStrategy s){ strategy = s; }
    public double calculateDiscount(Order item){
        return strategy.applyDiscount(item); }
}