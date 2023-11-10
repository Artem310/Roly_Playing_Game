import Persons.Hero;

public class Dealer {
    private int pricePotion = 5;
    private int healthPotion = 50;

    public int getPricePotion() {
        return pricePotion;
    }

    public int getHealthPotion() {
        return healthPotion;
    }

    public void sale(Hero hero) {
        if (hero.getGold() >= pricePotion && hero.getHealth() < hero.getMaxHealth()) {
            hero.spendGold(pricePotion);
            hero.setHealth(healthPotion);
            System.out.println("Вы купили зелье и ваше здоровье пополнилось на " + healthPotion + ". " + "Теперь Ваше здоровье: " + hero.getHealth() + ", золото: " + hero.getGold());
        } else if (hero.getGold() < pricePotion) {
            System.out.println("Покупка не удалась. У Вас недостаточно денег");
        } else {
            System.out.println("Покупка не удалась. У Вас полное здоровье");
        }
    }
}
