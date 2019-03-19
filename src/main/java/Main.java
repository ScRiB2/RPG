import weapon.firearms.Pistol;
import weapon.firearms.Rifle;
import weapon.firearms.Shotgun;
import weapon.firearms.SniperRifle;
import character.*;
import weapon.Upgrades;
import map.Map;

public class Main {
    public static void main(String[] args){
        Map map = new Map();
        Pistol Glock = new Pistol("Glock-18", 28, 200, 20, 50);
        Shotgun SWAG = new Shotgun("SWAG-7", 50,500,5,30);          //1800
        SniperRifle AWP = new SniperRifle("AWP", 100, 4750, 10, 70); //4750
        Rifle AK = new Rifle("AK-47",36,2700,30,40); //2700

        Human one = new Human("Петя");
        Human two = new Human("Вася");
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
        System.out.println(two.getName() + ": " + two.getKilled());

    }
}
