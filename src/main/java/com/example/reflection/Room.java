package com.example.reflection;

public class Room {
    protected String name;
    private int id;
    public int size;

    private boolean equalsIdAndSize() throws NullPointerException{
        id = (int) Math.random();
        size = (int) Math.random();
        return id > size;
    }

    public int DigitWal(){
        return 4;
    }

}
