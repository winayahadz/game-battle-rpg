public class Foe extends Character {

    private String race;
    private String name;

    public Foe(int hp, int mp, int armor, String race) {
        super(hp, mp, armor, race);
    }

    public String getRace() {
        return race;
    }

    public String getName() {
        return name;
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
