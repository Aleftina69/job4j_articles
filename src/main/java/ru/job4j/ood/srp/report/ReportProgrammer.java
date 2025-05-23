package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportProgrammer implements Report {
    private final DateTimeParser<Calendar> dateTimeParser;
    private final Store store;

    public ReportProgrammer(DateTimeParser<Calendar> dateTimeParser, Store store) {
        this.dateTimeParser = dateTimeParser;
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder builder = new StringBuilder();
        builder.append("Name; Hired; Fired; Salary(")
                .append(");")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            builder.append(employee.getName()).append(";")
                    .append(dateTimeParser.parse(employee.getHired())).append(";")
                    .append(dateTimeParser.parse(employee.getFired())).append(";")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}

