package com.thewhite.sstuapp.domain.enumeration;

/**
 * QuestionStatus. Статус вопроса.
 */
public enum QuestionStatus {
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

    QuestionStatus(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
