package ru.job4j.tdd;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@Ignore
public class GeneratorTest {
    @Test
    public void whenReplacementSuccess() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        Generator generator = new StringGenerator();
        String result = generator.produce(template, args);
        assertThat("I am a Petr Arsentev, Who are you?", is(result));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotEnoughArguments() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("Petr Arsentev", "you");
        Generator generator = new StringGenerator();
        String result = generator.produce(template, args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenExcessArguments() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("Petr Arsentev", "you");
        args.put("subject", "you");
        args.put("subject2", "you");
        Generator generator = new StringGenerator();
        String result = generator.produce(template, args);
    }
}