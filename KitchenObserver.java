// Observer that reacts to order events in the kitchen
public class KitchenObserver implements ObserverSystem {
    @Override
    public void update(Order order) {
        System.out.println("KITCHEN notified of new order with ID : " + order.getOrderById() + " and preparing it.");
    }
}