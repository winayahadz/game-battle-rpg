class Foe extends Character {
    private String name;

    public Foe(String name, int hp, int mp, int armor, String race) {
        super(hp, mp, armor, race);
        this.name = name;
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
        return 10; // Default base damage for Foe
    }

    @Override
    protected int calculateSkillDamage() {
        return 20; // Default skill damage for Foe
    }

    @Override
    protected int getSkillCost() {
        return 10; // Default MP cost for skill
    }
}
class Dragon extends Foe {
    public Dragon(int hp, int mp, int armor, String race) {
        super(race, hp, mp, armor, race);
    }

    @Override
    public void skill(Character target) {
        if (mp >= getSkillCost()) {
            int damage = calculateSkillDamage();
            target.setHp(target.getHp() - damage);
            mp -= getSkillCost();
            System.out.println(getClass().getSimpleName() + " uses fire skill for " + damage + " damage!");
            if (target instanceof Hero) {
                ((Hero) target).addStatus("Weak", 3); // Apply Weak status for 3 turns
                System.out.println(target.getClass().getSimpleName() + " is now weak!");
            }
        } else {
            System.out.println(getClass().getSimpleName() + " does not have enough MP to use skill!");
        }
    }

    @Override
    protected int calculateSkillDamage() {
        return 30; // Customized skill damage for Dragon
    }
}

class Dwarf extends Foe {
    public Dwarf(int hp, int mp, int armor, String race) {
        super(race, hp, mp, armor, race);
    }
    public void attack() {
        System.out.println("Dwarf menendang!");
    }

    public void skill1() {
        if (getMp() >= 50) {
            setMp(getMp() - 50);
        } else {
            System.out.println("Not enough MP to use this skill!");
        }
    }
}

class Elf extends Hero implements Healer {
    public Elf(String name, int hp, int mp, String race, Weapon weapon) {
        super(name, hp, mp, race, weapon);
    }

    @Override
    public void skill(Character target) {
        System.out.println(getName() + " uses Lullaby, putting " + target.getClass().getSimpleName() + " to sleep!");
        target.addStatus("Sleep", 1);
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

class Goblin extends Foe {
    public Goblin(int hp, int mp, int armor, String race) {
        super(race, hp, mp, armor, race);
    }

    public void attack() {
        System.out.println("Goblin menyerang!");
    }

    public void skill1() {
        if (getMp() >= 50) {
            setMp(getMp() - 50);
        } else {
            System.out.println("Not enough MP to use this skill!");
        }
    }
}
class Orc extends Foe {
    public Orc(int hp, int mp, int armor, String race) {
        super(race, hp, mp, armor, race);
    }
    public void attack() {
        System.out.println("Dwarf menendang!");
    }

    public void skill1() {
        if (getMp() >= 50) {
            setMp(getMp() - 50);
        } else {
            System.out.println("Not enough MP to use this skill!");
        }
    }
}

class Skeleton extends Foe {
    public Skeleton(int hp, int mp, int armor, String race) {
        super(race, hp, mp, armor, race);
    }

    public void attack() {
        System.out.println("Skeleton mencabut tulang!");
    }

    public void skill1() {
        if (getMp() >= 50) {
            setMp(getMp() - 50);
        } else {
            System.out.println("Not enough MP to use this skill!");
        }
    }
}
