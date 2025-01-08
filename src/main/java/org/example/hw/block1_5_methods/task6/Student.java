package org.example.hw.block1_5_methods.task6;

import lombok.Data;

import java.util.Arrays;

@Data
public class Student {
    private String name;
    private int[] grades;

    public Student(String name, int... grades) {
        this.name = name;
        this.grades = grades;
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
            return false; // если оценок нет, то считаем, что студент не отличник
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