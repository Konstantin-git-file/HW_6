package org.example.hw.block1_6_encapsulation.task5;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


/*
1.6.5 Перезарядка Пистолета. Измените сущность Пистолет из задачи 1.5.1. Модификация предполагает внесение следующих дополнительных требований:
    • Имеет максимальное количество патронов. Максимальное количество устанавливается во время создания пистолета и не может быть изменено позднее. У пистолета можно узнать, какое максимальное количество он вмещает.
    • Может быть перезаряжен. Для перезарядки необходимо передать пистолету число, которое будет означать количество заряжаемых патронов. Если передано отрицательное число, необходимо выбросить ошибку, объясняющую, что отрицательного числа патронов быть не может. Если передано слишком большое число патронов – необходимо лишние вернуть.
    • Может быть разряжен. Это приводит к обнулению патронов в пистолете и возврате нужного числа пользователю.
    • Можно узнать сколько сейчас заряжено патронов.
    • Можно узнать заряжен он или разряжен.
Создайте пистолет вместимостью 7, зарядите три патрона, выстрелите из него пять раз, затем зарядите в него 8 патронов, выстрелите еще 2 раза, разрядите его, сделайте контрольный выстрел.
Если все выполнено верно, то должно быть выведено: Бах! Бах! Бах! Клац! Клац! Бах! Бах! Клац!
 */
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ChangedGun {
    // По умолчанию пистолет разряжен
    private int bullets = 0;
    private final int maxBullets;

    public ChangedGun(int maxBullets) {
        if (maxBullets <= 0) {
            throw new IllegalArgumentException("Максимальное количество патронов должно быть положительным.");
        }
        this.maxBullets = maxBullets;
    }

    public void shoot() {
        if (bullets > 0) {
            System.out.println("Бах!");
            bullets--;
        } else {
            System.out.println("Клац!");
        }
    }

    public int reload(int bulletsToAdd) {
        if (bulletsToAdd < 0) {
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным.");
        }
        int totalBullets = bullets + bulletsToAdd;
        if (totalBullets > maxBullets) {
            int excess = totalBullets - maxBullets;
            bullets = maxBullets;
            return excess; // Возвращаем лишние патроны
        } else {
            bullets = totalBullets;
            return 0; // Лишних патронов нет
        }
    }

    // Метод для разрядки
    public int unload() {
        int remainingBullets = bullets;
        bullets = 0;
        return remainingBullets;
    }

    // Метод для проверки, заряжен ли пистолет
    public boolean isLoaded() {
        return bullets > 0;
    }
}