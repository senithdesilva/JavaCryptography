package com.crypto.asymmetric;

import com.crypto.symmetric.SymmetricEncryptionTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

import java.security.KeyPair;
import java.util.logging.Logger;

import static org.testng.Assert.*;

public class AsymmetricEncryptionTest {
    private final static Logger LOGGER = Logger.getLogger(SymmetricEncryptionTest.class.getName());

    @Test
    public void testGenerateRSAKeyPair() throws Exception {
        KeyPair keyPair = AsymmetricEncryption.generateRSAKeyPair();
        Assert.assertNotNull(keyPair);

        // The Private key will be longer than the Public key. its expected in most Asymmetric algorithms
        LOGGER.info( "Private Key: " + DatatypeConverter.printHexBinary(keyPair.getPrivate().getEncoded()));
        LOGGER.info( "Public Key: " + DatatypeConverter.printHexBinary(keyPair.getPublic().getEncoded()));
    }
}