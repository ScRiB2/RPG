package weapon.firearms;

import weapon.Weapon;

import java.util.Objects;

/**
 * огнестрельное оружие
 */
public abstract class Firearms extends Weapon {
    private int capacity;   // ёмкость магазина
    private int accuracy;   // точность
    private int amount;     // текущее количество патронов в магазине

    Firearms(){}

    Firearms(String name, int damage, int cost, int capacity, int accuracy){
        super(name,damage,cost);
        this.amount = this.capacity = capacity;
        this.accuracy = accuracy;
    }

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

    public boolean isEmpty(){
        return (amount == 0);
    }

    @Override
    public boolean equals(Object otherObject) {
        if(!super.equals(otherObject)) return false;
        Firearms other = (Firearms)otherObject;
        return capacity == other.capacity
                && accuracy == other.accuracy
                && amount == other.amount;
    }

    @Override
    public int hashCode() {
        return super.hashCode()+ Objects.hash(capacity,accuracy,amount);
    }
}
