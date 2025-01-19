package org.example.hw;

import lombok.Data;
import lombok.NoArgsConstructor;

/*
1.5.3 Длина Линии. Измените сущность Линия из задачи 1.4.2.
Добавьте ей возможность возвращать по запросу пользователя расстояние между точками начала
и конца (в виде целого числа). Создайте линию из точки {1;1} в точку {10;15}
и выведите на экран её длину.
 */
@Data
@NoArgsConstructor
public class Line {
    private Point start;
    private Point end;

    // для создания линии по двум точкам
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // для создания линии по четырем координатам (x1, y1, x2, y2)
    public Line(int x1, int y1, int x2, int y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }
    // Метод для изменения координат начала линии
    public void setStart(int x, int y) {
        this.start = new Point(x, y); // Создаем новую точку
    }

    // Метод для изменения координат конца линии
    public void setEnd(int x, int y) {
        this.end = new Point(x, y); // Создаем новую точку
    }
    // для вычисления длины линии
    public int getLength() {
        int x1 = start.getX();
        int y1 = start.getY();
        int x2 = end.getX();
        int y2 = end.getY();

        // Вычисляем расстояние по формуле
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        // Округляем до ближайшего целого числа
        return (int) Math.round(distance);
    }

    @Override
    public String toString() {
        return "Линия от " + start.getTextRepresentation() + " до " + end.getTextRepresentation();
    }
}