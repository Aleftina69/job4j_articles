package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.formatter.CalendarSerializer;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.GregorianCalendar;
import java.util.function.Predicate;

public class JsonReport implements Report {
    private final Store store;

    public JsonReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Gson employeeGson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(GregorianCalendar.class, new CalendarSerializer())
                .create();
        return employeeGson.toJson(store.findBy(filter));
    }
}