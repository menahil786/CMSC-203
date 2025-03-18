import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CryptoManagerTestStudent {

    @Before
    public void setUp() throws Exception {
        // Setup for your tests, if needed
    }

    @After
    public void tearDown() throws Exception {
        // Cleanup after each test, if needed
    }

    @Test
    public void testStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("PYTHON"));
        assertTrue(CryptoManager.isStringInBounds("HELLO_WORLD"));
        assertFalse(CryptoManager.isStringInBounds("example"));
        assertFalse(CryptoManager.isStringInBounds("{PYTHON_TEST"));
        assertFalse(CryptoManager.isStringInBounds("A very long string that exceeds the bounds of acceptable input for this test"));
    }

    @Test
    public void testEncryptCaesar() {
        assertEquals("KHOOR", CryptoManager.caesarEncryption("HELLO", 3));  // Test Caesar encryption with shift of 3
        assertEquals("ZEBRAS", CryptoManager.caesarEncryption("YAXQZ", 2));  // Test Caesar encryption with a shift of 2
        assertEquals("XYZZZZ", CryptoManager.caesarEncryption("HELLO", 100));  // Caesar encryption with a large shift
        assertEquals("D!$%&", CryptoManager.caesarEncryption("12345", 4));  // Caesar encryption with numeric values
        assertEquals("!\"#$%&'", CryptoManager.caesarEncryption("THIS IS A TEST", 5));  // Caesar encryption with punctuation
    }

    @Test
    public void testDecryptCaesar() {
        assertEquals("HELLO", CryptoManager.caesarDecryption("KHOOR", 3));  // Caesar decryption with shift of 3
        assertEquals("YAXQZ", CryptoManager.caesarDecryption("ZEBRAS", 2));  // Caesar decryption with shift of 2
        assertEquals("HELLO", CryptoManager.caesarDecryption("XYZZZZ", 100));  // Caesar decryption with a large shift
        assertEquals("12345", CryptoManager.caesarDecryption("D!$%&", 4));  // Caesar decryption with numeric values
        assertEquals("THIS IS A TEST", CryptoManager.caesarDecryption("!\"#$%&'", 5));  // Caesar decryption with punctuation
    }

    @Test
    public void testEncryptBellaso() {
        assertEquals("AB#BD", CryptoManager.bellasoEncryption("HELLO", "PYTHON123"));  // Bellaso encryption with custom key
        assertEquals("MNPQ!!", CryptoManager.bellasoEncryption("TESTING", "SECUREKEY"));  // Another Bellaso encryption example
        assertEquals("ZZZ#1", CryptoManager.bellasoEncryption("HELLO_WORLD", "KEY"));  // Bellaso encryption with mixed characters
        assertEquals("BFNVX&", CryptoManager.bellasoEncryption("HELLO THERE", "ALONGKEYFORBELLASO"));  // Bellaso encryption with long key
    }

    @Test
    public void testDecryptBellaso() {
        assertEquals("HELLO", CryptoManager.bellasoDecryption("AB#BD", "PYTHON123"));  // Bellaso decryption with custom key
        assertEquals("TESTING", CryptoManager.bellasoDecryption("MNPQ!!", "SECUREKEY"));  // Bellaso decryption with custom key
        assertEquals("HELLO_WORLD", CryptoManager.bellasoDecryption("ZZZ#1", "KEY"));  // Bellaso decryption with mixed characters
        assertEquals("HELLO THERE", CryptoManager.bellasoDecryption("BFNVX&", "ALONGKEYFORBELLASO"));  // Bellaso decryption with long key
    }
}

