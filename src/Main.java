import Persons.Goblin;
import Persons.Hero;
import Persons.Person;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// остановился на том, что нужно делать торговца

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Игра началась. Введите имя вашего игрока:");
        BufferedReader nameBuffer = new BufferedReader(new InputStreamReader(System.in));

        Hero hero = new Hero(nameBuffer.readLine());

        System.out.println("Вы создали игрока с именем " + hero.getName() + "\n");
        boolean returnCity = false;

        do {
            System.out.println("Ваш герой: " + hero.toString());
            System.out.println("Куда Вы хотите пойти?\n" + "1. К торговцу\n2. В тёмный лес\n3. На выход\n");
            BufferedReader wayBuffer = new BufferedReader(new InputStreamReader(System.in));
            try {
                int way = Integer.parseInt(wayBuffer.readLine());
                if (way == 1) {
                    System.out.println("Вы пошли к торговцу");
                    returnCity = false;
                } else if (way == 2) {
                    System.out.println("Вы пошли темный лес");
                    returnCity = false;
                    boolean returnBattle = false;

                        do {
                            Fight fight = new Fight(hero, new Goblin("Gobl"));
                            Person winner = fight.thisFight();
                            System.out.println("\nВ битве победил: " + winner);
                            int newBattle = 0;
                            if (hero.getHealth() > 0) {
                                do {
                                    System.out.println("Найти нового врага? \n1. Да, продолжить бой \n2. Нет, вернуться в город");
                                    BufferedReader newBattleReader = new BufferedReader(new InputStreamReader(System.in));
                                    try {
                                        newBattle = Integer.parseInt(newBattleReader.readLine());
                                    } catch (NumberFormatException nfe) {
                                        newBattle = 0;
                                    }
                                    if (newBattle == 1) {
                                        returnBattle = true;
                                    }
                                } while (newBattle < 1 || newBattle > 2);
                            }
                        } while (returnBattle && hero.getHealth() > 0);


                } else if (way == 3) {
                    System.out.println("Вы пошли на выход");
                    returnCity = false;
                } else {
                    System.out.println("Нужно ввести цифру от 1 до 3");
                    returnCity = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести цифру от 1 до 3");
                returnCity = true;
            }


        } while (hero.getHealth() > 0 || returnCity);


        System.out.println("Игра окончена");
    }
}

