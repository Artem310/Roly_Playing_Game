package Persons;

public class Goblin extends Person {
    public Goblin() {
        this.name = "Гоблин";
        this.health = 80;
        this.agility = 10;
        this.experience = 0;
        this.maxExperience = 1000;
        this.strength = 10;
        this.gold = 20;
        this.experienceForEnemy = (health + agility + strength + gold) / 5;
        this.level = 1;
        this.maxLevel = 10;
    }

    @Override
    public void levelUp() {

    }
}
