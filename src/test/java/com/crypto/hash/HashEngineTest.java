package com.crypto.hash;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.bind.DatatypeConverter;
import java.util.UUID;
import java.util.logging.Logger;

public class HashEngineTest {
    private final static Logger LOGGER = Logger.getLogger(HashEngineTest.class.getName());

    @Test
    public void testGenerateSalt() {
        byte[] salt = HashEngine.generateSalt();
        Assert.assertNotNull(salt);
        LOGGER.info(DatatypeConverter.printHexBinary(salt));
    }

    @Test
    public void testCreateSHA2Hash() throws Exception {
        byte[] salt = HashEngine.generateSalt();

        // universally unique identifier (UUID). A UUID represents a 128-bit value.
        String valueToHash = UUID.randomUUID().toString();
        byte[] hash = HashEngine.createSHA2Hash(valueToHash, salt);
        Assert.assertNotNull(hash);

        byte[] hash2 = HashEngine.createSHA2Hash(valueToHash, salt);
        Assert.assertEquals(DatatypeConverter.printHexBinary(hash), DatatypeConverter.printHexBinary(hash2));
    }
}