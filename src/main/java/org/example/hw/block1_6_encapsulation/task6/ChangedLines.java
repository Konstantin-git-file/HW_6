package org.example.hw.block1_6_encapsulation.task6;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.hw.block1_5_methods.task3.Point;

/*
1.6.6 Отдельные линии. Измените сущность Линия из задачи 1.5.3. Необходимо, чтобы Линия соответствовала следующим требованиям:
    • Две любые линии не могут ссылаться на один и тот же объект точки.
    • У Линии можно изменить координаты начала или конца
    • У Линии можно запросить координаты начала или конца
Продемонстрируйте работоспособность решения на примерах.
 */
@Data
@NoArgsConstructor
public class ChangedLines {
    private Point start;
    private Point end;

    // Конструктор для создания линии по двум точкам
    public ChangedLines(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // Конструктор для создания линии по четырем координатам (x1, y1, x2, y2)
    public ChangedLines(int x1, int y1, int x2, int y2) {
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
    // Метод для вычисления длины линии
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

