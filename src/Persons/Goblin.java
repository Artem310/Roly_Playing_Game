package Persons;

public class Goblin extends Person {
    public Goblin(String name) {
        super(name);
        this.health = 80;
        this.agility = 10;
        this.experience = 0;
        this.strength = 10;
        this.gold = 20;
        this.experienceForEnemy = (health + agility + strength + gold) / 10;
    }
}
