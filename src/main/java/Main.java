import com.sun.xml.internal.bind.v2.runtime.SwaRefAdapter;
import sun.awt.image.ImageWatched;
import weapon.Weapon;
import weapon.firearms.*;
import character.*;
import weapon.Upgrades;
import map.Map;
import java.util.*;

import java.util.HashSet;

public class Main {
    public static void main(String[] args){
        Map map = new Map();
        Pistol Glock = new Pistol("Glock-18", 28, 200, 20, 50);
        Shotgun SWAG = new Shotgun("SWAG-7", 50,1800,5,30);          //1800
        SniperRifle AWP = new SniperRifle("AWP", 100, 4750, 10, 70); //4750
        Rifle AK = new Rifle("AK-47",36,2700,30,40); //2700


        LinkedList<Weapon> z = new LinkedList<>();
        z.add(Glock);
        z.add(SWAG);



        MyLinkedList<Weapon> c = new MyLinkedList<Weapon>();
        c.add(Glock);
        c.add(SWAG);

        System.out.println(c.isEmpty());

        /*
        Monster mon = new Monster("Кровосос");
        one.spawn(map, 10, 20);
        map.viewMap();
        mon.attack(one);
        one.buyWeapon(Glock).upgradeWeapon(Upgrades.Aim);
        one.buyArmor();
        for (int i = 0; i < 5; i++) {
            while(!two.isDie() && !one.isDie()) {
                one.action(two);
                two.action(one);
            }
            if(two.isDie()) {
                two.respawn();
                two.buyArmor();
            }
            else{
                one.respawn();
                one.buyArmor();
                one.buyWeapon(SWAG);
            }
        }

        System.out.println(one.getName() + ": " + one.getKilled());
        System.out.println(two.getName() + ": " + two.getKilled());*/

    }
}
