# Restaurant Ordering System

## Overview
This is a console-based **Restaurant Ordering System** implemented in Java.  
It allows users to:
- Create orders for **Dine-In, Takeaway, or Delivery**
- Select items from **Vegetarian, Non-Vegetarian, or Kids menus**
- Add **Add-ons** (Extra Cheese, Garlic Sauce, Spicy Sauce) to items
- Apply **discounts** using a strategy pattern
- Process payments via **Cash, Credit Card, or Mobile Wallet**
- Generate detailed **receipts**
- Notify kitchen and waiter using **Observer pattern**

Design patterns used:
- **Factory Pattern** – Menu item creation  
- **Decorator Pattern** – Add-ons  
- **Strategy Pattern** – Discounts and payment methods  
- **Observer Pattern** – Order notifications  

---

## Folder Structure
All files should be in a single folder, e.g., `restaurant/`:

restaurant/
├─ AddOnDecorator.java
├─ BillingService.java
├─ Burger.java
├─ CheeseBurger.java
├─ ChickenDiscount.java
├─ ClassicBurger.java
├─ Cola.java
├─ CreditCardPayment.java
├─ DeliveryOrderProcessor.java
├─ DiscountManger.java
├─ DiscountStrategy.java
├─ Drink.java
├─ EasternPizza.java
├─ ExtraCheese.java
├─ GarlicSauce.java
├─ ItalianPizza.java
├─ Juice.java
├─ KidsDrink.java
├─ KidsMenuFactory.java
├─ KitchenObserver.java
├─ MenuFactory.java
├─ MenuItem.java
├─ MobileWallet.java
├─ NoDiscount.java
├─ NonVegMenuFactory.java
├─ ObserverSystem.java
├─ PepperoniPizza.java
├─ ReceiptGenerator.java
├─ RestaurantApp.java
├─ RestaurantFacade.java
├─ SpicySauce.java
├─ TakeawayOrderProcessor.java
├─ VegMenuFactory.java
├─ ZingerBurger.java

---

## Requirements
- Java 8 or above
- Console/terminal access

---

## Compilation
1. Open terminal in the `restaurant` folder
2. Compile all Java files:


How to Use
Start the program
java RestaurantApp

Main Menu
[1] Create New Order
[2] Exit

Select Dietary Menu
[1] Vegetarian
[2] Non-Vegetarian
[3] Kids

Select Order Type
[1] Dine-In
[2] Delivery
[3] Takeaway

Add Items to Order

1. Choose category: Pizza, Burger, Drink
2. Choose specific item
3. Enter quantity

Add Add-ons to Items (optional)

Extra Cheese
Garlic Sauce
Spicy Sauce

Submit Order and Choose

1. Payment method: Cash, Credit Card, Mobile Wallet

2. Discount type: Chicken, Meat, Pizza, No Discount

System Will

- Notify kitchen & waiter
- Apply discounts and taxes
- Generate and print detailed receipt

Example Test Case

Scenario:

- Order: Dine-In 
- Menu: Non-Vegetarian
- Items:
  - 1 x Zinger Burger + Extra Cheese
  - 2 x Pepperoni Pizza + Garlic Sauce
  - 1 x Cola
- Discount: Chicken Discount (10% if total > 20)
- Payment: Credit Card

Steps:

1. Create New Order → Non-Vegetarian → Dine-In
2. Add 1 Zinger Burger → Extra Cheese
3. Add 2 Pepperoni Pizza → Garlic Sauce
4. Add 1 Cola
5. Submit Order → Credit Card → Chicken Discount

Expected Behavior:
- Kitchen & waiter are notified
- 10% discount applied if subtotal > 20
- Taxes: 14% for Dine-In
- Receipt shows items, add-ons, subtotal, discount, taxes, total, and payment method

Discount Scenarios
	
Chicken Discount	Total > 20	10% off total
Meat Discount	        Total > 100	30% off total
Pizza Discount	        Total > 50	20% off total
No Discount	        Always	        No discount applied

Add-ons Pricing

Extra Cheese	35 L.E
Garlic Sauce	30 L.E
Spicy Sauce	15 L.E

Notes

Add-ons can only be applied to items already added to the order
Multiple add-ons can be applied to the same item
All discounts and taxes are calculated before printing the receipt
Payments succeed automatically in this demo system
