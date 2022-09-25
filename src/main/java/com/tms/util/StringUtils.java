package com.tms.util;

import java.util.regex.Pattern;

public class StringUtils {

    private final String str;

    public StringUtils(String str) {
        this.str = str;
    }

    public boolean containsLowercase() {
        return Pattern.compile("[a-z]").matcher(str).find();
    }

    public boolean containsUppercase() {
        return Pattern.compile("[A-Z]").matcher(str).find();
    }

    public boolean containsDigits() {
        return Pattern.compile("[0-9]").matcher(str).find();
    }

    public boolean containsSymbols() {
        return Pattern.compile("[^a-zA-Z0-9]").matcher(str).find();
    }
}
