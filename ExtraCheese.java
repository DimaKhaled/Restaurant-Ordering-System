// Concrete add-on that adds extra cheese to a menu item
public class ExtraCheese extends AddOnDecorator {
    private double addonPrice = 35.0;

    public ExtraCheese(MenuItem item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return wrappedItem.getPrice() + addonPrice;
    }

    @Override
    public String getDescription() {
        return wrappedItem.getDescription() + " + Extra Cheese";
    }
}
