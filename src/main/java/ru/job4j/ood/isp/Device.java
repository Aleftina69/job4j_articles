package ru.job4j.ood.isp;

public interface Device {
    void print();

    void scan();

    void fax();
}

class Printer implements Device {
    @Override
    public void print() {
        System.out.println("Printing document...");
    }

    @Override
    public void scan() {
        throw new UnsupportedOperationException("Scanning not supported");
    }

    @Override
    public void fax() {
        throw new UnsupportedOperationException("Faxing not supported");
    }
}
/*
Причина нарушения: класс Printer реализует интерфейс Device,
но не использует методы scan() и fax(), что приводит к ненужным исключениям.
 */
