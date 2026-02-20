// Concrete add-on that adds garlic sauce to a menu item
public class GarlicSauce extends AddOnDecorator {
    private double addonPrice = 30.0;

    public GarlicSauce(MenuItem item) { super(item); }

    @Override
    public double getPrice() { return wrappedItem.getPrice() + addonPrice; }

    @Override
    public String getDescription() { 
        return wrappedItem.getDescription() + " + Garlic Sauce"; 
    }
}
