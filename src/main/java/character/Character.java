package character;
import weapon.Weapon;
import weapon.steelarms.Knife;

import map.Map;

import java.awt.geom.Point2D;
import java.util.Random;

public abstract class Character{
    final private String name;
    private int hp;
    private int killed = 0; //количество убитых противников
    private int damage;
    private boolean armor = false;  //есть ли броня
    Weapon weapon;
    Map map;
    private Point2D coordinate;

    Character(String name){
        this.name = name;
    }

    public Point2D getCoordinate() {
        return coordinate;
    }

    public String getName() {
        return name;
    }

    boolean isArmor() {
        return armor;
    }

    void setArmor(boolean armor) {
        this.armor = armor;
    }

    int getHp() {
        return hp;
    }

    void setHp(int hp) {
        this.hp = hp;
    }

    public int getKilled() {
        return killed;
    }

    void setKilled(int killed) {
        this.killed = killed;
    }

    int getDamage() {
        return damage;
    }

    void setDamage(int damage) {
        this.damage = damage;
    }

    public void action(Character other) {
        if (other.isDie() || this.isDie())
            return;
        this.attack(other);
        // с вероятностью 30% противник контратакует
        if (new Random().nextInt(100) > 70 && !other.isDie()) {
            System.out.println(other.getName() + " контратакует");
            other.attack(this);
        }
    }

    abstract void attack(Character other);

    public void respawn(){
        hp = 100;
        weapon = new Knife();
        damage = weapon.getDamage();
    }

    public boolean isDie(){
        return (hp == 0);
    }

    public void spawn(Map map, int x, int y){
        coordinate = new Point2D.Double(x,y);
        map.addNewCharacter(this);
    }

    @Override
    public boolean equals(Object otherObject) {
        if(!super.equals(otherObject)) return false;
        if(otherObject == null) return false;
        if(getClass() != otherObject.getClass()) return false;
        Character other = (Character)otherObject;
        return name.equals(other.name)
                && hp == other.hp
                && killed == other.killed
                && damage == other.damage
                && armor == other.armor
                && weapon.equals(other);
    }
}