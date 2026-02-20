// Concrete Drink variants
class Juice extends Drink {
    public Juice() { super("Juice", 75.0); }
    @Override
    public String getDescription() { return name; }
}