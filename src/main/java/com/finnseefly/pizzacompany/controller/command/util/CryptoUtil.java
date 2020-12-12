package com.finnseefly.pizzacompany.controller.command.util;

import com.finnseefly.pizzacompany.service.ServiceException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class CryptoUtil {
    public static String getNewSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return new String(salt);
    }

    public static String getHashedPassword(String pass, String salt) throws ServiceException {
        String result = null;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(salt.getBytes());
            byte[] bytes = messageDigest.digest(pass.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for (byte aByte : bytes) {
                stringBuilder.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            result = stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new ServiceException(e);
        }

        return result;
    }

}
