package org.example.hw.block1_6_encapsulation.task4;

import lombok.Data;
import lombok.NoArgsConstructor;
/*
1.6.4 Дроби. Измените сущность Дробь из задачи 1.5.5. Реализуйте следующие
требования:
    • Дробь не может быть изменена после создания
    • Необходимо корректно обрабатывать отрицательные значения. Учтите, что знаменатель не может быть отрицательным.
Продемонстрируйте работоспособность решения на примерах.

 */
@Data
@NoArgsConstructor(force = true)
public final class ChangedFraction {
    private final int numerator;   // Числитель
    private final int denominator; // Знаменатель

    // Конструктор для создания дроби с указанием числителя и знаменателя
    public ChangedFraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        // Убедимся, что знаменатель всегда положительный
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
        // Упрощаем дробь
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
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
    public ChangedFraction add(ChangedFraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new ChangedFraction(newNumerator, newDenominator);
    }

    // Метод для сложения с целым числом
    public ChangedFraction add(int number) {
        return this.add(new ChangedFraction(number, 1));
    }

    // Метод для вычитания другой дроби
    public ChangedFraction subtract(ChangedFraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new ChangedFraction(newNumerator, newDenominator);
    }

    // Метод для вычитания целого числа
    public ChangedFraction subtract(int number) {
        return this.subtract(new ChangedFraction(number, 1));
    }

    // Метод для умножения на другую дробь
    public ChangedFraction multiply(ChangedFraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new ChangedFraction(newNumerator, newDenominator);
    }

    // Метод для умножения на целое число
    public ChangedFraction multiply(int number) {
        return this.multiply(new ChangedFraction(number, 1));
    }

    // Метод для деления на другую дробь
    public ChangedFraction divide(ChangedFraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Деление на ноль невозможно.");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new ChangedFraction(newNumerator, newDenominator);
    }

    // Метод для деления на целое число
    public ChangedFraction divide(int number) {
        return this.divide(new ChangedFraction(number, 1));
    }
}