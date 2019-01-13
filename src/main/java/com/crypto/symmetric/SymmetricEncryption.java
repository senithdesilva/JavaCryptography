package com.crypto.symmetric;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;

public class SymmetricEncryption {
    // Advanced Encryption Standard
    private static final String AES = "AES";

    public static SecretKey createAESKey() throws Exception{
        // Create a SecureRandom instance
        // In the form of a pseudo-random number generator (PRNG)
        // They use a deterministic algorithm to produce a pseudo-random sequence from a true random seed
        SecureRandom secureRandom = new SecureRandom();

        // Provides the functionality of a secret (symmetric) key generator
        // Will be creating a AES of 256 key size
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
        keyGenerator.init(256, secureRandom);
        return keyGenerator.generateKey();
    }
}
