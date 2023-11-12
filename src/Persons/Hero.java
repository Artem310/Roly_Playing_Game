package Persons;

import Persons.Person;

public class Hero extends Person {


    public Hero(String name) {
        this.name = name;
        this.maxHealth = 100;
        this.health = 100;
        this.agility = 40;
        this.experience = 0;
        this.maxExperience = 1000;
        this.strength = 10;
        this.gold = 0;
        this.level = 1;
        this.maxLevel = 10;
    }

    public void spendGold(int gld) {
        gold = gold - gld;
    }

    public void levelUp() {
        if (level <= maxLevel && experience <= maxExperience && level * 100 <= experience) {
            level++;
            maxHealth = (int) (maxHealth * 1.1);
            agility = (int) (agility * 1.1);
            strength = (int) (strength * 1.2);
            System.out.println("\n\nВы получили уровень " + level + "!");
        }
    }

}
