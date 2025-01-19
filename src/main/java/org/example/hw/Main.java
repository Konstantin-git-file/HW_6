package org.example.hw;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        /*
        1.5.1 Пистолет стреляет. Создайте сущность Пистолет, которая описывается следующим образом:
        • Имеет Количество патронов (целое число)
        • Может быть создан с указанием начального количества патронов
        • Может быть создан без указания начального количества патронов, в этом случае он изначально заряжен пятью патронами.
        • Может Стрелять, что приводит к выводу на экран текста “Бах!” в том случае, если количество патронов больше нуля, иначе делает “Клац!”. После каждого выстрела (когда вывелся “Бах!”)	 количество патронов уменьшается на один.
        Создайте пистолет с тремя патронами и выстрелите из него пять раз.
         */
        System.out.println("1.5.1.");
        Gun gun = new Gun(3);
        for (int i = 0; i < 5; i++) {
            gun.shoot();
        }
        System.out.println("----------------");

        /*
        1.5.2 Кот мяукает. Создайте сущность Кот, которая описывается следующим образом:
        • Имеет Имя (строка)
        • Для создания необходимо указать имя кота.
        • Может быть приведен к текстовой форме вида: “кот: Имя”
         Может помяукать, что приводит к выводу на экран следующего текста: “Имя: мяу!”, вызвать мяуканье можно без параметров.
        • Может помяукать N раз, что приводит к выводу на экран следующего текста: “Имя: мяу-мяу-…-мяу!”, где количество “мяу” равно N.
        Создайте кота по имени “Барсик”, и затем пусть он помяукает сначала один раз, а затем три раза.
         */
        System.out.println("1.5.2.");
        Cat barsik = new Cat("Барсик");
        System.out.println(barsik);
        barsik.meow();
        barsik.meow(3);
        System.out.println("----------------");

        /*
        1.5.3 Длина Линии. Измените сущность Линия из задачи 1.4.2. Добавьте ей возможность
        возвращать по запросу пользователя расстояние между точками начала и конца (в виде
        целого числа). Создайте линию из точки {1;1} в точку {10;15} и выведите на экран её длину.
         */
        System.out.println("1.5.3.");
        Line line = new Line(new Point(1, 1), new Point(10, 15));
        System.out.println("Длина линии: " + line.getLength());
        System.out.println("----------------");

        /*
        1.5.4. Отец моего отца. Измените сущность Человек из задачи 1.4.6. Добавьте Человеку следующие возможности:
        • Может возвращать Личное имя.
        • Может возвращать Отчество
        • Может возвращать Фамилию. Если Фамилия задана у текущего объекта, то возвращается она, иначе необходимо найти ближайшего (по ветке наследования) родителя у которого Фамилия задана и вернуть её
        Измените метод приведения Человека к строковой форме так, чтобы значение фамилии выбиралось с использованием указанного выше поведения.
         */
        System.out.println("1.5.4.");
        Person ivan = new Person("Иван");
        Person sergey = new Person(new Name("Сергей", "Иванов", null), 0, ivan);
        Person alexander = new Person(new Name("Александр", null, null), 0, sergey);
        System.out.println(ivan);
        System.out.println(sergey);
        System.out.println(alexander);
        System.out.println("Личное имя Александра: " + alexander.getFirstName());
        System.out.println("Фамилия Александра: " + alexander.getLastName());
        System.out.println("Отчество Александра: " + alexander.getMiddleName());
        System.out.println("----------------");

        /*
            1.5.5. Дроби. Создайте сущность Дробь со следующими особенностями:
        • Имеет числитель: целое число
        • Имеет знаменатель: целое число
        • Дробь может быть создана с указанием числителя и знаменателя
        • Может вернуть строковое представление вида “числитель/знаменатель”
        • Может выполнять операции сложения, вычитания, умножения и деления с другой Дробью или целым числом. Результатом операции должна быть новая Дробь (таким образом, обе исходные дроби не изменяются)
    Затем необходимо выполнить следующие задачи:
        1. Создать несколько экземпляров дробей.
        2. Написать по одному примеру использования каждого метода.
        3. Вывести на экран примеры и результаты их выполнения в формате «1/3 * 2/3 = 2/9»
        4. Посчитать f1.sum(f2).div(f3).minus(5)

         */
        System.out.println("1.5.5.");
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
        System.out.println("----------------");

        /*
            1.5.6 Студент отличник. Измените сущность Студент из задачи 1.4.7. Новые требования включают:
        • Студент может возвращать значение своей средней оценки (вещественное число). Если оценок нет, то среднее – 0.
        • Студент может возвращать информацию о том, является ли он отличником или нет (только true или false). Студент является отличником если у него есть хотя бы одна оценка и все оценки только отличные.
    Необходимо выполнить следующие задачи:
        1. Создайте студента Васю с оценками 3,4,5,4
        2. Создайте студента Петю с оценками 5,5,5,5
        3. Выведите для обоих студентов информацию о среднем балле и являются ли они отличниками
         */
        System.out.println("1.5.6.");
        Student vasya = new Student("Вася", 3, 4, 5, 4);
        Student petya = new Student("Петя", 5, 5, 5, 5);
        System.out.println(vasya);
        System.out.println("Средний балл: " + vasya.getAverageGrade());
        System.out.println("Отличник: " + vasya.isExcellentStudent());
        System.out.println(petya);
        System.out.println("Средний балл: " + petya.getAverageGrade());
        System.out.println("Отличник: " + petya.isExcellentStudent());
        System.out.println("----------------");

        /*
            1.5.7 Длина Ломаной. Измените сущность Ломаная из задачи 1.4.3. Новые требования включают:
        • В любой момент к имеющимся Точкам можно добавить новые Точки (добавляется либо массив, либо просто перечень Точек, что приводит к получению нового массива, содержащего как старые, так и новые значения).
        • Может возвращать общую длину Ломаной.
            Необходимо выполнить следующие задачи:
        1. Создать Ломаную, проходящую через точки {1;5}, {2;8}, {5;3}
        2. Вывести на экран её длину
        3. Добавить (к ранее созданной Ломаной) точки {5;15}, {8;10}
        4. Снова вывести на экран длину Ломаной
        */
        System.out.println("1.5.7.");
        Point[] initialPoints = {
                new Point(1, 5),
                new Point(2, 8),
                new Point(5, 3)
        };
        Polyline polyline = new Polyline(initialPoints);
        System.out.println("Исходная ломаная: " + polyline);
        System.out.println("Длина ломаной: " + polyline.getLength());
        // добавляем точки {5;15}, {8;10}
        polyline.addPoints(new Point(5, 15), new Point(8, 10));
        System.out.println("Ломаная после добавления точек: " + polyline);
        System.out.println("Длина ломаной: " + polyline.getLength());
        System.out.println("----------------");

        /*
        1.5.8 Квадрат. Создайте сущность Квадрат. Квадрат описывается следующими характеристиками:
        • Имеет Точку (из задачи 1.4.1) отмечающую левый верхний угол
        • Имеет длину стороны.
        • Создается путем указания точки левого верхнего угла и размера стороны
        • Создается путем указания координаты x и y левого верхнего угла и размера стороны
        • Может быть приведен к строке вида “Квадрат в точке T со стороной N”, где N – длина стороны, а T – результат приведения к строке верхнего левого угла
        • Может возвращать новую Ломаную (из задачи 1.5.7), точки которой соответствуют точкам углов текущего квадрата.
    Необходимо выполнить следующие задачи:
        1. Создайте Квадрат в точке {5;3} со стороной 23
        2. Присвойте в ссылку типа Ломаная результат вызова метода получения Ломаной у ранее созданного квадрата
        3. Выведите на экран общую длину полученной Ломаной
        4. Сдвиньте последнюю Точку Ломаной в позицию {15,25}
        5. Снова выведите на экран длину Ломаной

         */
        System.out.println("1.5.8.");
        Square square = new Square(new Point(5, 3), 23);
        System.out.println(square);
        // ломаная, соответствующая углам квадрата
        Polyline polyline1 = square.getPolyline();
        System.out.println("Ломаная: " + polyline1);
        System.out.println("Длина ломаной: " + polyline1.getLength());
        // сдвигаем последнюю точку ломаной в позицию {15, 25}
        Point[] points = polyline1.getPoints();
        points[points.length - 1] = new Point(15, 25);
        polyline1 = new Polyline(points);
        System.out.println("Ломаная после изменения: " + polyline1);
        System.out.println("Длина ломаной: " + polyline1.getLength());

        //1.6.1.
        /*
        1.6.1 Дом над землей. Измените сущность Дом из задачи 1.4.4. Гарантируйте, что
        у дома всегда будет положительное количество этажей. В случае попытки указать
        отрицательное количество этажей должна выбрасываться соответствующая ошибка.
        Продемонстрируйте работоспособность решения на примерах.
         */
        System.out.println("1.6.1.");
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

        /*
        1.6.2 Непустые Имена. Измените сущность Имя из задачи 1.4.5. Гарантируйте, что:
        • Как минимум один параметр будет иметь не null значение и не пустую строку.
        • Имя неизменяемо.
        Продемонстрируйте работоспособность решения на примерах.
         */
        System.out.println("1.6.2.");
        try {
            Name name1 = new Name("Иванов", "Иван", "Иванович");
            System.out.println(name1);
            Name name2 = new Name("Петр");
            System.out.println(name2);
            Name name3 = new Name("Сергей", "Петров");
            System.out.println(name3);
            Name name4 = new Name(null, null, null);
            System.out.println(name4);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            Name name5 = new Name("", "", "");
            System.out.println(name5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("----------------");

        /* 1.6.3. Сторона Квадрата. Измените сущность Квадрат из задачи 1.5.8.
        Гарантируйте, что Квадрату невозможно задать отрицательное значение длины стороны.
        При попытке задать сторону равной нулю или менее, выбрасывается ошибка с соответствующим
        текстом. Контроль должен осуществляться как во время создания объекта, так и позднее,
        в случае если будет необходимо менять размеры Квадрата. Необходимо предоставить возможность
        изменения длины стороны Квадрата и возможность узнать размер стороны. Продемонстрируйте
        работоспособность решения на примерах.
        */
        System.out.println("1.6.3.");
        try {
            // 1. cоздаем квадрат в точке {5;3} со стороной 23
            Square square2 = new Square(new Point(5, 3), 23);
            System.out.println(square2);
            // 2. получаем ломаную, соответствующую углам квадрата
            Polyline polyline2 = square2.getPolyline();
            System.out.println("Ломаная: " + polyline2);
            // 3. пыводим общую длину ломаной
            System.out.println("Длина ломаной: " + polyline2.getLength());
            // 4. пытаемся изменить длину стороны на отрицательное значение
            square2.setSideLength(-10); // Выбросит исключение
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            // 5. пытаемся создать квадрат с нулевой стороной
            Square invalidSquare = new Square(new Point(1, 1), 0); // Выбросит исключение
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("----------------");

        /*
        1.6.4 Дроби. Измените сущность Дробь из задачи 1.5.5. Реализуйте следующие требования:
        • Дробь не может быть изменена после создания
        • Необходимо корректно обрабатывать отрицательные значения. Учтите, что знаменатель не может быть отрицательным.
        Продемонстрируйте работоспособность решения на примерах.
         */
        System.out.println("1.6.4.");
        try {
            // 1. дробь с отрицательным числителем и знаменателем
            Fraction fraction1 = new Fraction(-3, -4);
            System.out.println("Дробь 1: " + fraction1); // 3/4
            // 2. дробь с отрицательным числителем
            Fraction fraction2 = new Fraction(-2, 5);
            System.out.println("Дробь 2: " + fraction2); // -2/5
            // 3. Сложение
            Fraction sum2 = fraction1.add(fraction2);
            System.out.println("Сумма: " + sum2); // 7/20
            // 4. Вычитание
            Fraction difference2 = fraction1.subtract(fraction2);
            System.out.println("Разность: " + difference2); // 23/20
            // 5. Умножение
            Fraction product3 = fraction1.multiply(fraction2);
            System.out.println("Произведение: " + product3); // -6/20 (упрощается до -3/10)
            // 6. Деление
            Fraction quotient4 = fraction1.divide(fraction2);
            System.out.println("Частное: " + quotient4); // -15/8
            // 7. дробь с нулевым знаменателем
            Fraction invalidFraction = new Fraction(1, 0); // Ошибка
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage()); // Ошибка: Знаменатель не может быть равен нулю.
        }
        System.out.println("----------------");

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
        System.out.println("1.6.5.");
        Gun gun2 = new Gun(7);
        int excess = gun2.reload(3);
        System.out.println("Лишние патроны после первой перезарядки: " + excess);
        for (int i = 0; i < 5; i++) {
            gun2.shoot();
        }
        // заряжаем 8 патронов
        excess = gun2.reload(8);
        System.out.println("Лишние патроны после второй перезарядки: " + excess);
        for (int i = 0; i < 2; i++) {
            gun2.shoot();
        }
        int remaining = gun2.unload();
        System.out.println("Возвращено патронов при разрядке: " + remaining);

        gun2.shoot();
        System.out.println("----------------");

        //1.6.6.
        /*
        Отдельные линии. Измените сущность Линия из задачи 1.5.3. Необходимо, чтобы Линия соответствовала следующим требованиям:
        • Две любые линии не могут ссылаться на один и тот же объект точки.
        • У Линии можно изменить координаты начала или конца
        • У Линии можно запросить координаты начала или конца
        Продемонстрируйте работоспособность решения на примерах.

         */
        System.out.println("1.6.6.");
        Line line1 = new Line(new Point(1, 1), new Point(4, 5));
        System.out.println("Линия 1: " + line1);
        System.out.println("Длина линии 1: " + line1.getLength());
        // 2. Создаем линию с теми же координатами, но новыми объектами точек
        Line line2 = new Line(1, 1, 4, 5);
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

        /*
        1.6.7. Родители остаются. Измените сущность Человек из задачи 1.4.6. Новые требования включают:
        • Отца возможно задать только при создании и в дальнейшем он не изменяется, но его можно получить
        • Имя можно получить в любой момент в виде объекта типа Имя.
         */
        System.out.println("1.6.7.");
        Person father = new Person("Иван Иванов");
        Person son = new Person("Петр", father);
        System.out.println(son.getTextRepresentation());
        System.out.println(son.toString());
        System.out.println("Отец: " + son.getFather().getName());
        System.out.println("----------------");

        /*
        1.6.8. Диапазон оценок. Измените сущность Студент из задачи 1.5.6. Необходимо гарантировать,
        что добавлять Студенту можно только оценки в диапазоне от 2 до 5, при этом у Студента
        всегда можно узнать список оценок.
        Продемонстрируйте на примерах, что нет способа задать Студенту некорректную оценку.
         */
        System.out.println("1.6.8.");
        Student student1 = new Student("Иван", 5, 4, 5);
        System.out.println(student1);
        System.out.println("Средний балл: " + student1.getAverageGrade());
        System.out.println("Отличник? " + student1.isExcellentStudent());

        try {
            Student student2 = new Student("Петр", 5, 6, 4);
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

        /*
        1.6.9 Дороги. Измените сущности из задачи 1.3.3. Гарантируйте, что между двумя городами может быть только одна прямая дорога (другой путь может быть проложен только транзитом через другие города).
        Города можно создавать с указанием заранее заданных путей, в любой момент времени можно добавить новую дорогу в любой город и удалить имеющуюся дорогу.
        При добавлении второй дороги в уже имеющийся путь она не добавляется, а обновляет стоимость пути.
         */
        System.out.println("1.6.9.");
        City moscow = new City("Москва");
        City petersburg = new City("Санкт-Петербург");
        City kazan = new City("Казань");

        moscow.addRoute(petersburg, 700);
        moscow.addRoute(kazan, 800);
        petersburg.addRoute(kazan, 1200);
        System.out.println(moscow);
        System.out.println(petersburg);
        System.out.println(kazan);

        moscow.addRoute(petersburg, 750);
        System.out.println("После обновления маршрута Москва -> Санкт-Петербург:");
        System.out.println(moscow);
        moscow.removeRoute(petersburg);
        System.out.println("После удаления маршрута Москва -> Санкт-Петербург:");
        System.out.println(moscow);

        Map<City, Integer> routes = new HashMap<>();
        routes.put(moscow, 500);
        routes.put(kazan, 900);
        City novosibirsk = new City("Новосибирск", routes);
        System.out.println(novosibirsk);
        System.out.println("----------------");

        /*
        1.6.10 Начальник отдела. Измените сущности полученные в задаче 1.3.4. Необходимо
        гарантировать, что начальник отдела гарантированно работает в том же отделе, в котором он
        начальник.
        Обратите внимание: задача должна быть решена таким образом, чтобы никогда не бросала никаких
        исключений.
         */
        System.out.println("1.6.10.");

        Department itDepartment = new Department();
        itDepartment.setName("IT");

        Employee ivan1 = new Employee();
        ivan1.setName("Иван");
        Employee petr = new Employee();
        petr.setName("Петр");

        itDepartment.setManager(ivan1);
        itDepartment.addEmployee(petr);

        System.out.println(ivan);
        System.out.println(petr);

        itDepartment.setManager(petr);
        System.out.println(ivan);
        System.out.println(petr);

        itDepartment.removeEmployee(ivan1);
        System.out.println(ivan);
        System.out.println(petr);

        Employee serg = new Employee();
        serg.setName("Сергей");
        itDepartment.setManager(serg);
        System.out.println(serg);
    }
}