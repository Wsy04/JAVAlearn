package JavaPrim;

import java.util.Random;

public class User {
    private String username;
    private int health;
    private int power;
    private int magic;
    private int maxHealth;
    public User() {
    }

    public User(String username, int health, int power, int magic) {
        this.username = username;
        this.health = health;
        this.power = power;
        this.magic = magic;
        this.maxHealth = health;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public String getUsername() {
        return username;
    }

    public int getHealth() {
        return health;
    }

    public int getPower() {
        return power;
    }

    public int getMagic() {
        return magic;
    }

    public void heal(){
        Random r = new Random();
        int healValue = r.nextInt(magic);
        int newHealth = healValue+this.getHealth();
        if(newHealth>=this.maxHealth) newHealth = this.maxHealth;
        this.setHealth(newHealth);
        System.out.println(this.getUsername()+"使用治疗技能恢复了"+healValue+"点生命,"
                +this.getUsername()+"剩余"+this.getHealth()+"点血量");

    }

    public void attack(User enemy){
        Random r = new Random();
        int damage = r.nextInt(this.getPower())+1;
        int remainHealth = enemy.getHealth()-damage;
        if(remainHealth<=0) remainHealth = 0;
        enemy.setHealth(remainHealth);
        System.out.println(this.getUsername()+"对"+enemy.getUsername()+"造成了"+damage+"点物理伤害,"
        +enemy.getUsername()+"剩余"+enemy.getHealth()+"点血量");
        if(enemy.getHealth()<=this.getMagic()||enemy.getHealth()<=this.getPower())
            System.out.println(enemy.getUsername()+"的生命已如风中残烛!");
    }
    public void magicAttack(User enemy){
        Random r = new Random();
        int damage = r.nextInt(this.getMagic())+1;
        int remainHealth = enemy.getHealth()-damage;
        if(remainHealth<=0) remainHealth = 0;
        enemy.setHealth(remainHealth);
        System.out.println(this.getUsername()+"对"+enemy.getUsername()+"造成了"+damage+"点魔法伤害,"
                +enemy.getUsername()+"剩余"+enemy.getHealth()+"点血量");
        if(enemy.getHealth()<=this.getMagic()||enemy.getHealth()<=this.getPower())
            System.out.println(enemy.getUsername()+"的生命已如风中残烛!");
    }

    public void trainPower(){
        Random r = new Random();
        int value= r.nextInt(this.getPower()/2)+1;
        int newValue = value+this.getPower();
        this.setPower(newValue);
        System.out.println(this.getUsername()+"强化自身,获得"+value+"点力量,当前力量为:"+this.getPower());
    }

    public void trainMagic(){
        Random r = new Random();
        int value= r.nextInt(this.getMagic()/2)+1;
        int newValue = value+this.getMagic();
        this.setMagic(newValue);
        System.out.println(this.getUsername()+"强化自身,获得"+value+"点智慧,当前智慧为:"+this.getPower());
    }
    public void action(int i,User enemy){
        switch (i){
            case 1:
                this.attack(enemy);
                break;
            case 2:
                this.heal();
                break;
            case 3:
                this.magicAttack(enemy);
                break;
            case 4:
                this.trainPower();
                break;
            case 5:
                this.trainMagic();
                break;
            default:
                System.out.println(this.username+"在发呆,什么也没做！");
                break;
        }
    }
}
