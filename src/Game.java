import Persons.Goblin;
import Persons.Hero;
import Persons.Person;
import Persons.Skeleton;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicBoolean;

public class Game extends Thread {

    Thread newGame = new Thread() {
        public void run() {
            System.out.println("Игра началась. Введите имя вашего игрока:");
            BufferedReader nameBuffer = new BufferedReader(new InputStreamReader(System.in));

            Hero hero;
            try {
                hero = new Hero(nameBuffer.readLine().trim());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Вы создали игрока с именем " + hero.getName() + "\n");
            AtomicBoolean returnCity = new AtomicBoolean(false);

            do {
                System.out.println("Ваш герой: " + hero);
                System.out.println("_________________________\n| Куда Вы хотите пойти? |\n" +
                        "| 1. К торговцу         |\n| 2. В тёмный лес       |\n| 3. На выход           |\n-------------------------");
                BufferedReader wayBuffer = new BufferedReader(new InputStreamReader(System.in));
                try {
                    int way = Integer.parseInt(wayBuffer.readLine().trim());
                    if (way == 1) {
                        System.out.println("Вы пришли к торговцу");
                        returnCity.set(false);

                        boolean returnSale = false;

                        do {
                            Dealer dealer = new Dealer();
                            System.out.println("_____________________________________________________________\n| Купить зелье здоровья (восстановит " + dealer.getHealthPotion() + " жизней) за " + dealer.getPricePotion() + " монет? |\n| 1. Купить                                                 | \n| 2. Вернуться в город                                      |\n-------------------------------------------------------------");
                            BufferedReader saleBuffer = new BufferedReader(new InputStreamReader(System.in));
                            int sale = 0;
                            try {
                                sale = Integer.parseInt(saleBuffer.readLine().trim());
                                if (sale == 1) {
                                    dealer.sale(hero);
                                    returnSale = true;
                                } else if (sale == 2) {
                                    returnCity.set(true);
                                    returnSale = false;
                                } else {
                                    System.out.println("Нужно ввести цифру 1 или 2");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Нужно ввести цифру 1 или 2");
                                returnSale = true;
                            }
                        } while (returnSale);







                    } else if (way == 2) {
                        Thread newBattleT = new Thread(() -> {

                                System.out.println("Вы пошли темный лес"); // строка 1
                                returnCity.set(false);
                                boolean returnBattle = false;

                                do {
                                    Fight fight = new Fight(hero, new RandomMonster().getRandomMonster(new Goblin(), new Skeleton())); // строка 3
                                    System.out.println("На Вас напал " + fight.getMonster().getName());
                                    Person winner = null;
                                    try {
                                        winner = fight.thisFight();
                                    } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                    }
                                    System.out.println("\n\nВ битве победил: " + winner);
                                    int newBattle = 0;
                                    if (hero.getHealth() > 0) { // строка 4
                                        do {
                                            System.out.println("\n_____________________________\n| Найти нового врага?       |\n| 1. Да, продолжить бой     |\n| 2. Нет, вернуться в город |\n-----------------------------");
                                            BufferedReader newBattleReader = new BufferedReader(new InputStreamReader(System.in));
                                            try {
                                                newBattle = Integer.parseInt(newBattleReader.readLine().trim());
                                            } catch (NumberFormatException nfe) {
                                                //System.out.println("Нужно ввести цифру 1 или 2");
                                                newBattle = 0;
                                            } catch (IOException e) {
                                                throw new RuntimeException(e);
                                            }
                                            if (newBattle == 1) {
                                                returnBattle = true;
                                            } else if (newBattle == 2) {
                                                returnBattle = false;
                                                returnCity.set(true);
                                            } else {
                                                System.out.println("Нужно ввести цифру 1 или 2");
                                            }
                                        } while (newBattle < 1 || newBattle > 2);
                                    }
                                } while (returnBattle && hero.getHealth() > 0); // строка 2

                        });
                        newBattleT.start();
                        try {
                            newBattleT.join();
                        } catch (InterruptedException ie) {
                            ie.printStackTrace();
                        }











                    } else if (way == 3) {
                        System.out.println("Вы пошли на выход");
                        returnCity.set(false);
                    } else {
                        System.out.println("Нужно ввести цифру от 1 до 3");
                        returnCity.set(true);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Нужно ввести цифру от 1 до 3");
                    returnCity.set(true);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } while (hero.getHealth() > 0 && returnCity.get());
            System.out.println("\nИгра окончена");
        }

    };







}
