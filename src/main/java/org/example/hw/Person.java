package org.example.hw;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
// @NoArgsConstructor
public class Person {
    @Getter
    private final Name name; // Имя (неизменяемое)
    private int height; // Рост (может изменяться)
    private final Person father; // Отец (неизменяемый)

    public Person(Name name, int height, Person father) {
        this.name = name;
        this.height = height;
        this.father = father;
    }

    // для создания человека только с именем (строка)
    public Person(String firstName) {
        this(new Name(firstName), 0, null); // Рост по умолчанию 0, отец не указан
    }

    // для создания человека только с именем (объект Name)
    public Person(Name name) {
        this(name, 0, null); // Рост по умолчанию 0, отец не указан
    }

    // с именем (строка) и отцом
    public Person(String firstName, Person father) {
        this(new Name(firstName), 0, father); // Рост по умолчанию 0
    }

    // с именем (объект Name) и отцом
    public Person(Name name, Person father) {
        this(name, 0, father); // Рост по умолчанию 0
    }

    //  для получения имени
    public String getFirstName() {
        return name.getFirstName();
    }

    //  для получения отчества
    public String getMiddleName() {
        return name.getMiddleName();
    }

    //  для получения фамилии
    public String getLastName() {
        String lastName = name.getLastName();
        if (lastName == null || lastName.isEmpty()) {
            if (father != null) {
                return father.getLastName();
            } else {
                return "";
            }
        }
        return lastName;
    }

    public String getTextRepresentation() {
        return name + ", рост: " + height;
    }

    @Override
    public String toString() {
        String lastName = getLastName();
        String firstName = getFirstName();
        String middleName = getMiddleName();

        // если отчества нет, то тогода берем его из имени отца
        if (middleName == null || middleName.isEmpty()) {
            if (father != null && father.getFirstName() != null) {
                middleName = father.getFirstName() + "ович";
            } else {
                middleName = "";
            }
        }

        // Формируем итоговую строку
        return String.join(" ",
                lastName != null ? lastName : "",
                firstName != null ? firstName : "",
                middleName != null ? middleName : "").trim();
    }
}