import java.util.*;

public class RestaurantApp {

    private static Scanner sc = new Scanner(System.in);
    private static RestaurantFacade facade;
    private static MenuFactory vegFactory = new VegMenuFactory();
    private static MenuFactory nonVegFactory = new NonVegMenuFactory();
    private static MenuFactory kidsFactory = new KidsMenuFactory();

    public static void main(String[] args) {
        System.out.println("\n*************************************************");
        System.out.println("*     WELCOME TO RESTAURANT ORDERING SYSTEM     *");
        System.out.println("*************************************************");

        while (true) {
            System.out.println("\n============================================");
            System.out.println("\t\tMain Menu:");
            System.out.println("============================================");
            System.out.println("[1] Create New Order");
            System.out.println("[2] Exit");
            System.out.print("Choose: ");

            int choice = getValidatedInt(1, 2);

            if (choice == 1) {
                selectDietaryFactory();
                handleNewOrder();
            } 

            else if (choice == 2) break;
        }

        System.out.println("Goodbye!");
    }

    
    // select dietary factory
    private static void selectDietaryFactory() {
        System.out.println("\n============================================");
        System.out.println("\tSelect Dietary Menu Category:");
        System.out.println("============================================");
        System.out.println("[1] Vegetarian");
        System.out.println("[2] Non-Vegetarian");
        System.out.println("[3] Kids");

        System.out.print("Choose: ");
        int choice = getValidatedInt(1, 3);

        if (choice == 1) facade = new RestaurantFacade(vegFactory);
        else if (choice == 2) facade = new RestaurantFacade(nonVegFactory);
        else facade = new RestaurantFacade(kidsFactory);

    }

    // handle new order flow
    private static void handleNewOrder() {
        OrderType type = chooseOrderType();
        facade.createOrder(type);

        boolean ordering = true;

        while (ordering) {
            System.out.println("\n============================================");
            System.out.println("\t\tOrder Menu:");
            System.out.println("============================================");
            System.out.println("[1] Add Item");
            System.out.println("[2] Add Add-on to Item");
            System.out.println("[3] Submit Order");
            System.out.println("[4] Cancel Order");

            System.out.print("Choose: ");
            int choice = getValidatedInt(1, 4);

            switch (choice) {
                case 1: addItemFlow(); break;
                case 2: addonFlow(); break;
                case 3:
                    facade.submitOrder();
                    selectPaymentMethod(facade);
                    selectDiscount(facade);
                    facade.processOrder(facade.currentOrder, type);
                    ordering = false;
                    break;

                case 4:
                    System.out.println("Order Cancelled.");
                    ordering = false;
                    break;
            }
        }
    }

   // handle order type selection
    private static OrderType chooseOrderType() {
        System.out.println("\n============================================");
        System.out.println("\t   Select Order Type:");
        System.out.println("============================================");
        System.out.println("[1] Dine-In");
        System.out.println("[2] Delivery");
        System.out.println("[3] Takeaway");

        System.out.print("Choose: ");
        int choice = getValidatedInt(1, 3);

        if (choice == 1) return OrderType.DINE_IN;
        if (choice == 2) return OrderType.DELIVERY;
        return OrderType.TAKEAWAY;
    }

    // handle adding item flow
    private static void addItemFlow() {
        System.out.println("\n============================================");
        System.out.println("\t   Select Category:");
        System.out.println("============================================");
        System.out.println("[1] Pizza");
        System.out.println("[2] Burger");
        System.out.println("[3] Drink");
        System.out.print("Choose: ");

        int category = getValidatedInt(1, 3);

        MenuItem item = null;

        if (category == 1) item = selectPizza();
        else if (category == 2) item = selectBurger();
        else if (category == 3) item = selectDrink();

        if (item == null) {
            System.out.println("Invalid selection (not available in chosen menu)");
            return;
        }

        System.out.print("Enter quantity: ");
        int qty = getValidatedInt(1, Integer.MAX_VALUE);

        facade.addItem(item, qty);
        System.out.println(item.getName() + " added to order.");
    }

    
    // handle pizza selection based on dietary factory
    private static MenuItem selectPizza() {
        System.out.println("\n============================================");
        System.out.println("\t   Select Pizza:");
        System.out.println("============================================");

        List<String> options = new ArrayList<>();

        // Ask the factory what it can create:
        if (facade.menuFactory.createPizza("Italian") != null)
            options.add("Italian");
        if (facade.menuFactory.createPizza("Eastern") != null)
            options.add("Eastern");
        if (facade.menuFactory.createPizza("Pepperoni") != null)
            options.add("Pepperoni");
        if (facade.menuFactory.createPizza("Kids") != null)
            options.add("Kids");

        if (options.isEmpty()) {
            System.out.println("No pizzas available in this menu.");
            return null;
        }

        for (int i = 0; i < options.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + options.get(i));
        }

        System.out.print("Choose: ");
        int c = getValidatedInt(1, options.size());

        return facade.menuFactory.createPizza(options.get(c - 1));
    }

    // handle burger selection based on dietary factory
    private static MenuItem selectBurger() {
        System.out.println("\n============================================");
        System.out.println("\t   Select Burger:");
        System.out.println("============================================");
        List<String> options = new ArrayList<>();

        if (facade.menuFactory.createBurger("Classic") != null)
            options.add("Classic");
        if (facade.menuFactory.createBurger("Cheese") != null)
            options.add("Cheese");
        if (facade.menuFactory.createBurger("Zinger") != null)
            options.add("Zinger");
        if (facade.menuFactory.createBurger("Kids") != null)
            options.add("Kids");

        if (options.isEmpty()) {
            System.out.println("No burgers available in this menu.");
            return null;
        }

        for (int i = 0; i < options.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + options.get(i));
        }

        System.out.print("Choose: ");
        int c = getValidatedInt(1, options.size());

        return facade.menuFactory.createBurger(options.get(c - 1));
    }

    // handle drink selection based on dietary factory
    private static MenuItem selectDrink() {
        System.out.println("\n============================================");
        System.out.println("\n   Select Drink:");
        System.out.println("============================================");

        List<String> options = new ArrayList<>();

        if (facade.menuFactory.createDrink("Juice") != null)
            options.add("Juice");
        if (facade.menuFactory.createDrink("Cola") != null)
            options.add("Cola");
        if (facade.menuFactory.createDrink("Kids") != null)
            options.add("Kids");

        if (options.isEmpty()) {
            System.out.println("No drinks available in this menu.");
            return null;
        }

        for (int i = 0; i < options.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + options.get(i));
        }

        System.out.print("Choose: ");
        int c = getValidatedInt(1, options.size());

        return facade.menuFactory.createDrink(options.get(c - 1));
    }

    // handle add-on flow
    private static void addonFlow() {
        sc.nextLine();
        System.out.println("\nEnter name of item to add add-on to:");
        String itemName = sc.nextLine();

        MenuItem target = findItemInOrder(itemName);
        if (target == null) {
            System.out.println("Item not found in order!");
            return;
        }
        System.out.println("\n============================================");
        System.out.println("\tSelect Add-on:");
        System.out.println("============================================");
        System.out.println("[1] Extra Cheese");
        System.out.println("[2] Garlic Sauce");
        System.out.println("[3] Spicy Sauce");
        System.out.print("Choose: ");

        int c = getValidatedInt(1, 3);

        AddOnDecorator addon = null;
        switch (c) {
            case 1: addon = new ExtraCheese(target); break;
            case 2: addon = new GarlicSauce(target); break;
            case 3: addon = new SpicySauce(target); break;
        }

        facade.addAddonToItem(target, addon);
        System.out.println("Add-on applied");
    }

    private static MenuItem findItemInOrder(String name) {
        String target = name.toLowerCase();

        for (OrderItem oi : facade.currentOrder.getItems()) {
            String itemDesc = oi.getMenuItem().getDescription().toLowerCase();

            if (itemDesc.equals(target)) {
                return oi.getMenuItem();
            }
        }
        return null;
    }

    // handle payment method selection
    private static void selectPaymentMethod(RestaurantFacade facade) {
        BillingService billing = facade.billingService;

        System.out.println("\nSelect Payment Method:");
        System.out.println("[1] Cash");
        System.out.println("[2] Credit Card");
        System.out.println("[3] Mobile Wallet");
        System.out.print("Choose: ");

        int choice = getValidatedInt(1, 3);

        switch (choice) {
            case 1:
                billing.setPaymentStrategy(new CashPayment());
                break;

            case 2:
                sc.nextLine(); 
                System.out.print("Enter Card Number: ");
                String card = sc.nextLine();
                billing.setPaymentStrategy(new CreditCardPayment(card));
                break;

            case 3:
                sc.nextLine(); 
                System.out.print("Enter Phone Number: ");
                String phone = sc.nextLine();
                billing.setPaymentStrategy(new MobileWallet(phone));
                break;
        }
    }

    // handle discount selection
    private static void selectDiscount(RestaurantFacade facade) {
        DiscountManger discount = facade.discountManager;

        System.out.println("\nSelect Discount Type:");
        System.out.println("[1] Chicken Discount (10% if total > 20)");
        System.out.println("[2] Meat Discount (30% if total > 100)");
        System.out.println("[3] Pizza Discount (20% if total > 50)");
        System.out.println("[4] No Discount");
        System.out.print("Choose: ");

        int choice = getValidatedInt(1, 4);

        switch (choice) {
            case 1: discount.setStrategy(new ChickenDiscount()); break;
            case 2: discount.setStrategy(new MeatDiscount()); break;
            case 3: discount.setStrategy(new PizzaDiscount()); break;
            default: discount.setStrategy(new NoDiscount()); break;
        }
    }


    private static int getValidatedInt(int min, int max) {
        while (true) {
            String input = sc.nextLine().trim();

            if (!input.matches("\\d+")) {
                System.out.print("Invalid input. Enter a number between " + min + " and " + max + ": ");
                continue;
            }

            int value = Integer.parseInt(input);

            if (value < min || value > max) {
                System.out.print("Invalid input. Enter a number between " + min + " and " + max + ": ");
                continue;
            }

            return value;
        }
    }
}
