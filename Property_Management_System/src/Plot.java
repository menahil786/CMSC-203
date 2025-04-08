/*
 * Class: CMSC203 
 * Instructor:  Grigoriy Grinberg
 * Description: Represents a rectangular area defined by x and y coordinates, width, and depth. 
 * It provides methods to check if one plot overlaps or is contained within another.
 * Due: 04/07/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: __Menahil fatima________
*/

public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    public Plot() {
        this(0, 0, 1, 1);
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot otherPlot) {
        this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
    }

    public boolean overlaps(Plot other) {
        return !(x + width <= other.x || x >= other.x + other.width ||
                 y + depth <= other.y || y >= other.y + other.depth);
    }

    public boolean encompasses(Plot other) {
        return (x <= other.x && y <= other.y &&
                x + width >= other.x + other.width &&
                y + depth >= other.y + other.depth);
    }

    public int getX() {
    	return x; 
    	}
    public int getY() { 
    	return y; 
    	}
    
    public int getWidth() { 
    	return width; 
    	}
    
    public int getDepth() { 
    	return depth;
    	}

    public void setX(int x) {
    	this.x = x; 
    	}
    
    public void setY(int y) {
    	this.y = y; 
    	}
    
    public void setWidth(int width) { 
    	this.width = width;
    	}
    
    public void setDepth(int depth) { 
    	this.depth = depth; 
    	}

    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}