package weapon.firearms;

import weapon.firearms.Firearms;

public class Rifle extends Firearms {
    public Rifle(String name, int damage){
        setName(name);
        setDamage(damage);
        weaponClass = "Автомат";
    }
    public Rifle(String name, int damage, int cost, int capacity, int accuracy){
        super(name, damage, cost, capacity, accuracy);
        weaponClass = "Автомат";
    }


    public void setAim() {
        setAccuracy(getAccuracy() + (int) (0.2 * getAccuracy()));
    }

    public void setExtendedMagazine() {
        setCapacity(getCapacity() + (int) (0.1 * getDamage()));
        setAmount(getCapacity());
    }

    public void setAssaultGrip() {
        setAccuracy(getAccuracy() + (int) (0.3 * getAccuracy()));
    }
}