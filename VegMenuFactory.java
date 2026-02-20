// Factory for vegetarian menu items
public class VegMenuFactory implements MenuFactory {

    @Override
    public Pizza createPizza(String type) {
        switch (type) {
            case "Italian": return new ItalianPizza();
            case "Eastern": return new EasternPizza();
            default: return null;
        }
    }

    @Override
    public Burger createBurger(String type) {
        switch (type) {
            case "Classic": return new ClassicBurger();
            case "Cheese": return new CheeseBurger();
            default: return null;
        }
    }

    @Override
    public Drink createDrink(String type) {
        switch (type) {
            case "Juice": return new Juice();
            default: return null;
        }
    }
}