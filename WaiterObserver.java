// Observer that reacts to order events for waiter service
public class WaiterObserver implements ObserverSystem {
    @Override
    public void update(Order order) {
        System.out.println("WAITER notified of new order with ID : " + order.getOrderById() + " and waiting to serve it.");
    }
    
}