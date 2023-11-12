import Persons.Goblin;
import Persons.Hero;
import Persons.Person;
import Persons.Skeleton;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


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
                    System.out.println("Вы пришли к торговцу");
                    returnCity = false;

                    boolean returnSale = false;

                    do {
                        Dealer dealer = new Dealer();
                        System.out.println("Купить зелье здоровья (восстановит " + dealer.getHealthPotion() + " жизней) за " + dealer.getPricePotion() + " монет? \n1. Купить \n2. Вернуться в город");
                        BufferedReader saleBuffer = new BufferedReader(new InputStreamReader(System.in));
                        int sale = 0;
                        try {
                            sale = Integer.parseInt(saleBuffer.readLine());
                            if (sale == 1) {
                                dealer.sale(hero);
                                returnSale = true;
                            } else if (sale == 2) {
                                returnCity = true;
                                returnSale = false;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Нужно ввести цифру от 1 или 2");
                            returnSale = true;
                        }




                    } while (returnSale);






                } else if (way == 2) {
                    System.out.println("Вы пошли темный лес");
                    returnCity = false;
                    boolean returnBattle = false;

                        do {
                            Fight fight = new Fight(hero, new RandomMonster().getRandomMonster(new Goblin(), new Skeleton()));
                            System.out.println("На Вас напал " + fight.getMonster().getName());
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

