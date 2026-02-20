class CheeseBurger extends Burger {
    public CheeseBurger() { super("Cheese Burger", 250.0); }
    @Override
    public String getDescription() { return name; }
}