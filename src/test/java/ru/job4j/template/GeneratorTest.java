package ru.job4j.template;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GeneratorTest {

    @Test
    public void whenValidTemplateAndArgsThenReturnGeneratedString() {
        Generator generator = new GeneratorGG();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");

        String result = generator.produce(template, args);
        assertEquals("I am a Petr Arsentev, Who are you?", result);
    }

    @Test
    public void whenTemplateHasMissingKeyThenThrowException() {
        Generator generator = new GeneratorGG();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            generator.produce(template, args);
        });

        assertEquals("Missing key: subject", exception.getMessage());
    }

    @Test
    public void whenArgsHasExtraKeyThenThrowException() {
        Generator generator = new GeneratorGG();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        args.put("extraKey", "extraValue");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            generator.produce(template, args);
        });

        assertEquals("Extra key: extraKey", exception.getMessage());
    }

    @Test
    public void whenTemplateIsEmptyThenThrowException() {
        Generator generator = new GeneratorGG();
        String template = "";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            generator.produce(template, args);
        });

        assertEquals("Template cannot be empty", exception.getMessage());
    }

    @Test
    public void whenArgsIsNullThenThrowException() {
        Generator generator = new GeneratorGG();
        String template = "I am a ${name}, Who are ${subject}?";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            generator.produce(template, null);
        });

        assertEquals("Arguments map cannot be null", exception.getMessage());
    }
}
