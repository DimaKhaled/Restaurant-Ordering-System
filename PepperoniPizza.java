public class PepperoniPizza extends Pizza {
    public PepperoniPizza() { super("Pepperoni Pizza", 250.0); }
    @Override
    public String getDescription() { return name; }
}