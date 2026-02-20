// Processor for dine-in orders, applies percentage tax
public class DineInOrderProcessor extends OrderProcessor {
    public DineInOrderProcessor(BillingService b, DiscountManger d){
        super(b, d);
    }

    @Override
    public double  applyTaxes(double discount) {
        double tax = discount + (discount * 0.14); 
        return tax;
    }
}