package com.crypto.hash;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;

class HashEngine {
    private static final String SHA2_AlGORITHM = "SHA-256";

    static byte[] generateSalt() {
        byte[] salt = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(salt);
        return salt;
    }

    static byte[] createSHA2Hash(final String input, final byte[] salt) throws Exception {
        // Data can be written into a byte array.
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(salt);
        byteArrayOutputStream.write(input.getBytes());

        // The data can be retrieved using toByteArray() and toString()
        byte[] valueToHash = byteArrayOutputStream.toByteArray();

        // Message digests are secure one-way hash functions
        // That take arbitrary-sized data and output a fixed-length hash value
        // Supported algorithms are MD5, SHA-1, and SHA-256
        MessageDigest messageDigest = MessageDigest.getInstance(SHA2_AlGORITHM);
        return messageDigest.digest(valueToHash);
    }
}
