abstract class Item {
    protected String name;

    public Item(String name) {
        this.name = name;
    }

    public abstract void use(Character character);
}
class Potion extends Item {
    public Potion() {
        super("Potion");
    }

    @Override
    public void use(Character character) {
        if (character instanceof Hero) {
            character.setHp(character.getHp() + 100);
            System.out.println(character.getClass().getSimpleName() + " uses Potion and recovers 100 HP!");
        }
    }
}

class Ether extends Item {
    public Ether() {
        super("Ether");
    }

    @Override
    public void use(Character character) {
        if (character instanceof Hero) {
            character.setMp(character.getMp() + 100);
            System.out.println(character.getClass().getSimpleName() + " uses Ether and recovers 100 MP!");
        }
    }
}

class Elixir extends Item {
    public Elixir() {
        super("Elixir");
    }

    @Override
    public void use(Character character) {
        if (character instanceof Hero) {
            character.setHp(character.getHp() + 150);
            character.setMp(character.getMp() + 100);
            System.out.println(character.getClass().getSimpleName() + " uses Elixir and recovers 150 HP and 100 MP!");
        }
    }
}

class Remedy extends Item {
    public Remedy() {
        super("Remedy");
    }

    @Override
    public void use(Character character) {
        character.clearAllStatuses();
        System.out.println(character.getClass().getSimpleName() + " uses Remedy and clears all statuses!");
    }
}

class Antidote extends Item {
    public Antidote() {
        super("Antidote");
    }

    @Override
    public void use(Character character) {
        character.removeStatus("Poison");
        System.out.println(character.getClass().getSimpleName() + " uses Antidote and removes Poison status!");
    }
}
