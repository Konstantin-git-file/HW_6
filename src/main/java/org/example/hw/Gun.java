package org.example.hw;

/*
1.5.1 Пистолет стреляет. Создайте сущность Пистолет, которая описывается следующим образом:
    • Имеет Количество патронов (целое число)
    • Может быть создан с указанием начального количества патронов
    • Может быть создан без указания начального количества патронов, в этом случае он изначально заряжен пятью патронами.
    • Может Стрелять, что приводит к выводу на экран текста “Бах!” в том случае, если количество патронов больше нуля, иначе делает “Клац!”. После каждого выстрела (когда вывелся “Бах!”)	 количество патронов уменьшается на один.
Создайте пистолет с тремя патронами и выстрелите из него пять раз.
 */
public class Gun {
    // По умолчанию пистолет разряжен
    private int bullets = 0;
    private final int maxBullets;

    public Gun(int maxBullets) {
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

    // метод для разрядки
    public int unload() {
        int remainingBullets = bullets;
        bullets = 0;
        return remainingBullets;
    }

    // заряжен ли пистолет
    public boolean isLoaded() {
        return bullets > 0;
    }
}