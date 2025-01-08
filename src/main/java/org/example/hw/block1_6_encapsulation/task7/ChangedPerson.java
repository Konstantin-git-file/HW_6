package org.example.hw.block1_6_encapsulation.task7;
/*
1.6.7 Родители остаются. Измените сущность Человек из задачи 1.4.6. Новые требования включают:
    • Отца возможно задать только при создании и в дальнейшем он не изменяется, но его можно получить
    • Имя можно получить в любой момент в виде объекта типа Имя.
 */

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class ChangedPerson {
    @NonNull
    private Name name;
    private int height;
    private final ChangedPerson father;

    public ChangedPerson(String firstName) {
        this(new Name(firstName), 0, null);
    }

    public ChangedPerson(String firstName, ChangedPerson father) {
        this(new Name(firstName), 0, father);
    }

    public String getTextRepresentation() {
        return name + ", рост: " + height;
    }

    @Override
    public String toString() {
        String lastName = name.getLastName();
        String firstName = name.getFirstName();
        String middleName = name.getMiddleName();

        if (lastName == null || lastName.isEmpty()) {
            if (father != null && father.getName().getLastName() != null) {
                lastName = father.getName().getLastName();
            } else {
                lastName = "";
            }
        }

        if (middleName == null || middleName.isEmpty()) {
            if (father != null && father.getName().getFirstName() != null) {
                middleName = father.getName().getFirstName() + "ович";
            } else {
                middleName = "";
            }
        }

        return String.join(" ",
                lastName != null ? lastName : "",
                firstName != null ? firstName : "",
                middleName != null ? middleName : "").trim();
    }
}