package com.hive.transportadora.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fabio Aguiar
 */
public class URL {

    public static String decodeParam(String s) {
        try {
            return URLDecoder.decode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static List<Long> decodeLongList(String s) {
        if (!s.isEmpty()) {
            return Arrays.asList(s.split(","))
                    .stream().map(x -> Long.parseLong(x)).collect(Collectors.toList());
        } else {
            return null;
        }
    }

}
