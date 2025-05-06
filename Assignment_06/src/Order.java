import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {
    private int orderTime;
    private Day orderDay;
    private Customer cust;
    private int orderNo;
    private ArrayList<Beverage> beverages;

    public Order(int time, Day day, Customer cust) {
        this.orderTime = time;
        this.orderDay = day;
        this.cust = new Customer(cust); // deep copy
        this.orderNo = new Random().nextInt(80001) + 10000;
        this.beverages = new ArrayList<>();
    }

    @Override
    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }

    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo);
        }
        return null;
    }

    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    @Override
    public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Alcohol(bevName, size, isWeekend()));
    }

    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    @Override
    public double calcOrderTotal() {
        double total = 0.0;
        for (Beverage b : beverages) {
            total += b.calcPrice();
        }
        return total;
    }

    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage b : beverages) {
            if (b.getType() == type) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNo, other.orderNo);
    }

    public Customer getCustomer() {
        return new Customer(cust); // deep copy
    }

    public int getTotalItems() {
        return beverages.size();
    }

    public int getOrderNo() {
        return orderNo;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public Day getOrderDay() {
        return orderDay;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(orderNo).append("\n");
        sb.append("Order Time: ").append(orderTime).append("\n");
        sb.append("Order Day: ").append(orderDay).append("\n");
        sb.append("Customer: ").append(cust).append("\n");
        sb.append("Beverages:\n");
        for (Beverage b : beverages) {
            sb.append("  ").append(b.toString()).append("\n");
        }
        sb.append("Total: ").append(calcOrderTotal()).append("\n");
        return sb.toString();
    }
}