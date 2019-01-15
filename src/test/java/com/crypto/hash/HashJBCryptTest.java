package com.crypto.hash;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static org.testng.Assert.*;

public class HashJBCryptTest {
    private final static Logger LOGGER = Logger.getLogger(HashJBCryptTest.class.getName());

    @Test
    public void testHashPassword() {
        final String secretPassword = "Power is all i need!";
        final String hashPassword = HashJBCrypt.hashPassword(secretPassword);
        LOGGER.info(hashPassword);

        Assert.assertTrue(HashJBCrypt.verifyUser(secretPassword, hashPassword));
    }
}