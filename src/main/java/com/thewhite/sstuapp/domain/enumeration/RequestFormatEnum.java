package com.thewhite.sstuapp.domain.enumeration;

/**
 * RequestFormat — формат обращения.
 */
public enum RequestFormat {
    Electronic  ("Electronic"), // Электронный
    Other       ("Other"),      // Другое
    ;

    private final String name;

    RequestFormat(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
