// Concrete add-on that adds spicy sauce to a menu item
class SpicySauce extends AddOnDecorator {
    private double addonPrice = 15.0;

    public SpicySauce(MenuItem item) { super(item); }

    @Override
    public double getPrice() { return wrappedItem.getPrice() + addonPrice; }

    @Override
    public String getDescription() { 
        return wrappedItem.getDescription() + " + Spicy Sauce"; 
    }
}