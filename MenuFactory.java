// Abstract Factory interface for creating menu items based on dietary type
public interface MenuFactory {
    Pizza createPizza(String type);
    Burger createBurger(String type);
    Drink createDrink(String type);
}