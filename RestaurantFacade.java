// Facade to simplify restaurant operations (ordering, menu creation, processing)
public class RestaurantFacade {
    public Order currentOrder;
    public MenuFactory menuFactory;
    OrderProcessor processor = null;

    public BillingService billingService;
    public DiscountManger discountManager;

    public RestaurantFacade(MenuFactory factory) {
        this.menuFactory = factory;
        this.billingService = new BillingService();
        this.discountManager = new DiscountManger();
    }

    public void createOrder(OrderType type) {
        currentOrder = new Order(type);
    }

    public void addItem(MenuItem item, int quantity) {
        if (currentOrder != null) currentOrder.addItem(item, quantity);
    }

    public void addAddonToItem(MenuItem targetItem, AddOnDecorator addon) {
        if (currentOrder != null) {
            currentOrder.addAddonToItem(targetItem, addon);
        }
    }

    public void submitOrder() {
        if (currentOrder != null) currentOrder.submitOrder();
    }

    public void processOrder(Order order, OrderType type) {

        switch (type) {
            case DINE_IN:
                processor = new DineInOrderProcessor(billingService, discountManager);
                break;

            case TAKEAWAY:
                processor = new TakeawayOrderProcessor(billingService, discountManager);
                break;

            case DELIVERY:
                processor = new DeliveryOrderProcessor(billingService, discountManager);
                break;
        }
        processor.setReceiptGenerator(new ReceiptGenerator());
        processor.processOrder(order);   
    }
}

