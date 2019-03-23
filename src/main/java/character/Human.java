package character;

import weapon.*;
import weapon.firearms.Firearms;
import weapon.steelarms.*;
import java.util.Random;

public class Human extends Character implements IArmor{
    private int money = 1000;

    {
        setHp(100);
    }

    public Human(String name){
        super(name);
        weapon = new Knife();
        setDamage(weapon.getDamage());
    }

    public Human buyWeapon(Weapon weapon){
        if(weapon.getCost() > money) {
            System.out.println("Не достаточно средств для покупки");
            return this;
        }
        money -= weapon.getCost();
        this.weapon = weapon;
        setDamage(weapon.getDamage());
        System.out.println(this.getName() + " купил " + weapon.getName());
        return this;
    }

    public void upgradeWeapon(Upgrades upgrade){
        switch (upgrade){
            case Aim:
                if (money >= 200) {
                    weapon.setAim();
                    money -= 200;
                }
                break;
            case Grip:
                if (money >= 300) {
                    weapon.setAssaultGrip();
                    money -= 300;
                }
                break;
            case Magazine:
                if (money >= 300) {
                    weapon.setExtendedMagazine();
                    money -= 300;
                }
                break;
        }
    }

    @Override
    public void attack(Character other) {
        // проверка есть ли патроны в магазине
        if(weapon instanceof Firearms){
            if(((Firearms)weapon).isEmpty()) {
                System.out.println(this.getName() + " закончились патроны");
                return;
            }
        }

        //проверка попал в противника или нет
        boolean hit = false;
        if (weapon instanceof Knife || weapon instanceof Claws){
            // если нож или когти, то 100% попадание
            hit = true;
        }
        else{
            // попадание с вероятностью = точность оружия
            if (new Random().nextInt(100) < ((Firearms) weapon).getAccuracy())
                hit = true;
        }
        if (hit) {
            int resist = other.isArmor() ? 1: 0;
            int lost = this.getDamage() - resist*((int)(0.3 * this.getDamage()));
            //Чтобы не было урона больше, чем хп у противника
            if (lost > other.getHp())
                lost = other.getHp();
            other.setHp(other.getHp() - lost);
            System.out.println(this.getName() + " наносит " + other.getName() + " " + lost + " урона" +
                    " c помощью " + weapon.getName());
            if (other.isDie()) {
                System.out.println(this.getName() + " убивает " + other.getName());
                setKilled(getKilled()+1);
                this.money += 500;
            }
            if(weapon instanceof Firearms){
                // -1 патрон после выстрела
                ((Firearms)weapon).setAmount(((Firearms)weapon).getAmount()-1);
            }
        }
        else
            System.out.println(this.getName() + " не попал");
    }

    @Override
    public void respawn() {
        super.respawn();
        money = 1000;
    }

    public void buyArmor() {
        if(weapon.getCost() > money) {
            System.out.println("Не достаточно средств для покупки");
            return;
        }
        money -= 400;
        setArmor(true);
        System.out.println(this.getName() + " купил броню");
    }

    @Override
    public boolean equals(Object otherObject) {
        if(!super.equals(otherObject)) return false;
        Human other = (Human)otherObject;
        return money == other.money;
    }
}