public class Item {

    private int jumlahHp;
    private int jumlahMp;

    public Item(int jumlahHp, int jumlahMp) {
        this.jumlahHp = jumlahHp;
        this.jumlahMp = jumlahMp;
    }

    public void usePotion(Character character, Potion potion) {
        character.usePotion(potion);
    }

    public void useEther(Character character, Ether ether) {
        character.useEther(ether);
    }

    public void useElixir(Character character, Elixir elixir) {
        character.useElixir(elixir);
    }

}

class Elixir extends Item {

    public Elixir(int jumlahHp, int jumlahMp) {
        super(jumlahHp, jumlahMp);
    }
}

class Ether extends Item {

    public Ether(int jumlahHp, int jumlahMp) {
        super(jumlahHp, jumlahMp);
    }
}

class Potion extends Item {

    public Potion(int jumlahHp, int jumlahMp) {
        super(jumlahHp, jumlahMp);
    }
}
