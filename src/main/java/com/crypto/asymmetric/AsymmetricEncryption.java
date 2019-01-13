package com.crypto.asymmetric;

import javax.crypto.Cipher;
import java.security.*;

class AsymmetricEncryption {
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

    static byte[] RSAEncryptionAlgorithm(final String plainText, final PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA);
        // Initialize cipher to encryption mode.
        // I will use the private key to encrypt the plain text.
        // When decryption, we will use the public key.
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        return cipher.doFinal(plainText.getBytes());
    }

    static String RSADecryptionAlgorithm(final byte[] cipherText, final PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA);
        // Use DECRYPT Mode
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        // Conclusion of operation
        byte[] result = cipher.doFinal(cipherText);
        return new String(result);
    }
}
