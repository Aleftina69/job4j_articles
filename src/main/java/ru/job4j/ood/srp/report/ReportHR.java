package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Comparator;
import java.util.function.Predicate;

public class ReportHR implements Report {
    private final Store store;


    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        InMemoryCurrencyConverter inMemoryCurrencyConverter = new InMemoryCurrencyConverter();
        StringBuilder builder = new StringBuilder();
        builder.append("Name; Salary(")
                .append(");")
                .append(System.lineSeparator());
        Comparator<Employee> comparator = (o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary());
        for (Employee employee : store.findBy(filter)) {
            builder.append(employee.getName()).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}