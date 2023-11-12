import Persons.Hero;
import Persons.Person;

import java.util.Random;

public class Fight {
    private Person hero, monster;

    public Fight(Hero hero, Person monster) {
        this.hero = hero;
        this.monster = monster;
    }

    public Person thisFight() throws InterruptedException {
        boolean firstAttack = true;
        if ((new Random().nextInt(2) + 1) > 1) { firstAttack = false; }

        do {
            if (firstAttack) {
                int timeHealth = hero.getHealth();
                hero.getPunch(monster.getStrength(), monster.getAgility());
                if (hero.getHealth() == timeHealth - monster.getStrength()) {
                    System.out.print("\n" + monster.getName() + " ударил " + hero.getName() + ": " + timeHealth + " - " + monster.getStrength() + " = " + (timeHealth - monster.getStrength()));
                } else if (hero.getHealth() == timeHealth - 2 * monster.getStrength()) {
                    System.out.print("\n" + monster.getName() + " нанес КРИТИЧЕСКИЙ удар " + hero.getName() + ": " + timeHealth + " - " + (2 * monster.getStrength()) + " = " + (timeHealth - monster.getStrength()));
                } else {
                    System.out.print("\n" + monster.getName() + " промахнулся");
                }
                Thread.sleep(200);
            } else {
                int timeHealth = monster.getHealth();
                monster.getPunch(hero.getStrength(), hero.getAgility());
                if (monster.getHealth() == timeHealth - hero.getStrength()) {
                    System.out.print("\n" + hero.getName() + " ударил " + monster.getName() + ": " + timeHealth + " - " + hero.getStrength() + " = " + (timeHealth - hero.getStrength()));
                } else if (monster.getHealth() == timeHealth - 2 * hero.getStrength()) {
                    System.out.print("\n" + hero.getName() + " нанес КРИТИЧЕСКИЙ удар " + monster.getName() + ": " + timeHealth + " - " + (2 * hero.getStrength()) + " = " + (timeHealth - hero.getStrength()));
                } else {
                    System.out.print("\n" + hero.getName() + " промахнулся");
                }
            }
            Thread.sleep(200);
            firstAttack = !firstAttack;
        } while (hero.getHealth() > 0 && monster.getHealth() >  0);
        if (hero.getHealth() > monster.getHealth()) {
            hero.setGold(monster.getGold());
            hero.setExperience(monster.getExperienceForEnemy());
            hero.levelUp();
            return hero;
        } else {
            monster.setGold(hero.getGold());
            monster.setExperience(hero.getExperienceForEnemy());
            return monster;
        }
    }

    public Person getMonster() {
        return monster;
    }



}
