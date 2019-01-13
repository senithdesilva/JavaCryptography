package com.crypto.symmetric;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.util.logging.Logger;

public class SymmetricEncryptionTest {
    private final static Logger LOGGER = Logger.getLogger(SymmetricEncryptionTest.class.getName());

    private static final String PLAIN_TEXT = "This is a demonstration of the AES Symmetric Encryption Algorithm";

    @Test(priority = 1)
    public void testCreateAESKey() throws Exception {
        SecretKey key = SymmetricEncryption.createAESKey();
        Assert.assertNotNull(key);
        // log the HEXA Binary key code
        LOGGER.info( "Symmetric Key: " + DatatypeConverter.printHexBinary(key.getEncoded()));

    }

    @Test(priority = 2)
    public void testAESEncryptionAlgorithm() throws Exception{
        // Generate the Symmetric Key
        SecretKey key = SymmetricEncryption.createAESKey();
        // Generate the Initialization Vector
        byte[] initializationVector = SymmetricEncryption.createInitializationVector();
        LOGGER.info("Initialization Vector: " + DatatypeConverter.printHexBinary(initializationVector));

        LOGGER.info("Plain Text: " + PLAIN_TEXT);

        // perform the AES Encryption and return the cipher text.
        byte[] cipherText = SymmetricEncryption.AESEncryptionAlgorithm(PLAIN_TEXT, key, initializationVector);
        Assert.assertNotNull(cipherText);
        LOGGER.info("Cipher Text: " + DatatypeConverter.printHexBinary(cipherText));

        // Using the cipher text perform the AES Decryption
        testAESDecryptionAlgorithm(cipherText, key, initializationVector);
    }

    private void testAESDecryptionAlgorithm(final byte[] cipherText,
                                            final SecretKey key,
                                            final byte[] initializationVector) throws  Exception{
        final String decryptedText = SymmetricEncryption.AESDecryptionAlgorithm(cipherText, key, initializationVector);

        Assert.assertEquals(PLAIN_TEXT, decryptedText);

        LOGGER.info("Decrypted Text: " + decryptedText);
    }
}