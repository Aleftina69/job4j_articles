package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FoolTest {
    @Test
    void testFizzBuzz() {
        assertEquals("1", Fool.outputFizzBuzz(1));
        assertEquals("2", Fool.outputFizzBuzz(2));
        assertEquals("Fizz", Fool.outputFizzBuzz(3));
        assertEquals("4", Fool.outputFizzBuzz(4));
        assertEquals("Buzz", Fool.outputFizzBuzz(5));
        assertEquals("Fizz", Fool.outputFizzBuzz(6));
        assertEquals("7", Fool.outputFizzBuzz(7));
        assertEquals("FizzBuzz", Fool.outputFizzBuzz(15));
        assertEquals("Fizz", Fool.outputFizzBuzz(18));
        assertEquals("Buzz", Fool.outputFizzBuzz(20));
        assertEquals("FizzBuzz", Fool.outputFizzBuzz(30));
    }
}
