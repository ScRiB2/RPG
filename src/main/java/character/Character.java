package character;
import weapon.Weapon;
import weapon.steelarms.Knife;

import map.Map;

import java.awt.geom.Point2D;
import java.util.Random;

public abstract class Character{
    private String name;
    private int hp = 100;
    private int killed = 0; //количество убитых противников
    private int damage;
    private boolean armor = false;  //есть ли броня
    Weapon weapon;
    Map map;
    Point2D coordinateCharacter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isArmor() {
        return armor;
    }

    public void setArmor(boolean armor) {
        this.armor = armor;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getKilled() {
        return killed;
    }

    public void setKilled(int killed) {
        this.killed = killed;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
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
        coordinateCharacter = new Point2D.Float(x,y);
        map.addNewCharacter(this);
    }
}