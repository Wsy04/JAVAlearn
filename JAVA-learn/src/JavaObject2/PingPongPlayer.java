package JavaObject2;

public class PingPongPlayer extends Player implements English{
    public PingPongPlayer() {
    }

    public PingPongPlayer(String name, int age) {
        super(name, age);
    }

    @Override
    public void learn() {
        System.out.println("乒乓球运动员"+getName()+"学乒乓球");
    }

    @Override
    public void speakEnglish() {
        System.out.println("乒乓球运动员"+getName()+"会说英语");
    }
}
