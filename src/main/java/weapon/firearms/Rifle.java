package weapon.firearms;

public class Rifle extends Firearms {
    {
        weaponClass = "Автомат";
    }

    public Rifle(String name, int damage){
        setName(name);
        setDamage(damage);
    }

    public Rifle(String name, int damage, int cost, int capacity, int accuracy){
        super(name, damage, cost, capacity, accuracy);
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