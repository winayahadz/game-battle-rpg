public class Hero extends Character {

    private int level;
    private Weapon wpn;

    public Hero(String name, int level, int maxHP, int maxMP, String race, Weapon weapon) {
        super(maxHP, maxMP, 10, race);
        this.level = level;
    }

    public Weapon getWeapon() {
        return wpn;

    }

    public void setWeapon(Weapon wpn) {

    }
public void attack(Character target) {
        int damage = calculateDamage();
        target.setHp(target.getHp() - damage);
    }

    private int calculateDamage() {
        int baseDamage = 10;
        return baseDamage;
    }
}
