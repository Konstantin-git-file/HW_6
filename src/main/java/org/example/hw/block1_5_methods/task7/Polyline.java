package org.example.hw.block1_5_methods.task7;

import lombok.Data;
import org.example.hw.block1_5_methods.task3.Point;

import java.util.Arrays;

/*
1.5.7 Длина Ломаной. Измените сущность Ломаная из задачи 1.4.3.
Новые требования включают:
    • В любой момент к имеющимся Точкам можно добавить новые Точки (добавляется либо массив, либо просто перечень Точек, что приводит к получению нового массива, содержащего как старые, так и новые значения).
    • Может возвращать общую длину Ломаной.
Необходимо выполнить следующие задачи:
    1. Создать Ломаную, проходящую через точки {1;5}, {2;8}, {5;3}
    2. Вывести на экран её длину
    3. Добавить (к ранее созданной Ломаной) точки {5;15}, {8;10}
    4. Снова вывести на экран длину Ломаной

 */
@Data
public class Polyline {
    private Point[] points;

    public Polyline() {
        this.points = new Point[0]; // Пустой массив точек
    }

    public Polyline(Point[] points) {
        this.points = points;
    }

    public void addPoints(Point... newPoints) {
        if (newPoints == null || newPoints.length == 0) {
            return; //  если массив пуст, то ничего
        }
        // старые и новые точки вместе
        Point[] updatedPoints =
                Arrays.copyOf(this.points, this.points.length + newPoints.length);
        System.arraycopy(newPoints, 0, updatedPoints, this.points.length, newPoints.length);
        this.points = updatedPoints;
    }

    public double getLength() {
        double length = 0.0;
        for (int i = 0; i < points.length - 1; i++) {
            Point p1 = points[i];
            Point p2 = points[i + 1];
            // расстояние между двумя точками
            length += Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
        }
        return length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Ломаная [");
        for (int i = 0; i < points.length; i++) {
            result.append(points[i].getTextRepresentation()); // Используем getTextRepresentation для точек
            if (i < points.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    public void shift(int dx, int dy) {
        for (Point point : points) {
            point.setX(point.getX() + dx);
            point.setY(point.getY() + dy);
        }
    }
}