package weapon.firearms;

import weapon.firearms.Firearms;

public class Pistol extends Firearms {
    public Pistol(String name, int damage){
        setName(name);
        setDamage(damage);
        weaponClass = "Пистолет";
    }
    public Pistol(String name, int damage, int cost, int capacity, int accuracy){
        super(name, damage, cost, capacity, accuracy);
        weaponClass = "Пистолет";
    }


    public void setAim() {
        setAccuracy(getAccuracy() + (int) (0.1 * getAccuracy()));
    }


    public void setExtendedMagazine() {
        setCapacity(getCapacity() + (int) (0.1 * getCapacity()));
        setAmount(getCapacity());
    }


    public void setAssaultGrip() {

    }
}