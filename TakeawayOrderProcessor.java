// Processor for takeaway orders, applies packaging tax
public class TakeawayOrderProcessor extends OrderProcessor {
    public TakeawayOrderProcessor(BillingService b, DiscountManger d){
        super(b, d);
    }
    @Override
    public double applyTaxes(double discount) {
        double packaging = discount + (discount * 0.05);
        return packaging;
    }
}