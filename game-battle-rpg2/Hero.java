abstract class Hero extends Character {
    private String name;
    private Weapon weapon;

    public Hero(String name, int hp, int mp, String race, Weapon weapon) {
        super(hp, mp, 10, race);
        this.name = name;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    @Override
    public void attack(Character target) {
        int damage = calculateDamage();
        target.setHp(target.getHp() - damage);
        System.out.println(name + " attacks for " + damage + " damage!");
    }

    @Override
    public void skill(Character target) {
        if (this.mp >= getSkillCost()) {
            int damage = calculateSkillDamage();
            target.setHp(target.getHp() - damage);
            this.mp -= getSkillCost();
            System.out.println(name + " uses skill for " + damage + " damage!");
        } else {
            System.out.println(name + " does not have enough MP to use skill!");
        }
    }

    @Override
    protected int calculateDamage() {
        return weapon.getAtkPoint();
    }

    @Override
    protected int calculateSkillDamage() {
        return weapon.getAtkPoint() + 10;
    }

    @Override
    protected int getSkillCost() {
        return 10;
    }

    @Override
    public void useItem(Item item) {
        if (item instanceof Potion) {
            usePotion((Potion) item);
        } else if (item instanceof Ether) {
            useEther((Ether) item);
        } else if (item instanceof Elixir) {
            useElixir((Elixir) item);
        } else if (item instanceof Remedy) {
            useRemedy((Remedy) item);
        } else if (item instanceof Antidote) {
            useAntidote((Antidote) item);
        } else {
            System.out.println("Cannot use this item!");
        }
    }

    private void usePotion(Potion potion) {
        setHp(getHp() + 100);
        System.out.println(getClass().getSimpleName() + " uses Potion and recovers 100 HP!");
    }

    private void useEther(Ether ether) {
        setMp(getMp() + 100);
        System.out.println(getClass().getSimpleName() + " uses Ether and recovers 100 MP!");
    }

    private void useElixir(Elixir elixir) {
        setHp(getHp() + 150);
        setMp(getMp() + 100);
        System.out.println(getClass().getSimpleName() + " uses Elixir and recovers 150 HP and 100 MP!");
    }

    private void useRemedy(Remedy remedy) {
        clearAllStatuses();
        System.out.println(getClass().getSimpleName() + " uses Remedy and clears all statuses!");
    }

    private void useAntidote(Antidote antidote) {
        removeStatus("Poison");
        System.out.println(getClass().getSimpleName() + " uses Antidote and removes Poison status!");
    }

    public void dragonFireAttack(Character target) {
        if (target.hasStatus("Weak")) {
            target.removeStatus("Weak");
            System.out.println(target.getClass().getSimpleName() + " loses the Weakness status!");
        }
    }

    public void attackSleep(Character target) {
        int damage = calculateDamage();
        target.setHp(target.getHp() - damage);
        System.out.println(getClass().getSimpleName() + " attacks for " + damage + " damage!");

        // Menangani penghapusan status "Sleep" jika terkena serangan fisik
        if (target.hasStatus("Sleep")) {
            System.out.println(target.getClass().getSimpleName() + " wakes up from sleep!");
            target.removeStatus("Sleep");
        }
    }

}
class Archer extends Hero {
    public Archer(String name, int hp, int mp, String race, Weapon weapon) {
        super(name, hp, mp, race, weapon);
    }

    @Override
    public void skill(Character target) {
        System.out.println(getName() + " uses an accurate Archer skill!");
        target.setHp(target.getHp() - 15);
    }
}

class Fairy extends Hero implements Healer {
    public Fairy(String name, int hp, int mp, String race, Weapon weapon) {
        super(name, hp, mp, race, weapon);
    }

    @Override
    public void skill(Character target) {
        System.out.println(getName() + " uses a magical Fairy skill!");
        target.setHp(target.getHp() - 10);
    }

    @Override
    public void heal(Character target) {
        target.setHp(target.getHp() + 50);
        System.out.println(getName() + " heals " + target.getClass().getSimpleName() + " for 50 HP!");
    }

    @Override
    public void recover(Character target) {
        target.setMp(target.getMp() + 50);
        System.out.println(getName() + " recovers " + target.getClass().getSimpleName() + "'s MP by 50!");
    }
}

class Fighter extends Hero {
    public Fighter(String name, int hp, int mp, String race, Weapon weapon) {
        super(name, hp, mp, race, weapon);
    }

    @Override
    public void skill(Character target) {
        System.out.println(getName() + " uses a strong Fighter skill!");
        target.setHp(target.getHp() - 25);
    }
}
 class Knight extends Hero {
    public Knight(String name, int hp, int mp, String race, Weapon weapon) {
        super(name, hp, mp, race, weapon);
    }

    @Override
    public void skill(Character target) {
        System.out.println(getName() + " uses a powerful Knight skill!");
        target.setHp(target.getHp() - 20);
    }
}
