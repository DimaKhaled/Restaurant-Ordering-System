// Processor for delivery orders, adds flat delivery fee
public class DeliveryOrderProcessor extends OrderProcessor {
    public DeliveryOrderProcessor(BillingService b, DiscountManger d){
        super(b, d);
    }

    @Override
    public double applyTaxes(double discount) {
        double tax = discount + 75.0; 
        return tax;
    }
}