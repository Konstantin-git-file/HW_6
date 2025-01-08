package org.example.hw.block1_6_encapsulation.task10;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ChangedDepartment {
    private String name;
    private ChangedEmployee manager;
    private List<ChangedEmployee> employees = new ArrayList<>();

    public void setManager(ChangedEmployee manager) {
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

    public void addEmployee(ChangedEmployee employee) {
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

    public void removeEmployee(ChangedEmployee employee) {
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