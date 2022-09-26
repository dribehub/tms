package com.tms.util;

import java.util.regex.Pattern;

public class PatternUtils {

    private static boolean match(String str, Regex regex) {
        return Pattern.compile(regex.value).matcher(str).find();
    }

    public static boolean containsLowercase(String str) {
        return match(str, Regex.LOWERCASE);
    }

    public static boolean containsUppercase(String str) {
        return match(str, Regex.UPPERCASE);
    }

    public static boolean containsDigits(String str) {
        return match(str, Regex.DIGITS);
    }

    public static boolean containsSymbols(String str) {
        return match(str, Regex.SYMBOLS);
    }

    public static boolean isEmail(String str) {
        return match(str, Regex.EMAIL);
    }

    public static boolean isUsername(String str) {
        return match(str, Regex.USERNAME);
    }
}
