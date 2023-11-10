import Persons.Person;

import java.util.Random;

public class Fight {
    private Person person1, person2;

    public Fight(Person person1, Person person2) {
        this.person1 = person1;
        this.person2 = person2;
    }

    public Person thisFight() {
        boolean firstAttack = true;
        if ((new Random().nextInt(2) + 1) > 1) { firstAttack = false; }

        do {
            if (firstAttack) {
                int timeHealth = person1.getHealth();
                person1.getPunch(person2.getStrength(), person2.getAgility());
                if (person1.getHealth() == timeHealth - person2.getStrength()) {
                    System.out.print("\n" + person2.getName() + " ударил " + person1.getName() + ": " + timeHealth + " - " + person2.getStrength() + " = " + (timeHealth - person2.getStrength()));
                } else if (person1.getHealth() == timeHealth - 2 * person2.getStrength()) {
                    System.out.print("\n" + person2.getName() + " нанес КРИТИЧЕСКИЙ удар " + person1.getName() + ": " + timeHealth + " - " + (2 * person2.getStrength()) + " = " + (timeHealth - person2.getStrength()));
                } else {
                    System.out.print("\n" + person2.getName() + " промахнулся");
                }
            } else {
                int timeHealth = person2.getHealth();
                person2.getPunch(person1.getStrength(), person1.getAgility());
                if (person2.getHealth() == timeHealth - person1.getStrength()) {
                    System.out.print("\n" + person1.getName() + " ударил " + person2.getName() + ": " + timeHealth + " - " + person1.getStrength() + " = " + (timeHealth - person1.getStrength()));
                } else if (person2.getHealth() == timeHealth - 2 * person1.getStrength()) {
                    System.out.print("\n" + person1.getName() + " нанес КРИТИЧЕСКИЙ удар " + person2.getName() + ": " + timeHealth + " - " + (2 * person1.getStrength()) + " = " + (timeHealth - person1.getStrength()));
                } else {
                    System.out.print("\n" + person1.getName() + " промахнулся");
                }
            }
            firstAttack = !firstAttack;
        } while (person1.getHealth() > 0 && person2.getHealth() >  0);
        if (person1.getHealth() > person2.getHealth()) {
            person1.setGold(person2.getGold());
            person1.setExperience(person2.getExperienceForEnemy());
            return person1;
        } else {
            person2.setGold(person1.getGold());
            person2.setExperience(person1.getExperienceForEnemy());
            return person2;
        }
    }

}
