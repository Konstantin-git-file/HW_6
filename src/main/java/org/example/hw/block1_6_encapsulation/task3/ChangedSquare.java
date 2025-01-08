package org.example.hw.block1_6_encapsulation.task3;

import lombok.Data;
import org.example.hw.block1_5_methods.task3.Point;
import org.example.hw.block1_5_methods.task7.Polyline;

/*
1.6.3 Сторона Квадрата. Измените сущность Квадрат из задачи 1.5.8.
Гарантируйте, что Квадрату невозможно задать отрицательное значение
длины стороны. При попытке задать сторону равной нулю или менее, выбрасывается
ошибка с соответствующим текстом. Контроль должен осуществляться как во время создания
объекта, так и позднее, в случае если будет необходимо менять размеры Квадрата. Необходимо
предоставить возможность изменения длины стороны Квадрата и возможность узнать размер стороны.
 Продемонстрируйте работоспособность решения на примерах.
 */
@Data
public class ChangedSquare {
    private Point topLeft; // Точка левого верхнего угла
    private int sideLength; // Длина стороны

    // Конструктор для создания квадрата с указанием точки и длины стороны
    public ChangedSquare(Point topLeft, int sideLength) {
        setSideLength(sideLength); // Проверка длины стороны
        this.topLeft = topLeft;
    }

    // Конструктор для создания квадрата с указанием координат и длины стороны
    public ChangedSquare(int x, int y, int sideLength) {
        setSideLength(sideLength); // Проверка длины стороны
        this.topLeft = new Point(x, y);
    }

    // Метод для установки длины стороны с проверкой
    public void setSideLength(int sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны должна быть положительным числом.");
        }
        this.sideLength = sideLength;
    }

    // Метод для строкового представления квадрата
    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft.getTextRepresentation() + " со стороной " + sideLength;
    }

    // Метод для получения ломаной, соответствующей углам квадрата
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
