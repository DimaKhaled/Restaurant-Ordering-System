// Factory for non-vegetarian menu items
public class NonVegMenuFactory implements MenuFactory {

    @Override
    public Pizza createPizza(String type) {
        switch (type) {
            case "Pepperoni": return new PepperoniPizza();
            default: return null;
        }
    }

    @Override
    public Burger createBurger(String type) {
        switch (type) {
            case "Zinger": return new ZingerBurger();
            default: return null;
        }
    }

    @Override
    public Drink createDrink(String type) {
        switch (type) {
            case "Cola": return new Cola();
            default: return null;
        }
    }
}
