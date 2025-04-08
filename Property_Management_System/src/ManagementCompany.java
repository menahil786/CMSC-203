/*
 * Class: CMSC203 
 * Instructor:  Grigoriy Grinberg
 * Description: Represents a company that manages up to five properties. It stores company info, 
 * calculates total rent, checks for property overlaps, and ensures all properties fit within a defined plot.
 * Due: 04/07/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: __Menahil fatima________
*/

public class ManagementCompany {
    private String name;
    private String taxID;
    private double mgmFeePer;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    public ManagementCompany() {
        this.name = "";
        this.taxID = "";
        this.mgmFeePer = 0;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    public ManagementCompany(String name, String taxID, double mgmFeePer) {
        this(name, taxID, mgmFeePer, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    public Integer addProperty(Property property) {
        if (property == null) return -2;
        if (numberOfProperties >= MAX_PROPERTY) return -1;
        if (!plot.encompasses(property.getPlot())) return -3;
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null && properties[i].getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }
        properties[numberOfProperties] = new Property(property);
        return numberOfProperties++;
    }

    public Integer addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    public Integer addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    public double getTotalRent() {
        double total = 0;
        for (int i = 0; i < numberOfProperties; i++) {
            total += properties[i].getRentAmount();
        }
        return total;
    }

    public int getPropertiesCount() {
        return numberOfProperties;
    }

    public boolean isPropertiesFull() {
        return numberOfProperties == MAX_PROPERTY;
    }

    public boolean isMangementFeeValid() {
        return mgmFeePer >= 0 && mgmFeePer <= 100;
    }

    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) return null;
        Property highest = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highest.getRentAmount()) {
                highest = properties[i];
            }
        }
        return highest;
    }

    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    public Plot getPlot() { 
    	return plot; 
    	}
    
    public String getName() { 
    	return name; 
    	}
    
    public Property[] getProperties() {
    	return properties;
    	}
    
    public int getMAX_PROPERTY() {
    	return MAX_PROPERTY; 
    	}
    

    public String toString() {
        StringBuilder sb = new StringBuilder("List of the properties for " + name + ", taxID: " + taxID + "\n");
        sb.append("______________________________________________________\n");
        for (int i = 0; i < numberOfProperties; i++) {
            sb.append(properties[i].toString()).append("\n");
        }
        sb.append("______________________________________________________\n\n");
        sb.append(" total management Fee: ").append(Math.round((mgmFeePer / 100.0) * getTotalRent() * 100.0) / 100.0);
        return sb.toString();
    }
}

