package com.crypto.hash;

import org.mindrot.jbcrypt.BCrypt;
// BCrypt is a one way salted hash function based on the Blowfish cipher
class HashJBCrypt {
    static String hashPassword(final String password) {
        // gensalt() method generate a salt for you.
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    static boolean verifyUser(final String password, final String passwordHash) {
        // checkpw() verified that the password phrase and its hash is the same.
        return BCrypt.checkpw(password, passwordHash);
    }
}
