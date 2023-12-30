package com.retake.stuaid.security;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

public final class PasswordHash {
    private static final String HASH_ALGORITHM = "PBKDF2WithHmacSHA1";
    private static final int SIZE = 64;

    private static byte[] getSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    private static byte[] createHash(char[] pass, byte[] salt, int ITERATION, int keyLength) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec key = new PBEKeySpec(pass, salt, ITERATION, SIZE * 8);
        SecretKeyFactory factor = SecretKeyFactory.getInstance(HASH_ALGORITHM);

        return factor.generateSecret(key).getEncoded();
    }

    public static String hashPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        char[] pass = password.toCharArray();
        byte[] salt = getSalt();

        int ITERATION = 1000;
        byte[] hash = createHash(pass, salt, ITERATION, SIZE * 8);

        String endHash = Base64.getEncoder().encodeToString(hash);
        String endSalt = Base64.getEncoder().encodeToString(salt);
        return ITERATION + ":" + endSalt + ":" + endHash;
    }

    public static boolean validatePassword(String password, String hashPass) throws NoSuchAlgorithmException, InvalidKeySpecException {
        char[] pass = password.toCharArray();
        String[] splitPass = hashPass.split(":");

        int ITERATION = Integer.parseInt(splitPass[0]);
        byte[] salt = Base64.getDecoder().decode(splitPass[1]);
        byte[] hash = Base64.getDecoder().decode(splitPass[2]);

        byte[] newHash = createHash(pass, salt, ITERATION, hash.length * 8);

        return Arrays.equals(hash, newHash);
    }
}
