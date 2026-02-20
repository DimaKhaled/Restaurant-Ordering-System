// Concrete Burger variants
class ClassicBurger extends Burger {
    public ClassicBurger() { super("Classic Burger", 220.0); }
    @Override
    public String getDescription() { return name; }
}