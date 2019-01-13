package com.crypto.symmetric;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

public class SymmetricEncryption {
    // Advanced Encryption Standard
    private static final String AES = "AES";

    // CBC: Cipher Block Chaining
    // Padding of 5 and PKCS, which is a padding scheme
    // Here, we are going to pass in a block cipher
    // format is "algorithm/mode/padding"
    private static final String AES_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";

    // Create a random symmetric key
    static SecretKey createAESKey() throws Exception {
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

    // To make each message unique, an Initialization Vector must be used in the first block.
    // Initialization Vector is the first step used to encrypt the plain text.
    // Initialization Vector is also used to decrypt the cipher text.
    public static byte[] createInitializationVector() {
        // With a size of 16
        byte[] initializationVector = new byte[16];

        SecureRandom secureRandom = new SecureRandom();

        // This will populate all 16 bytes randomly.
        secureRandom.nextBytes(initializationVector);

        return initializationVector;
    }

    public static byte[] AESEncryptionAlgorithm(final String plainText, final SecretKey secretKey, final byte[] initializationVector) throws Exception {
        // Cipher Engine with the valid transformation.
        // Here you can use different types of transformation. ex: DES/ECB/PKCS5Padding (56)
        Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);

        // This initializes a cipher with the init vector while encrypting the plain text.
        // Wrapper for an init vector.
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);

        // Initialize cipher to encryption mode.
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);

        return cipher.doFinal(plainText.getBytes());
    }

    public static String AESDecryptionAlgorithm(final byte[] cipherText, final SecretKey secretKey, final byte[] initializationVector) throws Exception {
        // very much similar to encryption
        Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);

        // But with DECRYPT Mode
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);

        // Conclusion of operation
        byte[] result = cipher.doFinal(cipherText);
        return new String(result);
    }
}
