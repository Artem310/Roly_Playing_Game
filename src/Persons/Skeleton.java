package Persons;

public class Skeleton extends Person {
    public Skeleton() {
        this.name = "Skeleton";
        this.health = 50;
        this.agility = 15;
        this.experience = 0;
        this.strength = 7;
        this.gold = 10;
        this.experienceForEnemy = (health + agility + strength + gold) / 10;
    }
}