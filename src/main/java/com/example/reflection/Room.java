package com.example.reflection;

public class Room {
    public String name;
    private int size;
    protected int id;

    private Room(int size, int id) {
        this.size = size;
        this.id = id;
    }

    public Room(String name, int size, int id) {
        this(size, id);
        this.name = name;
    }

    public Room() {
    }

    private boolean equalsIdAndSize() throws NullPointerException {
        id = (int) (Math.random() * 10);
        size = (int) (Math.random() * 10);
        return id > size;
    }

    public void thereWasMethodHere() {

    }
}
