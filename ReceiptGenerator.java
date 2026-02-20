import java.util.*;
// Generates and prints a detailed order receipt
public class ReceiptGenerator {    
    public String generateReceipt(BillingService bs, DiscountManger dm, double totalAfterTax, Order order) {

        double originalTotal = order.getTotal();
        double discountedTotal = dm.calculateDiscount(order);
        double discountAmount = originalTotal - discountedTotal;

        StringBuilder sb = new StringBuilder();

        sb.append("\n========================================\n");
        sb.append("            RESTAURANT RECEIPT\n");
        sb.append("========================================\n");
        String dateTime = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        sb.append("Order ID      : ").append(order.getOrderById()).append("\n");
        sb.append("Order Type    : ").append(order.getOrderType()).append("\n");
        sb.append("Date & Time   : ").append(dateTime).append("\n");
        sb.append("----------------------------------------\n\n");

        sb.append("Items:\n");
        for (OrderItem oi : order.getItems()) {
            MenuItem item = oi.getMenuItem();

            sb.append("-> ").append(item.getName())
            .append("   x").append(oi.getQuantity())
            .append("   = ").append(String.format("%.2f", oi.getSubtotal()))
            .append(" L.E\n");

            // Print AddOns
            List<String> addons = extractAddons(item);
            for (String ad : addons) {
                sb.append("     -> + ").append(ad).append("\n");
            }
        }

        sb.append("\n----------------------------------------\n");
        sb.append(String.format("Subtotal          : %.2f L.E\n", originalTotal));

        if (discountAmount > 0) {
            sb.append(String.format("Discount Applied  : -%.2f L.E\n", discountAmount));
        } else {
            sb.append("Discount Applied  : None\n");
        }

        double taxAmount = totalAfterTax - discountedTotal;
        sb.append(String.format("Taxes & Fees      : %.2f L.E\n", taxAmount));

        sb.append("----------------------------------------\n");
        sb.append(String.format("TOTAL             : %.2f L.E\n", totalAfterTax));
        PaymentStrategy strategy = bs.getPaymentStrategy();
        String paymentMethod = (strategy != null) ? strategy.getClass().getSimpleName() : "Not Paid";
        sb.append("Payment Method    : ").append(paymentMethod).append("\n");

        sb.append("========================================\n");
        sb.append("           THANK YOU  COME AGAIN!\n");
        sb.append("========================================\n");

        return sb.toString();
    }


    public void printReceipt(String receipt) {
        System.out.println(receipt);
    }

    private List<String> extractAddons(MenuItem item) {
        List<String> addons = new ArrayList<>();
        while (item instanceof AddOnDecorator) {
            AddOnDecorator addon = (AddOnDecorator) item;
            String name = addon.getDescription().replace(addon.wrappedItem.getDescription(), "").trim();
            if (name.startsWith("+")) addons.add(name.substring(1).trim());
            item = addon.wrappedItem;
        }
        return addons;
    }

}
