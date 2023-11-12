package Persons;

public class Skeleton extends Person {
    public Skeleton() {
        this.name = "Скелет";
        this.health = 50;
        this.agility = 15;
        this.experience = 0;
        this.maxExperience = 1000;
        this.strength = 7;
        this.gold = 10;
        this.experienceForEnemy = (health + agility + strength + gold) / 5;
        this.level = 1;
        this.maxLevel = 10;
    }

    @Override
    public void levelUp() {

    }
}