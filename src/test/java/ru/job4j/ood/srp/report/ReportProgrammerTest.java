package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportProgrammerTest {

    @Test
    public void whenGenerateReportThenReturnCorrectFormat() {
        MemoryStore store = new MemoryStore();
        Calendar hired = Calendar.getInstance();
        hired.set(2021, Calendar.JANUARY, 1);
        Calendar fired = Calendar.getInstance();
        fired.set(2023, Calendar.JANUARY, 1);
        Employee emp1 = new Employee("Alice Johnson", hired, fired, 1200);
        Employee emp2 = new Employee("John Doe", hired, fired, 1000);
        store.add(emp1);
        store.add(emp2);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        ReportProgrammer reportProgrammer = new ReportProgrammer(parser, store);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary();")
                .append(System.lineSeparator())
                .append(emp1.getName()).append(";")
                .append(parser.parse(emp1.getHired())).append(";")
                .append(parser.parse(emp1.getFired())).append(";")
                .append(emp1.getSalary()).append(System.lineSeparator())
                .append(emp2.getName()).append(";")
                .append(parser.parse(emp2.getHired())).append(";")
                .append(parser.parse(emp2.getFired())).append(";")
                .append(emp2.getSalary()).append(System.lineSeparator());
        assertThat(reportProgrammer.generate(employee -> true)).isEqualTo(expected.toString());
    }
}