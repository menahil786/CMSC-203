/*
 * Class: CMSC203 
 * Instructor:  Grigoriy Grinberg
 * Description: Represents a rental property with details like name, city, rent amount, owner, 
 * and its plot location. It supports basic data access and formatted display.
 * Due: 04/07/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: __Menahil fatima________
*/

public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    public Property() {
        this("", "", 0.0, "", 0, 0, 1, 1);
    }

    public Property(String propertyName, String city, double rentAmount, String owner) {
        this(propertyName, city, rentAmount, owner, 0, 0, 1, 1);
    }

    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    public Property(Property otherProperty) {
        this(otherProperty.propertyName, otherProperty.city,
             otherProperty.rentAmount, otherProperty.owner,
             otherProperty.plot.getX(), otherProperty.plot.getY(),
             otherProperty.plot.getWidth(), otherProperty.plot.getDepth());
    }

    public String getPropertyName() {
    	return propertyName; 
    	}
    
    public String getCity() {
    	return city;
    	}
    
    public double getRentAmount() { 
    	return rentAmount;
    	}
    
    public String getOwner() { 
    	return owner; 
    	}
    
    public Plot getPlot() {
    	return new Plot(plot); 
    	}

    public void setPropertyName(String propertyName) {
    	this.propertyName = propertyName; 
    	}
    
    public void setCity(String city) { 
    	this.city = city; 
    	}
    
    public void setRentAmount(double rentAmount) { 
    	this.rentAmount = rentAmount; 
    	}
    
    public void setOwner(String owner) { 
    	this.owner = owner; 
    	}
    
    public void setPlot(int x, int y, int width, int depth) {
        this.plot = new Plot(x, y, width, depth);
    }

    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}

