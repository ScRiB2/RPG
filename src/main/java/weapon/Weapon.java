package weapon;

public abstract class Weapon implements IExtendedMagazine, IAssaultGrip, IAim{
    protected String weaponClass;   // класс оружия(пистолет, автомат и т.д.)
    private String name;            // наименование
    private int damage;             // урон
    private int cost;               // стоимость

    public Weapon(){}

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


}
