package character;
import weapon.steelarms.*;

public class Monster extends Character{
    public Monster(String name){
        weapon = new Claws();
        setDamage(weapon.getDamage());
        setName(name);
        setHp(200);
    }

    @Override
    public void attack(Character other) {
        int lost = this.getDamage();
        if (lost > other.getHp())
            lost = other.getHp();
        other.setHp(other.getHp() - lost);
        System.out.println(this.getName() + " наносит " + other.getName() + " " + lost + " урона" +
                " c помощью " + weapon.getName());
        if (other.isDie()) {
            System.out.println(this.getName() + " убивает " + other.getName());
            setKilled(getKilled() + 1);
        }
    }
}
