package ru.job4j.ood.srp.report;

import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class XMLReportTest {
    @Test
    void whenGenerated() throws JAXBException {
        MemoryStore store = new MemoryStore();
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
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Report report = new XMLReport(store, parser);
        String expect = """
             <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
             <employees>
                 <employee>
                     <name>Ben Sid</name>
                     <hired>25:03:2025 12:30</hired>
                     <fired>25:03:2025 12:30</fired>
                     <salary>7000.0</salary>
                 </employee>
                 <employee>
                     <name>Den Black</name>
                     <hired>06:06:2025 15:41</hired>
                     <fired>06:06:2025 15:41</fired>
                     <salary>6000.0</salary>
                 </employee>
             </employees>
             """;
        assertThat(report.generate(em -> true)).isEqualTo(expect);
    }
}