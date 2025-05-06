import java.util.ArrayList;

public class BevShop implements BevShopInterface {
    private int numOfAlcoholInCurrentOrder;
    private ArrayList<Order> orders;
    private Order currentOrder;

    public BevShop() {
        orders = new ArrayList<>();
        numOfAlcoholInCurrentOrder = 0;
    }

    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isEligibleForMore() {
        return numOfAlcoholInCurrentOrder < MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public int getNumOfAlcoholDrink() {
        return numOfAlcoholInCurrentOrder;
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        currentOrder = new Order(time, day, new Customer(customerName, customerAge));
        orders.add(currentOrder);
        numOfAlcoholInCurrentOrder = 0;
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        if (isEligibleForMore()) {
            currentOrder.addNewBeverage(bevName, size);
            numOfAlcoholInCurrentOrder++;
        }
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        return index >= 0 ? orders.get(index).calcOrderTotal() : 0;
    }

    @Override
    public double totalMonthlySale() {
        double total = 0;
        for (Order o : orders) {
            total += o.calcOrderTotal();
        }
        return total;
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getCurrentOrder() {
        return currentOrder;
    }

    @Override
    public Order getOrderAtIndex(int index) {
        return orders.get(index);
    }

    @Override
    public void sortOrders() {
        for (int i = 0; i < orders.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < orders.size(); j++) {
                if (orders.get(j).compareTo(orders.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Order temp = orders.get(i);
            orders.set(i, orders.get(minIndex));
            orders.set(minIndex, temp);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Order o : orders) {
            sb.append(o.toString()).append("\n");
        }
        sb.append("Total Monthly Sale: ").append(totalMonthlySale()).append("\n");
        return sb.toString();
    }
}
