package com.thewhite.sstuapp.domain.enumeration;

/**
 * RequestFormatEnum — формат обращения.
 */
public enum UploadStatusEnum {
    None            ("None"),    // Выгрузка не производилась
    Success         ("Success"), // Электронный
    Warning         ("Warning"), //
    Error           ("Error")
    ;

    private final String name;

    UploadStatusEnum(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
