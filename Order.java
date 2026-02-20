import java.util.*;

// Represents a customer order, which can include multiple items
public class Order {
    private static int nextId = 1;
    private int orderId;
    private List<OrderItem> items;
    private OrderType orderType;
    private OrderNotifier notifier;

    public Order(OrderType type) {
        this.orderId = nextId++;
        this.orderType = type;
        this.items = new ArrayList<>();
        this.notifier = new OrderNotifier();
    }

    public void addItem(MenuItem item, int quantity) {
        items.add(new OrderItem(item, quantity));
    }

    // Applies an add-on to an existing item in the order
    public void addAddonToItem(MenuItem targetItem, AddOnDecorator addon) {
        for (OrderItem orderItem : items) {

            String baseName = orderItem.getMenuItem().getName();
            String targetBase = targetItem.getName();

            if (baseName.equals(targetBase)) {

                MenuItem currentItem = orderItem.getMenuItem();

                AddOnDecorator newAddon = null;
                try {
                    newAddon = addon.getClass().getConstructor(MenuItem.class).newInstance(currentItem);
                } 
                catch (Exception e) {
                    e.printStackTrace();
                    return;
                }

                orderItem.setMenuItem(newAddon);
                return;
            }
        }

        System.out.println("Item not found in order!");
    }

    public List<OrderItem> getItems() { return items; }

    public OrderType getOrderType() { return orderType; }

    public int getOrderById() { return orderId; }

     public double getTotal(){
        double t = 0;
        for(OrderItem it: items) t += it.getSubtotal();
        return t;
    }

    // Notifies observers when the order is submitted
    public void submitOrder() {
        System.out.println("\nOrder " + orderId + " submitted:");
        
        notifier.registerObserver(new KitchenObserver());
        notifier.registerObserver(new WaiterObserver());

        notifier.notifyObservers(this);
    }
}

