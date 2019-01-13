package com.crypto.asymmetric;

import java.security.*;

public class AsymmetricEncryption {
    // RSA (Rivest–Shamir–Adleman)
    // This is what im going to use as my asymmetric cryptography algorithm
    private static final String RSA = "RSA";

    static KeyPair generateRSAKeyPair() throws Exception {
        SecureRandom secureRandom = new SecureRandom();

        // For Symmetric Encryption I used the KeyGenerator, which only generates one key. Expected!
        // For Asymmetric Encryption we must use the KeyPairGenerator.
        // Used to generate pairs of public and private keys.
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
        // Key size of 4096. Can be 1024 or 2048
        keyPairGenerator.initialize(4096, secureRandom);
        return keyPairGenerator.generateKeyPair();
    }
}
