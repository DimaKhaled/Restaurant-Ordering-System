// Factory for kids menu items
public class KidsMenuFactory implements MenuFactory {

    @Override
    public Pizza createPizza(String type) {
        switch (type) {
            case "Kids": return new PepperoniPizza(); 
            default: return null;
        }
    }

    @Override
    public Burger createBurger(String type) {
        switch (type) {
            case "Kids": return new ClassicBurger(); 
            default: return null;
        }
    }

    @Override
    public Drink createDrink(String type) {
        switch (type) {
            case "Kids": return new KidsDrink();
            default: return null;
        }
    }
}
