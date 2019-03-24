package weapon.firearms;

public class Shotgun extends Firearms {
    {
        weaponClass = "Дробовик";
    }

    public Shotgun(String name, int damage){
        setName(name);
        setDamage(damage);
    }

    public Shotgun(String name, int damage, int cost, int capacity, int accuracy){
        super(name, damage, cost, capacity, accuracy);
    }

    public void setExtendedMagazine() {}

    public void setAssaultGrip(){}

    public void setAim() {
        setAccuracy(getAccuracy() + (int) (0.05 * getAccuracy()));
    }
}
