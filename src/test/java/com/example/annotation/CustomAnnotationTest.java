package com.example.annotation;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.lang.reflect.*;

import org.junit.Test;

public class CustomAnnotationTest {

    @CustomAnnotation(command = "printString", queueNumber = 0)
    public String printStringMethod() {
        return "printString";
    }

    @CustomAnnotation(command = "printInteger", queueNumber = 1)
    public String printIntegerMethod() {
        return "printInteger";
    }

    @CustomAnnotation(command = "printCharacter", queueNumber = 2)
    public String printCharacterMethod() {
        return "printCharacter";
    }

    public Map<Method, Integer> doCommand() {
        return Arrays.stream(this.getClass().getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(CustomAnnotation.class)).collect(Collectors.toMap(Function.identity(),
                        value -> value.getAnnotation(CustomAnnotation.class).queueNumber()));
    }

    public void startMethods(Method method) {
        Map<Method, Integer> mp = doCommand();
        int methodQueueNumber = mp.get(method);
        mp = mp.entrySet().stream().sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        mp.entrySet()
                .forEach(m -> {
                    try {
                        if(m.getValue() <= methodQueueNumber)
                            System.out.println(m.getKey().invoke(this));
                    } catch (Exception e) {
                        return;
                    }
                });
    }

    @Test
    public void startMethodsTest() {
        try {
            startMethods(this.getClass().getDeclaredMethod("printCharacterMethod"));
            startMethods(this.getClass().getDeclaredMethod("printIntegerMethod"));
        } catch (NoSuchMethodException | SecurityException | IllegalMonitorStateException e) {
            return;
        }
    }

    @Test
    public void doCommandTest() {
        System.out.println(doCommand());
    }
}