package com.thewhite.sstuapp.domain.enumeration;

/**
 * QuestionStatusEnum. Статус вопроса.
 */
public enum QuestionStatusEnum {
    NotReceived         ("NotReceived"),      // Не поступило
    NotRegistered       ("NotRegistered"),    // Не зарегистрировано
    InWork              ("InWork"),           // Находится на рассмотрении
    Explained           ("Explained"),        // Рассмотрено. Разъяснено
    Supported           ("Supported"),        // Рассмотрено. Поддержано
    NotSupported        ("NotSupported"),     // Рассмотрено. Не поддержано
    Transferred         ("Transferred"),      // Направлено по компетенции
    Answered            ("Answered"),         // Дан ответ автору
    LeftWithoutAnswer   ("LeftWithoutAnswer") // Оставлено без ответа автору
    ;

    private final String name;

    QuestionStatusEnum(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
