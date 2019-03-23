package weapon;
import java.util.Objects;

public abstract class Weapon implements IExtendedMagazine, IAssaultGrip, IAim{
    protected String weaponClass;   // класс оружия(пистолет, автомат и т.д.)
    private String name;            // наименование
    private int damage;             // урон
    private int cost;               // стоимость

    protected Weapon(){}

    public Weapon(String name, int damage, int cost){
        this.name = name;
        this.damage = damage;
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Weapon other = (Weapon)otherObject;
        return weaponClass.equals(other.weaponClass)
                && name.equals(other.name)
                && damage == other.damage
                && cost == other.cost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weaponClass, name, damage, cost);
    }
}
