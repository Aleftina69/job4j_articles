package ru.job4j.ood.srp.report;

import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JsonReportTest {

    @Test
    void whenAccountantsGenerated() throws JAXBException {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee employee = new Employee("Ben Sid",
                new GregorianCalendar(2025, Calendar.MARCH, 25, 12, 30),
                new GregorianCalendar(2025, Calendar.MARCH, 25, 12, 30),
                7000.0);
        Employee employee1 = new Employee("Den Black",
                new GregorianCalendar(2025, Calendar.JUNE, 6, 15, 41),
                new GregorianCalendar(2025, Calendar.JUNE, 6, 15, 41),
                6000.0);
        store.add(employee);
        store.add(employee1);
        Report engine = new JsonReport(store);
        String ex = """
                 [
                   {
                     "name": "Ben Sid",
                     "hired": "25:03:2025 12:30",
                     "fired": "25:03:2025 12:30",
                     "salary": 7000.0
                   },
                   {
                     "name": "Den Black",
                     "hired": "06:06:2025 15:41",
                     "fired": "06:06:2025 15:41",
                     "salary": 6000.0
                   }
                 ]""";
        assertThat(engine.generate(em -> true)).isEqualTo(ex);
    }
}
