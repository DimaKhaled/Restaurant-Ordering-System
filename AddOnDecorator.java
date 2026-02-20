// Abstract decorator class for adding extra features (add-ons) to menu items
public abstract class AddOnDecorator extends MenuItem {
    protected MenuItem wrappedItem;

    public AddOnDecorator(MenuItem item) {
        super(item.getName(), item.getPrice());
        this.wrappedItem = item;
    }

    @Override
    public abstract double getPrice();

    @Override
    public abstract String getDescription();
}
