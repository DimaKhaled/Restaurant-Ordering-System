// Represents an individual order item with quantity
class OrderItem {
    private MenuItem item;
    private int quantity;

    public OrderItem(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double getSubtotal() { return item.getPrice() * quantity; }

    public String getDescription() { return item.getDescription(); }

    public MenuItem getMenuItem() { return item; }

    public int getQuantity() { return quantity; }

    public void setMenuItem(MenuItem menuItem) { this.item = menuItem; }
}