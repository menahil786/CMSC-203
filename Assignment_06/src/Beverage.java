public abstract class Beverage {
    private String bevName;
    private Type type;
    private Size size;
    
    public final double BASE_PRICE = 2.0;
    public final double SIZE_PRICE = 0.5;

    public Beverage(String bevName, Type type, Size size) {
        this.bevName = bevName;
        this.type = type;
        this.size = size;
    }

    public double addSizePrice() {
        switch (size) {
            case MEDIUM: return SIZE_PRICE;
            case LARGE: return 2 * SIZE_PRICE;
            default: return 0;
        }
    }

    public abstract double calcPrice();

    public String toString() {
        return bevName + ", " + size;
    }

    public boolean equals(Object o) {
        if (o instanceof Beverage) {
            Beverage b = (Beverage) o;
            return this.bevName.equals(b.bevName) && this.size == b.size && this.type == b.type;
        }
        return false;
    }

    // Getters and Setters
    public String getBevName() { return bevName; }
    public Type getType() { 
    	return type; }
    public Size getSize() {
    	return size; }
    public void setName(String name) {
        this.bevName = name;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
