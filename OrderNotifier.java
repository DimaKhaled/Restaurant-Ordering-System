import java.util.*;
// Notifier that keeps track of observers and notifies them about order events
public class OrderNotifier {
    private List<ObserverSystem> observers = new ArrayList<>();

    public void registerObserver(ObserverSystem observer) { observers.add(observer); }
    public void removeObserver(ObserverSystem observer) { observers.remove(observer); }

    public void notifyObservers(Order order) {
        for (ObserverSystem observer : observers) {
            observer.update(order);
        }
    }
}
