package com.thewhite.sstuapp.domain.enumeration;

/**
 * RequestFormatEnum — формат обращения.
 */
public enum RequestFormatEnum {
    Electronic  ("Electronic"), // Электронный
    Other       ("Other"),      // Другое
    ;

    private final String name;

    RequestFormatEnum(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
