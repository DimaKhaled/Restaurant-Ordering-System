class KidsDrink extends Drink {
    public KidsDrink() { super("Kids Drink", 40.0); }
    @Override
    public String getDescription() { return name; }
}