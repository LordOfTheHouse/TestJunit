package com.example.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

import org.junit.Test;

public class RoomTest {
    @Test
    public void fieldReflection() throws Exception {
        Room room = new Room();
        Class<?> resultGetClass = room.getClass();
        Field privateField = resultGetClass.getDeclaredField("size");
        Field publicField = resultGetClass.getDeclaredField("name");
        Field protectedField = resultGetClass.getDeclaredField("id");
        privateField.setAccessible(true);
        privateField.setInt(room, 3);

        int size = (int) privateField.getInt(room);
        System.out.println(size);
        System.out.println(publicField.getName());
        System.out.println(protectedField.getType());
    }

    @Test
    public void methodReflection() throws Exception {
        Room room = new Room();
        Class<?> resultGetClass = room.getClass();
        Method method = resultGetClass.getDeclaredMethod("equalsIdAndSize");
        method.setAccessible(true);
        System.out.println(method.invoke(room));

        Arrays.stream(resultGetClass.getSuperclass().getDeclaredMethods()).forEach(x -> System.out.println(x.getName()));
        Arrays.stream(method.getExceptionTypes()).forEach(x -> System.out.println(x.getSimpleName()));
    }

    @Test
    public void constructorReflection() throws Exception {
        Constructor<Room> constructor = Room.class.getDeclaredConstructor(int.class, int.class);
        constructor.setAccessible(true);
        Room privateRoom = constructor.newInstance(5, 10);
        System.out.println(privateRoom.id);

        Constructor<Room> publicRoom = Room.class.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println(publicRoom);

        Arrays.stream(publicRoom.getParameterTypes())
                .forEach(parameter -> System.out.println(parameter.getSimpleName()));
    }
}