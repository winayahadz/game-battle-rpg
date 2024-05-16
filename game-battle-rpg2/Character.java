import java.util.*;

abstract class Character implements Attacker, ItemUser {
    protected int hp;
    protected int mp;
    protected int armor;
    protected String race;
    protected Map<String, Integer> statuses;

    public Character(int hp, int mp, int armor, String race) {
        this.hp = hp;
        this.mp = mp;
        this.armor = armor;
        this.race = race;
        this.statuses = new HashMap<>();
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void addStatus(String status, int duration) {
        statuses.put(status, duration);
    }

    public void removeStatus(String status) {
        statuses.remove(status);
    }

    public boolean hasStatus(String status) {
        return statuses.containsKey(status);
    }

    public void clearAllStatuses() {
        statuses.clear();
    }

    @Override
    public void useItem(Item item) {
        item.use(this);
    }

    protected abstract int calculateDamage();

    protected abstract int calculateSkillDamage();

    protected abstract int getSkillCost();

    public void performAction() {
        // Periksa apakah karakter terkena status "Sleep"
        if (hasStatus("Sleep")) {
            System.out.println(getClass().getSimpleName() + " is asleep and cannot perform any action!");
            removeStatus("Sleep"); // Hapus status "Sleep" setelah satu siklus
            return;
        }

        // Kurangi HP karakter jika terkena status "Poison"
        if (hasStatus("Poison")) {
            int poisonDamage = 10; // Pengurangan HP karena status "Poison"
            System.out.println(getClass().getSimpleName() + " takes " + poisonDamage + " damage from Poison!");
            hp -= poisonDamage;
        }
    }

}

interface Attacker {
    void attack(Character target);

    void skill(Character target);
}

interface ItemUser {
    void useItem(Item item);
}

interface Healer {
    void heal(Character target);

    void recover(Character target);
}
