public class EasternPizza extends Pizza {
    public EasternPizza() { super("Eastern Pizza", 200.0); }
    @Override
    public String getDescription() { return name; }
}