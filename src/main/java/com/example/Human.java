package com.example;


public class Human 
{
    private int hp;
    private String name;
    private Reptiloyd creator;

    public Human(String name, Reptiloyd creator){
        this.name = name;
        this.creator = creator;
        hp = 100;
    }

    public void dead(){
        hp = 0;
    }

    public boolean isDead(){
        return hp == 0;
    }

    public boolean reptiloydIsDead(){
        return creator.isDead();
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

}
