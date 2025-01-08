package org.example.hw.block1_6_encapsulation.task9;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
/*
1.6.9 Дороги. Измените сущности из задачи 1.3.3. Гарантируйте, что между двумя городами может быть только одна прямая дорога (другой путь может быть проложен только транзитом через другие города).
Города можно создавать с указанием заранее заданных путей, в любой момент времени можно добавить новую дорогу в любой город и удалить имеющуюся дорогу.
При добавлении второй дороги в уже имеющийся путь она не добавляется, а обновляет стоимость пути.
 */


@Data
@NoArgsConstructor
public class ChangedCity {
    private String name;
    private Map<ChangedCity, Integer> routes;

    public ChangedCity(String name) {
        this.name = name;
        this.routes = new HashMap<>();
    }

    public ChangedCity(String name, Map<ChangedCity, Integer> routes) {
        this.name = name;
        this.routes = routes != null ? new HashMap<>(routes) : new HashMap<>();
    }

    public void addRoute(ChangedCity destination, int cost) {
        if (destination == null) {
            throw new IllegalArgumentException("Город назначения не может быть null");
        }
        routes.put(destination, cost); // Добавляем или обновляем маршрут
    }

    public void removeRoute(ChangedCity destination) {
        if (destination == null) {
            throw new IllegalArgumentException("Город назначения не может быть null");
        }
        routes.remove(destination); // Удаляем маршрут
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(":\n");
        for (Map.Entry<ChangedCity, Integer> entry : routes.entrySet()) {
            sb.append("  -> ").append(entry.getKey().getName()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}