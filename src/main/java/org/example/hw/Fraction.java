package org.example.hw;

import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@NoArgsConstructor
public final class Fraction {
    private int numerator;   // Числитель
    private int denominator; // Знаменатель

    // Конструктор для создания дроби с указанием числителя и знаменателя
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify(); // Упрощаем дробь при создании
    }

    // Метод для упрощения дроби (сокращения)
    private void simplify() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) { // Убедимся, что знаменатель всегда положительный
            numerator *= -1;
            denominator *= -1;
        }
    }

    // Метод для вычисления наибольшего общего делителя (НОД)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Метод для строкового представления дроби
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Метод для сложения с другой дробью
    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод для сложения с целым числом
    public Fraction add(int number) {
        return this.add(new Fraction(number, 1));
    }

    // Метод для вычитания другой дроби
    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод для вычитания целого числа
    public Fraction subtract(int number) {
        return this.subtract(new Fraction(number, 1));
    }

    // Метод для умножения на другую дробь
    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод для умножения на целое число
    public Fraction multiply(int number) {
        return this.multiply(new Fraction(number, 1));
    }

    // Метод для деления на другую дробь
    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Деление на ноль невозможно.");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод для деления на целое число
    public Fraction divide(int number) {
        return this.divide(new Fraction(number, 1));
    }
}
