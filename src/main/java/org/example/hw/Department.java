package org.example.hw;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Department {
    private String name;
    private Employee manager;
    private List<Employee> employees = new ArrayList<>();

    public void setManager(Employee manager) {
        if (manager == null) {
            this.manager = null;
            return;
        }
        // Если начальник уже назначен, удаляем его из списка сотрудников
        if (this.manager != null) {
            this.manager.setDepartment(null);
        }
        // Назначаем нового начальника
        this.manager = manager;
        manager.setDepartment(this);
        // Добавляем начальника в список сотрудников, если его там нет
        if (!employees.contains(manager)) {
            employees.add(manager);
        }
    }

    public void addEmployee(Employee employee) {
        if (employee == null || employees.contains(employee)) {
            return; // Игнорируем null и дубликаты
        }
        // Если сотрудник является начальником, не добавляем его в список сотрудников
        if (employee.equals(manager)) {
            return;
        }
        employees.add(employee);
        employee.setDepartment(this);
    }

    public void removeEmployee(Employee employee) {
        if (employee == null) {
            return;
        }
        // Если удаляемый сотрудник является начальником, снимаем его с должности
        if (employee.equals(manager)) {
            setManager(null);
        }
        employees.remove(employee);
        employee.setDepartment(null);
    }
}