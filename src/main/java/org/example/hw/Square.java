package org.example.hw;

import lombok.Data;

@Data
public class Square {
    private Point topLeft; // Точка левого верхнего угла
    private int sideLength; // Длина стороны

    public Square(Point topLeft, int sideLength) {
        this.topLeft = topLeft;
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft.getTextRepresentation() + " со стороной " + sideLength;
    }

    public Polyline getPolyline() {
        Point[] points = new Point[]{
                topLeft, // Левый верхний угол
                new Point(topLeft.getX() + sideLength, topLeft.getY()),
                new Point(topLeft.getX() + sideLength, topLeft.getY() - sideLength),
                new Point(topLeft.getX(), topLeft.getY() - sideLength),
                topLeft
        };
        return new Polyline(points);
    }
}