// Concrete Pizza variants
public class ItalianPizza extends Pizza {
    public ItalianPizza() { super("Italian Pizza", 220.0); }
    @Override
    public String getDescription() { return name; }
}