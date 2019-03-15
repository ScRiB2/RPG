package weapon.firearms;

import weapon.firearms.Firearms;

public class Shotgun extends Firearms {

    public Shotgun(String name, int damage){
        setName(name);
        setDamage(damage);
        weaponClass = "Дробовик";
    }

    public Shotgun(String name, int damage, int cost, int capacity, int accuracy){
        super(name, damage, cost, capacity, accuracy);
        weaponClass = "Дробовик";
    }

    public void setExtendedMagazine() {
    }

    public void setAssaultGrip(){
    }

    public void setAim() {
        setAccuracy(getAccuracy() + (int) (0.05 * getAccuracy()));
    }
}
