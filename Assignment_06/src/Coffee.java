public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;
    public final double SHOT_COST = 0.5;
    public final double SYRUP_COST = 0.5;

    public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
        super(name, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    public double calcPrice() {
        double price = BASE_PRICE + addSizePrice();
        if (extraShot) price += SHOT_COST;
        if (extraSyrup) price += SYRUP_COST;
        return price;
    }

    public String toString() {
        return super.toString() + ", Extra shot: " + extraShot + ", Extra syrup: " + extraSyrup + ", Price: " + calcPrice();
    }

    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Coffee c = (Coffee) o;
        return this.extraShot == c.extraShot && this.extraSyrup == c.extraSyrup;
    }
}
