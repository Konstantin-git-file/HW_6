package org.example.hw.block1_5_methods.task8;

import lombok.Data;
import org.example.hw.block1_5_methods.task3.Point;
import org.example.hw.block1_5_methods.task7.Polyline;

@Data
public class Square {
    private Point topLeft; // Точка левого верхнего угла
    private int sideLength; // Длина стороны

    public Square(Point topLeft, int sideLength) {
        this.topLeft = topLeft;
        this.sideLength = sideLength;
    }

    public Square(int x, int y, int sideLength) {
        this.topLeft = new Point(x, y);
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft.getTextRepresentation() + " со стороной " + sideLength;
    }

    public Polyline getPolyline() {
        Point[] points = {
                topLeft, // Левый верхний угол
                new Point(topLeft.getX() + sideLength, topLeft.getY()), // Правый верхний угол
                new Point(topLeft.getX() + sideLength, topLeft.getY() - sideLength), // Правый нижний угол
                new Point(topLeft.getX(), topLeft.getY() - sideLength), // Левый нижний угол
                topLeft // Замыкаем квадрат (возвращаемся в начальную точку)
        };
        return new Polyline(points);
    }
}