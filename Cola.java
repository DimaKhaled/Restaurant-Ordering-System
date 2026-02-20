class Cola extends Drink {
    public Cola() { super("Cola", 50.0); }
    @Override
    public String getDescription() { return name; }
}