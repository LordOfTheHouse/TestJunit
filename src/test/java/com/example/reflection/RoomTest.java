package com.example.reflection;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class RoomTest {

    @Test
    public void reflectionOfFields() throws NoSuchFieldException, IllegalAccessException {
        Room room = new Room();
        Field fieldPrivate = room.getClass().getDeclaredField("id");
        Field fieldPublic = room.getClass().getDeclaredField("size");
        fieldPrivate.setAccessible(true);
        fieldPrivate.set(room, 10);
        int privateFieldId = (int) fieldPrivate.get(room);
        Class<?> protectedFieldType = room.getClass().getDeclaredField("name").getType();
        
        assertEquals(10, privateFieldId);
        assertEquals("".getClass(), protectedFieldType); 
        assertEquals("size", fieldPublic.getName());
  }

    @Test
    public void reflectionOfMethods() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        Room room = new Room();
        Method method = room.getClass().getDeclaredMethod("equalsIdAndSize");
        method.setAccessible(true);
        System.out.println(method.invoke(room));
    }
}
