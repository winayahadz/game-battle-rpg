public class Foe extends Character {

    private String race;
    private Weapon wpn;

    public Foe(int level, int maxHP, int maxMP, String race, Weapon weapon) {
        super(level, maxHP, maxMP ,race);
    }

    public Weapon getWeapon() {
        return wpn;

    }

    public void setWeapon(Weapon wpn) {

    }

    public String getRace() {
        return race;
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
