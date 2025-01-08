package org.example.hw.block1_6_encapsulation;

import lombok.Data;

/*
1.6.2 Непустые Имена. Измените сущность Имя из задачи 1.4.5. Гарантируйте, что:
    • Как минимум один параметр будет иметь не null значение и не пустую строку.
    • Имя неизменяемо.
Продемонстрируйте работоспособность решения на примерах.
 */
@Data
public class ChangedName {
    private final String lastName;
    private final String firstName;
    private final String middleName;

    // Конструктор с проверкой, что хотя бы один параметр не null и не пустая строка
    public ChangedName(String lastName, String firstName, String middleName) {
        if ((lastName == null || lastName.isEmpty()) &&
                (firstName == null || firstName.isEmpty()) &&
                (middleName == null || middleName.isEmpty())) {
            throw new IllegalArgumentException("Хотя бы один параметр (фамилия, имя или отчество) должен быть задан.");
        }
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    // Конструктор для создания имени только с личным именем
    public ChangedName(String firstName) {
        this(null, firstName, null);
    }

    // Конструктор для создания имени с личным именем и фамилией
    public ChangedName(String firstName, String lastName) {
        this(lastName, firstName, null);
    }

    @Override
    public String toString() {
        return String.join(" ",
                lastName != null ? lastName : "",
                firstName != null ? firstName : "",
                middleName != null ? middleName : "").trim();
    }
}
