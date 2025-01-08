package org.example.hw.block1_6_encapsulation.task1;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
1.6.1 Дом над землей. Измените сущность Дом из задачи 1.4.4. Гарантируйте, что
у дома всегда будет положительное количество этажей. В случае попытки указать
отрицательное количество этажей должна выбрасываться соответствующая ошибка.
Продемонстрируйте работоспособность решения на примерах.
 */

@Data
public class House {
    private final int floors;

    public House(int floors) {
        if (floors <= 0) {
            throw new IllegalArgumentException("Количество этажей должно быть положительным числом.");
        }
        this.floors = floors;
    }

    @Override
    public String toString() {
        String ending;
        int lastDigit = floors % 10;
        int lastTwoDigits = floors % 100;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            ending = "этажами";
        } else if (lastDigit == 1) {
            ending = "этажом";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            ending = "этажами";
        } else {
            ending = "этажами";
        }

        return String.format("Дом с %d %s", floors, ending);
    }
}
