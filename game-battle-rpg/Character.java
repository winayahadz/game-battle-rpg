public class Character {

    private int hp;
    private int mp;
    private int armor;
    private String race;

    public Character() {
    }

    public Character(int hp, int mp, int armor, String race) {
        this.hp = hp;
        this.mp = mp;
        this.armor = armor;
        this.race = race;
    }

    public void usePotion(Potion potion) {
        
    }

    public void useElixir(Elixir elixir) {
  
    }

    public void useEther(Ether ether) {
       
    }

    public int getJumlahHp() {
        return hp;
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

    public String getRace() {
        return race;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

}