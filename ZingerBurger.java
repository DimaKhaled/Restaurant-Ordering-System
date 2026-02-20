public class ZingerBurger extends Burger {
    public ZingerBurger() { super("Zinger Burger", 300.0); }
    @Override
    public String getDescription() { return name; }
}
