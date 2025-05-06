public class Alcohol extends Beverage {
    private boolean isWeekend;
    public final double WEEKEND_COST = 0.6;

    public Alcohol(String name, Size size, boolean isWeekend) {
        super(name, Type.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }

    public double calcPrice() {
        double price = BASE_PRICE + addSizePrice();
        if (isWeekend) price += WEEKEND_COST;
        return price;
    }

    public String toString() {
        return super.toString() + ", Weekend: " + isWeekend + ", Price: " + calcPrice();
    }

    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Alcohol a = (Alcohol) o;
        return this.isWeekend == a.isWeekend;
    }
}
