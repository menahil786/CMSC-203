/*
 * Class: CMSC203 
 * Instructor:
 * Description: The Procedure class represents a medical procedure, including its name, date, practitioner, and charges.
 * Due: 03/03/2025
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Menahil Fatima
*/

public class Procedure {
    
    private String nameOfProcedure; // Name of the procedure
    private String DateOfProcedure; // Date the procedure was performed
    private String nameOfPractitioner; // Name of the practitioner performing the procedure
    private double charges; // Cost of the procedure

    /**
     * Default constructor initializes an empty Procedure object.
     */
    public Procedure() {   
    }

    /**
     * Constructor that initializes the procedure with a name and date.
     * 
     * @param name The name of the procedure.
     * @param date The date when the procedure was performed.
     */
    public Procedure(String name, String date) {
        nameOfProcedure = name;
        DateOfProcedure = date;
    }

    /**
     * Constructor that initializes the procedure with all attributes.
     * 
     * @param name The name of the procedure.
     * @param date The date of the procedure.
     * @param practitioner The name of the practitioner performing the procedure.
     * @param c The cost of the procedure.
     */
    public Procedure(String name, String date, String practitioner, double c) {
        nameOfProcedure = name;
        DateOfProcedure = date;
        nameOfPractitioner = practitioner;
        charges = c;
    }

    /**
     * Retrieves the name of the procedure.
     * 
     * @return The name of the procedure.
     */
    public String getNameOfProcedure() {
        return nameOfProcedure;
    }

    /**
     * Sets the name of the procedure.
     * 
     * @param nameOfProcedure The new name of the procedure.
     */
    public void setNameOfProcedure(String nameOfProcedure) {
        this.nameOfProcedure = nameOfProcedure;
    }

    /**
     * Retrieves the date of the procedure.
     * 
     * @return The date of the procedure.
     */
    public String getDateOfProcedure() {
        return DateOfProcedure;
    }

    /**
     * Sets the date of the procedure.
     * 
     * @param dateOfProcedure The new date of the procedure.
     */
    public void setDateOfProcedure(String dateOfProcedure) {
        DateOfProcedure = dateOfProcedure;
    }

    /**
     * Retrieves the name of the practitioner performing the procedure.
     * 
     * @return The name of the practitioner.
     */
    public String getNameOfPractitioner() {
        return nameOfPractitioner;
    }

    /**
     * Sets the name of the practitioner performing the procedure.
     * 
     * @param nameOfPractitioner The new name of the practitioner.
     */
    public void setNameOfPractitioner(String nameOfPractitioner) {
        this.nameOfPractitioner = nameOfPractitioner;
    }

    /**
     * Retrieves the charges for the procedure.
     * 
     * @return The cost of the procedure.
     */
    public double getCharges() {
        return charges;
    }

    /**
     * Sets the charges for the procedure.
     * 
     * @param charges The new cost of the procedure.
     */
    public void setCharges(double charges) {
        this.charges = charges;
    }

    /**
     * Returns a string representation of the procedure.
     * 
     * @return A formatted string containing procedure details.
     */


@Override
public String toString() {
	return "Procedure [nameOfProcedure=" + nameOfProcedure + ", DateOfProcedure=" + DateOfProcedure
			+ ", nameOfPractitioner=" + nameOfPractitioner + ", charges=" + charges + "]";
}


   
}
