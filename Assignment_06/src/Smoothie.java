/*
 * Class: CMSC203 
 * Instructor: prof grinberg
 * Description: Subclass of Beverage that models smoothies with options for added fruit and protein.
 * Due: 05/05/2025
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Menahil__________
*/
public class Smoothie extends Beverage {
    private int numOfFruits;
    private boolean addProtein;
    public final double PROTEIN_COST = 1.5;
    public final double FRUIT_COST = 0.5;

    public Smoothie(String name, Size size, int numOfFruits, boolean addProtein) {
        super(name, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    public double calcPrice() {
        double price = BASE_PRICE + addSizePrice();
        price += numOfFruits * FRUIT_COST;
        if (addProtein) price += PROTEIN_COST;
        return price;
    }

    public String toString() {
        return super.toString() + ", Fruits: " + numOfFruits + ", Protein: " + addProtein + ", Price: " + calcPrice();
    }

    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Smoothie s = (Smoothie) o;
        return this.numOfFruits == s.numOfFruits && this.addProtein == s.addProtein;
    }
}
