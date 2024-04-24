public class MainGameRPG {

    public static void main(String[] args) {

        Weapon wp = new Weapon(25);
        Hero hero = new Hero("hero1", 1, 100, 100, "Knight",wp);
        Foe foe = new Foe(100, 100, 100, "orc");

        Potion potion = new Potion(50, 50);
        Elixir elixir = new Elixir(50, 50);
        Ether ether = new Ether(50, 50);

        hero.usePotion(potion);
        hero.useElixir(elixir);
        hero.useEther(ether);

        foe.usePotion(potion);
        foe.useElixir(elixir);
        foe.useEther(ether);

        System.out.println("Hero HP: " + hero.getHp());
        System.out.println("Hero MP: " + hero.getMp());

        System.out.println("Foe HP: " + foe.getHp());
        System.out.println("Foe MP: " + foe.getMp());

    }
}