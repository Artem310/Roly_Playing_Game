package Persons;

import java.util.Random;

public abstract class Person {
    protected String name;
    protected int maxHealth, health, agility, experience, maxExperience, level, maxLevel, strength, gold, experienceForEnemy;

    public String getName() {return name;}

    public int getMaxHealth() {
        return maxHealth;
    }
    public int getHealth() {
        return health;
    }

    public int getAgility() {
        return agility;
    }

    public int getExperience() {
        return experience;
    }
    public int getExperienceForEnemy() {
        return experienceForEnemy;
    }

    public int getStrength() {
        return strength;
    }

    public int getGold() {
        return gold;
    }

    public void getPunch(int str, int agl) {
        if (agility < (3 * new Random().nextInt(101))) {
            if (agl < new Random().nextInt(101)) {
                health = health - str;
            } else {
                health = health - str * 2;
            }
        }
    }

    public void setGold(int gld) {
        gold = gold + gld;
    }

    public void setExperience(int exp) {
        experience = experience + exp;
    }
    abstract public void levelUp();

    public void setHealth(int hlt) {
        health = health + hlt;
        if (health > maxHealth) health = maxHealth;
    }

    public String toString() {
        return name + ": " + "здоровье: " + health + ", " + "сила: " + strength + ", " + "ловкость: " + agility + ", " + "уровень: " + level + ", " + "опыт: " + experience + ", " + "золото: " + gold;
    }



}
