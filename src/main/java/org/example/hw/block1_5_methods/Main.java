package org.example.hw.block1_5_methods;

import org.example.hw.block1_5_methods.task1.Gun;
import org.example.hw.block1_5_methods.task2.Cat;
import org.example.hw.block1_5_methods.task3.Line;
import org.example.hw.block1_5_methods.task3.Point;
import org.example.hw.block1_5_methods.task4.Name;
import org.example.hw.block1_5_methods.task4.Person;
import org.example.hw.block1_5_methods.task5.Fraction;
import org.example.hw.block1_5_methods.task6.Student;
import org.example.hw.block1_5_methods.task7.Polyline;
import org.example.hw.block1_5_methods.task8.Square;

public class Main {
    public static void main(String[] args) {

        // 1.5.1.
        Gun gun = new Gun(3);
        for (int i = 0; i < 5; i++) {
            gun.shoot();
        }

        // 1.5.2.
        Cat barsik = new Cat("Барсик");
        System.out.println(barsik);
        barsik.meow();
        barsik.meow(3);
        // 1.5.3.
        Line line = new Line(new Point(1, 1), new Point(10, 15));
        System.out.println("Длина линии: " + line.getLength());

        // 1.5.4.
        Person ivan = new Person("Иван");
        Person sergey = new Person(new Name("Сергей", "Иванов", null), 0, ivan);
        Person alexander = new Person(new Name("Александр", null, null), 0, sergey);
        System.out.println(ivan);
        System.out.println(sergey);
        System.out.println(alexander);
        System.out.println("Личное имя Александра: " + alexander.getFirstName());
        System.out.println("Фамилия Александра: " + alexander.getLastName());
        System.out.println("Отчество Александра: " + alexander.getMiddleName());

        // 1.5.4.
        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(2, 3);
        Fraction f3 = new Fraction(3, 4);
        Fraction sum = f1.add(f2);
        Fraction difference = f1.subtract(f2);
        Fraction product = f1.multiply(f2);
        Fraction quotient = f1.divide(f2);

        System.out.println(f1 + " + " + f2 + " = " + sum);
        System.out.println(f1 + " - " + f2 + " = " + difference);
        System.out.println(f1 + " * " + f2 + " = " + product);
        System.out.println(f1 + " / " + f2 + " = " + quotient);

        //  f1.sum(f2).div(f3).minus(5)
        Fraction result = f1.add(f2).divide(f3).subtract(5);
        System.out.println(f1 + " + " + f2 + " / " + f3 + " - 5 = " + result);

        //1.5.6.
        Student vasya = new Student("Вася", 3, 4, 5, 4);
        Student petya = new Student("Петя", 5, 5, 5, 5);

        System.out.println(vasya);
        System.out.println("Средний балл: " + vasya.getAverageGrade());
        System.out.println("Отличник: " + vasya.isExcellentStudent());

        System.out.println(petya);
        System.out.println("Средний балл: " + petya.getAverageGrade());
        System.out.println("Отличник: " + petya.isExcellentStudent());

        //1.5.7.
        Point[] initialPoints = {
                new Point(1, 5),
                new Point(2, 8),
                new Point(5, 3)
        };
        Polyline polyline = new Polyline(initialPoints);

        // 2. Выводим длину ломаной
        System.out.println("Исходная ломаная: " + polyline);
        System.out.println("Длина ломаной: " + polyline.getLength());

        // 3. Добавляем точки {5;15}, {8;10}
        polyline.addPoints(new Point(5, 15), new Point(8, 10));

        // 4. Снова выводим длину ломаной
        System.out.println("Ломаная после добавления точек: " + polyline);
        System.out.println("Длина ломаной: " + polyline.getLength());

        //1.5.8.
        Square square = new Square(new Point(5, 3), 23);
        System.out.println(square);

        // 2. Получаем ломаную, соответствующую углам квадрата
        Polyline polyline1 = square.getPolyline();
        System.out.println("Ломаная: " + polyline1);

        // 3. Выводим общую длину ломаной
        System.out.println("Длина ломаной: " + polyline1.getLength());

        // 4. Сдвигаем последнюю точку ломаной в позицию {15, 25}
        Point[] points = polyline1.getPoints();
        points[points.length - 1] = new Point(15, 25); // Изменяем последнюю точку
        polyline1 = new Polyline(points); // Создаем новую ломаную с измененной точкой

        // 5. Снова выводим длину ломаной
        System.out.println("Ломаная после изменения: " + polyline1);
        System.out.println("Длина ломаной: " + polyline1.getLength());
    }
}