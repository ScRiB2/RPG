package weapon.firearms;

import weapon.Weapon;

/**
 * огнестрельное оружие
 */
public abstract class Firearms extends Weapon {
    private int capacity;   // ёмкость магазина
    private int accuracy;   // точность
    private int amount;     // текущее количество патрон в магазине

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAccuracy() {
        return accuracy;
    }

    void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    int getCapacity() {
        return capacity;
    }

    void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    Firearms(){}

    Firearms(String name, int damage, int cost, int capacity, int accuracy){
        super(name,damage,cost);
        this.amount = this.capacity = capacity;
        this.accuracy = accuracy;
    }

    public boolean isEmpty(){
        return (amount == 0);
    }
}
