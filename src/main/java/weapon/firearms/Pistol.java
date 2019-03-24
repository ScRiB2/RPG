package weapon.firearms;

public class Pistol extends Firearms {
    {
        weaponClass = "Пистолет";
    }

    public Pistol(String name, int damage){
        setName(name);
        setDamage(damage);
    }

    public Pistol(String name, int damage, int cost, int capacity, int accuracy){
        super(name, damage, cost, capacity, accuracy);
    }

    public void setAim() {
        setAccuracy(getAccuracy() + (int) (0.1 * getAccuracy()));
    }

    public void setExtendedMagazine() {
        setCapacity(getCapacity() + (int) (0.1 * getCapacity()));
        setAmount(getCapacity());
    }

    public void setAssaultGrip() {}
}