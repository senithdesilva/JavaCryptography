package com.crypto.symmetric;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.util.logging.Logger;

public class SymmetricEncryptionTest {
    private final static Logger logger = Logger.getLogger(SymmetricEncryptionTest.class.getName());

    @Test
    public void testCreateAESKey() throws Exception {
        SecretKey key = SymmetricEncryption.createAESKey();
        Assert.assertNotNull(key);
        // log the HEXA Binary key code
        logger.info(DatatypeConverter.printHexBinary(key.getEncoded()));

    }
}