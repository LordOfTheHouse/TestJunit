package com.example;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Reptiloyd {

    private int hp;
    private int NumberOfHumans;
    private Human human;
    private ArrayList<Human> cloneHumans;

    public Reptiloyd() {
        hp = 10000;
        NumberOfHumans = 0;
    }

    public String createdHuman() {
        if (human != null)
            return "The human has already been created";
        NumberOfHumans = 1;
        human = new Human("Georg", this);
        cloneHumans = new ArrayList<>();
        cloneHumans.add(human);
        return "Human created";
    }

    public boolean cloneHuman() throws LimitedCloneException {
        if (NumberOfHumans == 5)
            throw new LimitedCloneException("Limited clone");
        if (NumberOfHumans == 0)
            return false;
        NumberOfHumans++;
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

    private int getHp() {
        return hp;
    }

    public int getNumberOfHumans() {
        return NumberOfHumans;
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
