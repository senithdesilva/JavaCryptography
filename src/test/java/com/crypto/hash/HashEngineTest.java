package com.crypto.hash;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.bind.DatatypeConverter;
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
    public void testCreateSHA2Hash() {
    }
}