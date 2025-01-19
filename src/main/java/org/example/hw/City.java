package org.example.hw;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class City {
    private String name;
    private Map<City, Integer> routes;

    public City(String name) {
        this.name = name;
        this.routes = new HashMap<>();
    }

    public City(String name, Map<City, Integer> routes) {
        this.name = name;
        this.routes = routes != null ? new HashMap<>(routes) : new HashMap<>();
    }

    public void addRoute(City destination, int cost) {
        if (destination == null) {
            throw new IllegalArgumentException("Город назначения не может быть null");
        }
        routes.put(destination, cost); // Добавляем или обновляем маршрут
    }

    public void removeRoute(City destination) {
        if (destination == null) {
            throw new IllegalArgumentException("Город назначения не может быть null");
        }
        routes.remove(destination); // Удаляем маршрут
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(":\n");
        for (Map.Entry<City, Integer> entry : routes.entrySet()) {
            sb.append("  -> ").append(entry.getKey().getName()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}