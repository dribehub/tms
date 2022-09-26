package com.tms.util;

import java.util.regex.Pattern;

public class PatternUtils {

    private enum Regex {

        //language=RegExp
        LOWERCASE("[a-z]"),
        //language=RegExp
        UPPERCASE("[A-Z]"),
        //language=RegExp
        DIGITS("[0-9]"),
        //language=RegExp
        SYMBOLS("[^a-zA-Z0-9]"),
        //language=RegExp
        USERNAME("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*$"),
        //language=RegExp
        EMAIL("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z]+\\.[a-z]+$");

        public final String value;

        Regex(String value) {
            this.value = value;
        }
    }

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
