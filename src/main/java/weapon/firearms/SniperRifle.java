package weapon.firearms;

import weapon.firearms.Firearms;

public class SniperRifle extends Firearms {
    {
        weaponClass = "Снайперская винтовка";
    }

    public SniperRifle(String name, int damage){
        setName(name);
        setDamage(damage);
    }

    public SniperRifle(String name, int damage, int cost, int capacity, int accuracy){
        super(name, damage, cost, capacity, accuracy);
    }

    public void setExtendedMagazine() {
        setCapacity(getCapacity() + (int) (0.1 * getCapacity()));
        setAmount(getCapacity());
    }

    public void setAssaultGrip() {}

    public void setAim(){}
}