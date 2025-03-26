package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportHRTest {

    @Test
    public void whenGenerateReportThenReturnCorrectFormat() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee emp1 = new Employee("John Doe", now, now, 1000);
        Employee emp2 = new Employee("Jane Smith", now, now, 1500);
        Employee emp3 = new Employee("Alice Johnson", now, now, 1200);
        store.add(emp1);
        store.add(emp2);
        store.add(emp3);
        ReportHR reportHR = new ReportHR(store);
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary();")
                .append(System.lineSeparator())
                .append(emp1.getName()).append(" ")
                .append(emp1.getSalary()).append(System.lineSeparator())
                .append(emp2.getName()).append(" ")
                .append(emp2.getSalary()).append(System.lineSeparator())
                .append(emp3.getName()).append(" ")
                .append(emp3.getSalary()).append(System.lineSeparator());
        assertThat(reportHR.generate(employee -> true)).isEqualTo(expected.toString());
    }
}
