package com.example.reflection;

public class Room {
    protected String name;
    private int id;
    public int size;

    private boolean equalsIdAndSize(){
        id = (int) Math.random();
        size = (int) Math.random();
        return id > size;
    }

    private int DigitWal() throws NullPointerException{
        return 4;
    }

}
