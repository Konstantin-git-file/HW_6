package org.example.hw.block1_6_encapsulation;

import org.example.hw.block1_5_methods.task3.Point;
import org.example.hw.block1_5_methods.task7.Polyline;
import org.example.hw.block1_6_encapsulation.task1.House;
import org.example.hw.block1_6_encapsulation.ChangedName;
import org.example.hw.block1_6_encapsulation.task10.ChangedDepartment;
import org.example.hw.block1_6_encapsulation.task10.ChangedEmployee;
import org.example.hw.block1_6_encapsulation.task3.ChangedSquare;
import org.example.hw.block1_6_encapsulation.task4.ChangedFraction;
import org.example.hw.block1_6_encapsulation.task5.ChangedGun;
import org.example.hw.block1_6_encapsulation.task6.ChangedLines;
import org.example.hw.block1_6_encapsulation.task7.ChangedPerson;
import org.example.hw.block1_6_encapsulation.task8.ChangedStudent;
import org.example.hw.block1_6_encapsulation.task9.ChangedCity;

import java.util.HashMap;
import java.util.Map;


public class Main2 {
    public static void main(String[] args) {
        //1.6.1.
        try {
            House house1 = new House(5);
            System.out.println(house1);
            House house2 = new House(-3);
            System.out.println(house2);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            House house3 = new House(0);
            System.out.println(house3);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("----------------");
        // 1.6.2.
        try {
            ChangedName name1 = new ChangedName("Иванов", "Иван", "Иванович");
            System.out.println(name1);
            ChangedName name2 = new ChangedName("Петр");
            System.out.println(name2);
            ChangedName name3 = new ChangedName("Сергей", "Петров");
            System.out.println(name3);
            ChangedName name4 = new ChangedName(null, null, null);
            System.out.println(name4);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            ChangedName name5 = new ChangedName("", "", "");
            System.out.println(name5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("----------------");
        // 1.6.3.
        try {
            // 1. Создаем квадрат в точке {5;3} со стороной 23
            ChangedSquare square = new ChangedSquare(new Point(5, 3), 23);
            System.out.println(square);

            // 2. Получаем ломаную, соответствующую углам квадрата
            Polyline polyline = square.getPolyline();
            System.out.println("Ломаная: " + polyline);

            // 3. Выводим общую длину ломаной
            System.out.println("Длина ломаной: " + polyline.getLength());

            // 4. Пытаемся изменить длину стороны на отрицательное значение
            square.setSideLength(-10); // Выбросит исключение
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            // 5. Пытаемся создать квадрат с нулевой стороной
            ChangedSquare invalidSquare = new ChangedSquare(new Point(1, 1), 0); // Выбросит исключение
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("----------------");
        // 1.6.4.
        try {
            // 1. Создаем дробь с отрицательным числителем и знаменателем
            ChangedFraction fraction1 = new ChangedFraction(-3, -4);
            System.out.println("Дробь 1: " + fraction1);
            // 2. Создаем дробь с отрицательным числителем
            ChangedFraction fraction2 = new ChangedFraction(-2, 5);
            System.out.println("Дробь 2: " + fraction2);
            // 3. Сложение дробей
            ChangedFraction sum = fraction1.add(fraction2);
            System.out.println("Сумма: " + sum);
            // 4. Вычитание дробей
            ChangedFraction difference = fraction1.subtract(fraction2);
            System.out.println("Разность: " + difference);
            // 5. Умножение дробей
            ChangedFraction product = fraction1.multiply(fraction2);
            System.out.println("Произведение: " + product);
            // 6. Деление дробей
            ChangedFraction quotient = fraction1.divide(fraction2);
            System.out.println("Частное: " + quotient);
            // 7. Попытка создать дробь с нулевым знаменателем
            ChangedFraction invalidFraction = new ChangedFraction(1, 0);
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("----------------");
        // 1.6.5 {@link}
        ChangedGun gun = new ChangedGun(7);
        // 2. Заряжаем 3 патрона
        int excess = gun.reload(3);
        System.out.println("Лишние патроны после первой перезарядки: " + excess);
        // 3. Выстреливаем 5 раз
        for (int i = 0; i < 5; i++) {
            gun.shoot();
        }
        // 4. Заряжаем 8 патронов (лишние вернутся)
        excess = gun.reload(8);
        System.out.println("Лишние патроны после второй перезарядки: " + excess);
        // 5. Выстреливаем еще 2 раза
        for (int i = 0; i < 2; i++) {
            gun.shoot();
        }
        // 6. Разряжаем пистолет
        int remaining = gun.unload();
        System.out.println("Возвращено патронов при разрядке: " + remaining);
        // 7. Делаем контрольный выстрел
        gun.shoot();
        System.out.println("----------------");
        //1.6.6.
        ChangedLines line1 = new ChangedLines(new Point(1, 1), new Point(4, 5));
        System.out.println("Линия 1: " + line1);
        System.out.println("Длина линии 1: " + line1.getLength());
        // 2. Создаем линию с теми же координатами, но новыми объектами точек
        ChangedLines line2 = new ChangedLines(1, 1, 4, 5);
        System.out.println("Линия 2: " + line2);
        System.out.println("Длина линии 2: " + line2.getLength());
        // 3. Проверяем, что линии не используют одни и те же объекты точек
        System.out.println("Линия 1 и линия 2 используют одинаковые объекты точек? " + (line1.getStart() == line2.getStart())); // false
        // 4. Изменяем координаты начала линии 1
        line1.setStart(2, 2);
        System.out.println("Линия 1 после изменения начала: " + line1);
        // 5. Изменяем координаты конца линии 2
        line2.setEnd(6, 6);
        System.out.println("Линия 2 после изменения конца: " + line2);
        // 6. Получаем координаты начала и конца линии 1
        Point start = line1.getStart();
        Point end = line1.getEnd();
        System.out.println("Начало линии 1: " + start.getTextRepresentation());
        System.out.println("Конец линии 1: " + end.getTextRepresentation());
        System.out.println("----------------");
        //1.6.7
        ChangedPerson father = new ChangedPerson("Иван Иванов");
        ChangedPerson son = new ChangedPerson("Петр", father);

        System.out.println(son.getTextRepresentation());
        System.out.println(son.toString());
        System.out.println("Отец: " + son.getFather().getName());
        System.out.println("----------------");
        // 1.6.8.
        ChangedStudent student1 = new ChangedStudent("Иван", 5, 4, 5);
        System.out.println(student1);
        System.out.println("Средний балл: " + student1.getAverageGrade());
        System.out.println("Отличник? " + student1.isExcellentStudent());

        try {
            ChangedStudent student2 = new ChangedStudent("Петр", 5, 6, 4);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        student1.addGrade(5);
        System.out.println(student1);

        try {
            student1.addGrade(1);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("----------------");
        // 1.6.9.
        ChangedCity moscow = new ChangedCity("Москва");
        ChangedCity petersburg = new ChangedCity("Санкт-Петербург");
        ChangedCity kazan = new ChangedCity("Казань");

        // Добавляем маршруты
        moscow.addRoute(petersburg, 700);
        moscow.addRoute(kazan, 800);
        petersburg.addRoute(kazan, 1200);

        // Выводим информацию о городах
        System.out.println(moscow);
        System.out.println(petersburg);
        System.out.println(kazan);

        // Пытаемся добавить дублирующий маршрут (стоимость обновится)
        moscow.addRoute(petersburg, 750);
        System.out.println("После обновления маршрута Москва -> Санкт-Петербург:");
        System.out.println(moscow);

        // Удаляем маршрут
        moscow.removeRoute(petersburg);
        System.out.println("После удаления маршрута Москва -> Санкт-Петербург:");
        System.out.println(moscow);

        // Создаем город с заранее заданными маршрутами
        Map<ChangedCity, Integer> routes = new HashMap<>();
        routes.put(moscow, 500);
        routes.put(kazan, 900);
        ChangedCity novosibirsk = new ChangedCity("Новосибирск", routes);
        System.out.println(novosibirsk);
        System.out.println("----------------");
        //1.6.10
        ChangedDepartment itDepartment = new ChangedDepartment();
        itDepartment.setName("IT");

        ChangedEmployee ivan = new ChangedEmployee();
        ivan.setName("Иван");
        ChangedEmployee petr = new ChangedEmployee();
        petr.setName("Петр");

        itDepartment.setManager(ivan);
        itDepartment.addEmployee(petr);

        System.out.println(ivan);
        System.out.println(petr);

        itDepartment.setManager(petr);
        System.out.println(ivan);
        System.out.println(petr);

        itDepartment.removeEmployee(ivan);
        System.out.println(ivan);
        System.out.println(petr);

        ChangedEmployee serg = new ChangedEmployee();
        serg.setName("Сергей");
        itDepartment.setManager(serg);
        System.out.println(serg);
    }
}


