package org.example.hw.block1_5_methods.task4;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Name {
    private String lastName;
    private String firstName;
    private String middleName;

    // Конструктор для создания имени только с личным именем
    public Name(String firstName) {
        this.firstName = firstName;
        this.lastName = null;
        this.middleName = null;
    }

    // Конструктор для создания имени с личным именем и фамилией
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = null;
    }

    // Конструктор для создания имени с личным именем, фамилией и отчеством
    public Name(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    @Override
    public String toString() {
        return String.join(" ",
                lastName != null ? lastName : "",
                firstName != null ? firstName : "",
                middleName != null ? middleName : "").trim();
    }
}
