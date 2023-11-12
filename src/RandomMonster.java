import Persons.Person;

import java.util.Random;

public class RandomMonster {

    public Person getRandomMonster(Person... person) {
        return person[new Random().nextInt(person.length)];
    }

}
