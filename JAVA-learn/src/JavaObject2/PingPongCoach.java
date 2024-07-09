package JavaObject2;

public class PingPongCoach extends Coach implements English{
    public PingPongCoach() {
    }

    public PingPongCoach(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("乒乓球教练" + getName() + "的工作是教打乒乓球");
    }

    @Override
    public void speakEnglish() {
        System.out.println("乒乓球教练" + getName() + "会说英语");
    }
}
