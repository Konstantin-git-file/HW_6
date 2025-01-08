package org.example.hw.block1_5_methods.task4;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {
    private Name name;
    private int height;
    private Person father;

    // Основной конструктор, который выполняет все присвоения
    public Person(Name name, int height, Person father) {
        this.name = name;
        this.height = height;
        this.father = father;
    }

    // Конструктор для создания человека только с именем (строка)
    public Person(String firstName) {
        this(new Name(firstName), 0, null); // Рост по умолчанию 0, отец не указан
    }

    // Конструктор для создания человека только с именем (объект Name)
    public Person(Name name) {
        this(name, 0, null); // Рост по умолчанию 0, отец не указан
    }

    // Конструктор для создания человека с именем (строка) и отцом
    public Person(String firstName, Person father) {
        this(new Name(firstName), 0, father); // Рост по умолчанию 0
    }

    // Конструктор для создания человека с именем (объект Name) и отцом
    public Person(Name name, Person father) {
        this(name, 0, father); // Рост по умолчанию 0
    }

    // Метод для получения личного имени
    public String getFirstName() {
        return name.getFirstName();
    }

    // Метод для получения отчества
    public String getMiddleName() {
        return name.getMiddleName();
    }

    // Метод для получения фамилии
    public String getLastName() {
        String lastName = name.getLastName();
        if (lastName == null || lastName.isEmpty()) {
            if (father != null) {
                return father.getLastName(); // Рекурсивно ищем фамилию у отца
            } else {
                return ""; // Если фамилия не задана и отец отсутствует, возвращаем пустую строку
            }
        }
        return lastName;
    }

    public String getTextRepresentation() {
        return name + ", рост: " + height;
    }

    @Override
    public String toString() {
        String lastName = getLastName(); // Используем новый метод для получения фамилии
        String firstName = getFirstName();
        String middleName = getMiddleName();

        // Если отчество не указано, используем имя отца с добавлением "-ович"
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