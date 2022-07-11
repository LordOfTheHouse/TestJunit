package com.example.junit;

import java.util.ArrayList;


public class Reptiloyd {
    private int hp;
    private int numberOfHumans;
    private Human human;
    private ArrayList<Human> cloneHumans;

    public Reptiloyd() {
        hp = 10000;
        numberOfHumans = 0;
    }

    public String createdHuman() {
        if (human != null)
            return "The human has already been created";
        numberOfHumans = 1;
        human = new Human("Georg", this);
        cloneHumans = new ArrayList<>();
        cloneHumans.add(human);
        return "Human created";
    }

    public boolean cloneHuman() throws LimitedCloneException {
        if (numberOfHumans == 5)
            throw new LimitedCloneException("Limited clone");
        if (numberOfHumans == 0)
            return false;
        numberOfHumans++;
        cloneHumans.add(human);
        return true;
    }

    public void humanDead() {
        human.dead();
    }

    public boolean humanIsDead() {
        return human.isDead();
    }

    public void dead() {
        hp = 0;
    }

    public boolean isDead() {
        return hp == 0;
    }

    public int getNumberOfHumans() {
        return numberOfHumans;
    }

    public void setHuman(Human h) {
        human = h;
    }

    public Human getHuman() {
        return human;
    }

    public String getHumanName() {
        return human.getName(); 
    }

}
