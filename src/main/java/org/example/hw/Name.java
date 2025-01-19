package org.example.hw;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class Name {
    private String lastName;
    private String firstName;
    private String middleName;

    public Name(String firstName) {
        this.firstName = firstName;
        this.lastName = null;
        this.middleName = null;
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = null;
    }

    public Name(String firstName, String lastName, String middleName) {
        if ((firstName == null || firstName.isEmpty()) &&
                (lastName == null || lastName.isEmpty()) &&
                (middleName == null || middleName.isEmpty())) {
            throw new IllegalArgumentException("Хотя бы один параметр (фамилия, имя или отчество) должен быть не пустым.");
        }
        this.lastName = lastName;
        this.firstName = firstName;
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
