/*
 * Class: CMSC203 
 * Instructor:
 * Description: The Patient class represents a patient's personal and emergency contact information.
 * Due: 03/03/2025
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Menahil Fatima
*/

public class Patient {
	 private String firstName;         // Patient's first name
	    private String middleName;        // Patient's middle name
	    private String lastName;          // Patient's last name
	    private String streetAddress;     // Patient's street address
	    private String city;              // Patient's city
	    private String state;             // Patient's state
	    private int zipCode;              // Patient's zip code
	    private String number;            // Patient's phone number
	    private String emergencyName;     // Emergency contact's name
	    private String emergencyNumber;   // Emergency contact's phone number
   
	    
	    /**
	     * No-argument constructor for the Patient class.
	     * Initializes all attributes to their default values.
	     */
	    public Patient() {
    	
    }
    
	    /**
	     * Constructor to initialize the Patient with first, middle, and last names.
	     * 
	     * @param first The first name of the patient.
	     * @param middle The middle name of the patient.
	     * @param last The last name of the patient.
	     */
	    public Patient(String first, String middle, String last) {
    	firstName = first;
    	middleName = middle;
    	lastName = last;
    }
    
	    /**
	     * Full constructor for the Patient class.
	     * Initializes all patient details including address, contact, and emergency contact information.
	     * 
	     * @param first The first name of the patient.
	     * @param middle The middle name of the patient.
	     * @param last The last name of the patient.
	     * @param address The patient's street address.
	     * @param c The patient's city.
	     * @param s The patient's state.
	     * @param zip The patient's zip code.
	     * @param num The patient's phone number.
	     * @param eName The emergency contact's name.
	     * @param eNumber The emergency contact's phone number.
	     */
	    
	    public Patient(String first, String middle, String last, String address, String c,String s, int zip, String num, String eName, String eNumber) {
    	
    	firstName = first;
    	middleName = middle;
    	lastName = last;
    	streetAddress = address;
    	city = c;
    	state = s;
    	zipCode = zip;
    	number = num;
    	emergencyName = eName;
    	emergencyNumber = eNumber;
    }

	    /**
	     * Gets the patient's first name.
	     * 
	     * @return The first name of the patient.
	     */
	    public String getFirstName() {
	        return firstName;
	    }

	    /**
	     * Sets the patient's first name.
	     * 
	     * @param firstName The first name to set.
	     */
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    /**
	     * Gets the patient's middle name.
	     * 
	     * @return The middle name of the patient.
	     */
	    public String getMiddleName() {
	        return middleName;
	    }

	    /**
	     * Sets the patient's middle name.
	     * 
	     * @param middleName The middle name to set.
	     */
	    public void setMiddleName(String middleName) {
	        this.middleName = middleName;
	    }

	    /**
	     * Gets the patient's last name.
	     * 
	     * @return The last name of the patient.
	     */
	    public String getLastName() {
	        return lastName;
	    }

	    /**
	     * Sets the patient's last name.
	     * 
	     * @param lastName The last name to set.
	     */
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    /**
	     * Gets the patient's street address.
	     * 
	     * @return The street address of the patient.
	     */
	    public String getStreetAddress() {
	        return streetAddress;
	    }

	    /**
	     * Sets the patient's street address.
	     * 
	     * @param streetAddress The street address to set.
	     */
	    public void setStreetAddress(String streetAddress) {
	        this.streetAddress = streetAddress;
	    }

	    /**
	     * Gets the patient's city.
	     * 
	     * @return The city of the patient.
	     */
	    public String getCity() {
	        return city;
	    }

	    /**
	     * Sets the patient's city.
	     * 
	     * @param city The city to set.
	     */
	    public void setCity(String city) {
	        this.city = city;
	    }

	    /**
	     * Gets the patient's state.
	     * 
	     * @return The state of the patient.
	     */
	    public String getState() {
	        return state;
	    }

	    /**
	     * Sets the patient's state.
	     * 
	     * @param state The state to set.
	     */
	    public void setState(String state) {
	        this.state = state;
	    }

	    /**
	     * Gets the patient's zip code.
	     * 
	     * @return The zip code of the patient.
	     */
	    public int getZipCode() {
	        return zipCode;
	    }

	    /**
	     * Sets the patient's zip code.
	     * 
	     * @param zipCode The zip code to set.
	     */
	    public void setZipCode(int zipCode) {
	        this.zipCode = zipCode;
	    }

	    /**
	     * Gets the patient's phone number.
	     * 
	     * @return The phone number of the patient.
	     */
	    public String getNumber() {
	        return number;
	    }

	    /**
	     * Sets the patient's phone number.
	     * 
	     * @param number The phone number to set.
	     */
	    public void setNumber(String number) {
	        this.number = number;
	    }

	    /**
	     * Gets the emergency contact's name.
	     * 
	     * @return The emergency contact's name.
	     */
	    public String getEmergencyName() {
	        return emergencyName;
	    }

	    /**
	     * Sets the emergency contact's name.
	     * 
	     * @param emergencyName The emergency contact's name to set.
	     */
	    public void setEmergencyName(String emergencyName) {
	        this.emergencyName = emergencyName;
	    }

	    /**
	     * Gets the emergency contact's phone number.
	     * 
	     * @return The emergency contact's phone number.
	     */
	    public String getEmergencyNumber() {
	        return emergencyNumber;
	    }

	    /**
	     * Sets the emergency contact's phone number.
	     * 
	     * @param emergencyNumber The emergency contact's phone number to set.
	     */
	    public void setEmergencyNumber(String emergencyNumber) {
	        this.emergencyNumber = emergencyNumber;
	    }

	    /**
	     * Builds the full name of the patient.
	     * 
	     * @return A string containing the full name of the patient.
	     */
	    public String buildFullName() {
	        return firstName + " " + middleName + " " + lastName;
	    }

	    /**
	     * Builds the address of the patient.
	     * 
	     * @return A string containing the address of the patient.
	     */
	    public String buildAddress() {
	        return streetAddress + " " + city + " " + state + " " + zipCode;
	    }

	    /**
	     * Builds the emergency contact information.
	     * 
	     * @return A string containing the emergency contact information.
	     */
	    public String buildEmergencyContact() {
	        return emergencyName + " " + emergencyNumber;
	    }

	    /**
	     * Returns a string representation of the patient's information.
	     * 
	     * @return A string containing the patient's name, address, and emergency contact information.
	     */
	
	 @Override
	    public String toString() {
	        return "Patient Information:\n" +
	               "Name: " + buildFullName() + "\n" +
	               "Address: " + buildAddress() + "\n" +
	               "Phone: " + number + "\n" +
	               "Emergency Contact: " + buildEmergencyContact();
	    }
    
}
