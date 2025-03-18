
/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds(String plainText) {
	    final int LOWER_RANGE = 32;  // ASCII space
	    final int UPPER_RANGE = 95;  // ASCII underscore

	    for (int i = 0; i < plainText.length(); i++) {
	        char ch = plainText.charAt(i);
	        if (ch < LOWER_RANGE || ch > UPPER_RANGE) {
	            return false;
	        }
	    }
	    return true;
	}
	

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
	    
		if (plainText == null || plainText.isEmpty()) {
	        return "Invalid input: Plain text cannot be empty.";
	    }
	    
	    if (key == 0) {
	        return "Zero is an invalid key for encryption.";
	    }
	    if (!isStringInBounds(plainText)) {
	        return "The selected string is not in bounds, Try again.";
	    }
	    if (key <= 0 || key >= RANGE) {
            return "Invalid key: Key must be between 1 and " + (RANGE - 1) + ".";
        }

		final int LOWER_RANGE = 32;  // ASCII space
	    final int UPPER_RANGE = 95;  // ASCII underscore
	    final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;  // Total range of allowed characters
	    StringBuilder encryptedText = new StringBuilder();

	    for (int i = 0; i < plainText.length(); i++) {
	        char ch = plainText.charAt(i);
	        int shiftedChar = (ch - LOWER_RANGE + key) % RANGE + LOWER_RANGE;
	        encryptedText.append((char) shiftedChar);
	    }

	    return encryptedText.toString();
	}
	
	
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption(String plainText, String bellasoStr) {
		if (plainText == null || plainText.isEmpty()) {
	        return "Invalid input: Plain text cannot be empty.";
	    }
	    if (bellasoStr == null || bellasoStr.isEmpty()) {
	        return "Invalid input: Bellaso string cannot be null or empty.";
	    }
	    
		
		final int LOWER_RANGE = 32;
	    final int UPPER_RANGE = 95;
	    final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
	    StringBuilder encryptedText = new StringBuilder();

	    for (int i = 0; i < plainText.length(); i++) {
	        char plainChar = plainText.charAt(i);
	        char bellasoChar = bellasoStr.charAt(i % bellasoStr.length());
	        int shift = bellasoChar;  // Using ASCII value of bellasoChar for shift
	        int shiftedChar = (plainChar - LOWER_RANGE + shift) % RANGE + LOWER_RANGE;
	        encryptedText.append((char) shiftedChar);
	    }

	    return encryptedText.toString();
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption(String encryptedText, int key) {
		if (encryptedText == null || encryptedText.isEmpty()) {
            return "Invalid input: Encrypted text cannot be empty.";
        }
        if (key == 0) {
            return "Zero is an invalid key for decryption.";
        }
        if (key <= 0 || key >= RANGE) {
            return "Invalid key: Key must be between 1 and " + (RANGE - 1) + ".";
        }
		
		final int LOWER_RANGE = 32;
	    final int UPPER_RANGE = 95;
	    final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
	    StringBuilder decryptedText = new StringBuilder();

	    for (int i = 0; i < encryptedText.length(); i++) {
	        char ch = encryptedText.charAt(i);
	        int shiftedChar = (ch - LOWER_RANGE - key) % RANGE + LOWER_RANGE;
	        decryptedText.append((char) shiftedChar);
	    }

	    return decryptedText.toString();
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
	    // Example check to throw an exception if bellasoStr is empty or null
		if (encryptedText == null || encryptedText.isEmpty()) {
            return "Invalid input: Encrypted text cannot be empty.";
        }
        if (bellasoStr == null || bellasoStr.isEmpty()) {
            return "Invalid input: Bellaso string cannot be null or empty.";
        }
	    
	    final int LOWER_RANGE = 32;  // ASCII space
	    final int UPPER_RANGE = 95;  // ASCII underscore
	    final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;  // Total range of allowed characters
	    StringBuilder decryptedText = new StringBuilder();

	    // Iterate over each character of the encryptedText
	    for (int i = 0; i < encryptedText.length(); i++) {
	        char encryptedChar = encryptedText.charAt(i);  // Get the current character from the encrypted text
	        char bellasoChar = bellasoStr.charAt(i % bellasoStr.length());  // Get the corresponding character from bellasoStr
	        int shift = bellasoChar;  // The ASCII value of bellasoChar will be used as the shift
	        // Reverse the shift (decryption): subtract the shift, ensuring we stay within the range
	        int shiftedChar = (encryptedChar - LOWER_RANGE - shift + RANGE) % RANGE + LOWER_RANGE;
	        decryptedText.append((char) shiftedChar);  // Append the decrypted character to the result
	    }

	    return decryptedText.toString();  // Return the decrypted message
	}
}