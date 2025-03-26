package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportAccountant implements Report {
    private final DateTimeParser<Calendar> dateTimeParser;
    private final Store store;
    private final Currency sourse;
    private final Currency target;

    public ReportAccountant(DateTimeParser<Calendar> dateTimeParser, Store store, Currency start, Currency finish) {
        this.dateTimeParser = dateTimeParser;
        this.store = store;
        this.sourse = start;
        this.target = finish;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        InMemoryCurrencyConverter inMemoryCurrencyConverter = new InMemoryCurrencyConverter();
        StringBuilder builder = new StringBuilder();
        builder.append("Name; Hired; Fired; Salary(")
                .append(target.toString())
                .append(");")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            builder.append(employee.getName()).append(" ")
                    .append(dateTimeParser.parse(employee.getHired())).append(" ")
                    .append(dateTimeParser.parse(employee.getFired())).append(" ")
                    .append(inMemoryCurrencyConverter.convert(sourse, employee.getSalary(), target))
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
