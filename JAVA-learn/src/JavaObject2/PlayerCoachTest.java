package JavaObject2;

public class PlayerCoachTest {
    public static void main(String[] args) {
        PingPongPlayer pingPongPlayer = new PingPongPlayer("小王", 18);
        BasketballPlayer basketballPlayer = new BasketballPlayer("小李", 16);
        pingPongPlayer.learn();
        pingPongPlayer.speakEnglish();
        basketballPlayer.learn();
        PingPongCoach pingPongCoach = new PingPongCoach("老王", 68);
        BasketballCoach basketballCoach = new BasketballCoach("老李", 56);
        pingPongCoach.teach();
        pingPongCoach.speakEnglish();
        basketballCoach.teach();
    }
}
