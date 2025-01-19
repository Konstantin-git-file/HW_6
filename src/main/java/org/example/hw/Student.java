package org.example.hw;

import lombok.Data;

import java.util.Arrays;

@Data
public class Student {
    private String name;
    private int[] grades;

    public Student(String name, int... grades) {
        this.name = name;
        setGrades (grades);
    }

    public void setGrades(int[] grades) {
        if (grades != null) {
            for (int grade : grades) {
                if (grade < 2 || grade > 5) {
                    throw new IllegalArgumentException("Оценка должна быть в диапазоне от 2 до 5");
                }
            }
        }
        this.grades = grades != null ? Arrays.copyOf(grades, grades.length) : null;
    }

    public int[] getGrades() {
        return grades != null ? Arrays.copyOf(grades, grades.length) : null;
    }

    public void addGrade(int grade) {
        if (grade < 2 || grade > 5) {
            throw new IllegalArgumentException("Оценка должна быть в диапазоне от 2 до 5");
        }
        if (grades == null) {
            grades = new int[]{grade};
        } else {
            grades = Arrays.copyOf(grades, grades.length + 1);
            grades[grades.length - 1] = grade;
        }
    }

    public double getAverageGrade() {
        if (grades == null || grades.length == 0) {
            return 0.0; // если оценок нет, то 0
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public boolean isExcellentStudent() {
        if (grades == null || grades.length == 0) {
            return false; // если оценок нет, то получается что студент не отличник
        }
        for (int grade : grades) {
            if (grade != 5) {
                return false;
            }
        }
        return true; // когда все на 5
    }

    @Override
    public String toString() {
        return name + ": " + Arrays.toString(grades);
    }
}