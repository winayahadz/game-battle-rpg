public class MainGameRPG {
    public static void main(String[] args) {
        // Create weapons
        Weapon sword = new Weapon(15);
        Weapon bow = new Weapon(10);
        Weapon fists = new Weapon(20);
        Weapon magicWand = new Weapon(5);

        // Create heroes
        Hero knight = new Knight("Knight", 200, 100, "Human", sword);
        Hero archer = new Archer("Archer", 150, 100, "Elf", bow);
        Hero fighter = new Fighter("Fighter", 250, 50, "Orc", fists);
        Hero fairy = new Fairy("Fairy", 100, 200, "Fairy", magicWand);
        Hero elf = new Elf("Elf", 120, 150, "Elf", magicWand);

        // Create foes
        Foe goblin = new Goblin(80, 50, 5, "Goblin");
        Foe dragon = new Dragon(300, 200, 20, "Dragon");

        // Use items
        knight.useItem(new Potion());
        knight.useItem(new Ether());
        knight.useItem(new Elixir());

        // Ensure only Healers call heal and recover
        if (elf instanceof Healer) {
            ((Healer) elf).heal(fairy);
            ((Healer) elf).recover(knight);
        }

        if (fairy instanceof Healer) {
            ((Healer) fairy).heal(knight);
        }

        // Attack actions
        goblin.attack(knight);
        dragon.skill(elf);

        // Polymorphism example
        Character character = knight;
        character.attack(goblin);

        character = goblin;
        character.attack(knight);

        // Hero uses skill
        knight.skill(goblin);
        archer.skill(dragon);

        // Foe uses skill
        dragon.skill(fighter);

        // Display final HP
        System.out.println("Knight HP: " + knight.getHp());
        System.out.println("Archer HP: " + archer.getHp());
        System.out.println("Fighter HP: " + fighter.getHp());
        System.out.println("Fairy HP: " + fairy.getHp());
        System.out.println("Elf HP: " + elf.getHp());
        System.out.println("Goblin HP: " + goblin.getHp());
        System.out.println("Dragon HP: " + dragon.getHp());
    }
}