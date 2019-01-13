package com.crypto.asymmetric;

import com.crypto.symmetric.SymmetricEncryptionTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.bind.DatatypeConverter;

import java.security.KeyPair;
import java.security.PublicKey;
import java.util.logging.Logger;

public class AsymmetricEncryptionTest {
    private static final Logger LOGGER = Logger.getLogger(SymmetricEncryptionTest.class.getName());
    
    private static final String PLAIN_TEXT = "This is a demonstration of the RSA Asymmetric Encryption Algorithm";

    @Test(priority = 1)
    public void testGenerateRSAKeyPair() throws Exception {
        KeyPair keyPair = AsymmetricEncryption.generateRSAKeyPair();
        Assert.assertNotNull(keyPair);

        // The Private key will be longer than the Public key. its expected in most Asymmetric algorithms
        LOGGER.info( "Private Key: " + DatatypeConverter.printHexBinary(keyPair.getPrivate().getEncoded()));
        LOGGER.info( "Public Key: " + DatatypeConverter.printHexBinary(keyPair.getPublic().getEncoded()));
    }

    @Test(priority = 2)
    public void testRSAEncryptionAlgorithm() throws Exception{
        // Generate the Key Pairs
        KeyPair keyPair = AsymmetricEncryption.generateRSAKeyPair();

        LOGGER.info("Plain Text: " + PLAIN_TEXT);

        // perform the RSA Encryption and return the cipher text.
        byte[] cipherText = AsymmetricEncryption.RSAEncryptionAlgorithm(PLAIN_TEXT, keyPair.getPrivate());
        Assert.assertNotNull(cipherText);
        LOGGER.info("Cipher Text: " + DatatypeConverter.printHexBinary(cipherText));

        // Using the cipher text perform the RSA Decryption
        testRSADecryptionAlgorithm(cipherText, keyPair.getPublic());
    }


    private void testRSADecryptionAlgorithm(final byte[] cipherText, final PublicKey publicKey) throws Exception{
        final String decryptedText = AsymmetricEncryption.RSADecryptionAlgorithm(cipherText, publicKey);

        Assert.assertEquals(PLAIN_TEXT, decryptedText);

        LOGGER.info("Decrypted Text: " + decryptedText);
    }
}