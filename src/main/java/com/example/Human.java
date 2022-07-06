package com.example;

public class Human {
    private int hp;
    private String name;
    private Reptiloyd creator;

    public Human(String name, Reptiloyd creator) {
        this.name = name;
        this.creator = creator;
        hp = 100;
    }

    public void dead() {
        hp = 0;
    }

    public boolean isDead() {
        return hp == 0;
    }

    public boolean reptiloydIsDead() {
        return creator.isDead();
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreator(Reptiloyd creator) {
        this.creator = creator;
    }

}
