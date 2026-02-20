// Abstract processor for handling orders, applying taxes, and integrating billing and receipt
public abstract class OrderProcessor {
    
    public BillingService billing;
    public DiscountManger discount;
    protected ReceiptGenerator receiptGenerator;
    
    public OrderProcessor(){}

    public OrderProcessor(BillingService s, DiscountManger d) {
        this.billing = s;
        this.discount = d;
    }

    public void setReceiptGenerator(ReceiptGenerator rg) {
        this.receiptGenerator = rg;
    }

    public abstract double  applyTaxes (double discount);

    public void processOrder(Order order) {
        double discounts = discount.calculateDiscount(order);
        double taxes = applyTaxes(discounts);
        boolean paid = billing.processPayment(taxes, order);
        if (paid) {
            String receipt = receiptGenerator.generateReceipt(billing, discount, taxes, order);
            receiptGenerator.printReceipt(receipt);
        }
    }
}