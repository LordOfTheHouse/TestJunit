package com.example.annotation;

import java.util.Arrays;
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
        mp.entrySet().stream().filter(m -> (int) m.getValue() < method.getAnnotation(CustomAnnotation.class).queueNumber())
                .forEach(m -> {
                    try {
                        System.out.println(m.getKey().invoke(this));
                    } catch (Exception e) {
                        return;
                    }
                });

        try {
            System.out.println(method.invoke(this));
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            return;
        }
    }

    @Test
    public void testing() {
        System.out.println(doCommand());
        try {
            startMethods(this.getClass().getDeclaredMethod("printCharacterMethod"));
        } catch (NoSuchMethodException | SecurityException | IllegalMonitorStateException e) {
            return;
        }
    }
}