package com.hive.transportadora.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @author Fabio Aguiar
 */
public class Cryptography {

    public static String encoderBase64(String s) {
        try {
            if(s != null) {
                return Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
            } else {
                return null;
            }
        } catch (UnsupportedEncodingException ex) {
            return ex.getMessage();
        }
    }

    public static String decoderBase64(String s) {
        try {
            if (s != null) {
                return new String(Base64.getDecoder().decode(s), "utf-8");
            } else {
                return null;
            }
        } catch (UnsupportedEncodingException ex) {
            return ex.getMessage();
        }
    }
}
