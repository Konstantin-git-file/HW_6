package org.example.hw.block1_5_methods.task2;

/*
1.5.2 Кот мяукает. Создайте сущность Кот, которая описывается следующим образом:
    • Имеет Имя (строка)
    • Для создания необходимо указать имя кота.
    • Может быть приведен к текстовой форме вида: “кот: Имя”
    • Может помяукать, что приводит к выводу на экран следующего текста: “Имя: мяу!”, вызвать мяуканье можно без параметров.
    • Может помяукать N раз, что приводит к выводу на экран следующего текста: “Имя: мяу-мяу-…-мяу!”, где количество “мяу” равно N.
Создайте кота по имени “Барсик”, и затем пусть он помяукает сначала один раз, а затем три раза.

 */
public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println(name + ": мяу!");
    }

    public void meow(int n) {
        StringBuilder meowString = new StringBuilder(name + ": ");
        for (int i = 0; i < n; i++) {
            meowString.append("мяу");
            if (i < n - 1) {
                meowString.append("-");
            }
        }
        meowString.append("!");
        System.out.println(meowString);
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }
}