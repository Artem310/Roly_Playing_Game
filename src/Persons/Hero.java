package Persons;

import Persons.Person;

public class Hero extends Person {
    public Hero(String name) {
        super(name);
        this.maxHealth = 100;
        this.health = 100;
        this.agility = 40;
        this.experience = 0;
        this.strength = 10;
        this.gold = 0;
    }

    public void spendGold(int gld) {
        gold = gold - gld;
    }
}
