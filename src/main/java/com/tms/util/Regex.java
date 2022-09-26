package com.tms.util;

public enum Regex {

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
