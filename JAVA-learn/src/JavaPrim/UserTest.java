package JavaPrim;

import java.util.Random;

public class UserTest {
    public static void main(String[] args){
        User u1 = new User("wsy",20000,5,5);
        User u2 = new User("Japan",5000,20,20);
        Random r = new Random();
        int round = 1;
        while(true){
            System.out.println("第"+round+"回合:");
            u1.action(r.nextInt(5)+1,u2);
            if(u2.getHealth()==0){
                System.out.println("经过了"+round+"轮苦战，胜负已分,"+u2.getUsername()+"死亡"+u1.getUsername()+"胜利");
                break;
            }
            u2.action(r.nextInt(2)+1,u1);
            if(u1.getHealth()==0){
                System.out.println("经过了"+round+"轮苦战，胜负已分,"+u1.getUsername()+"死亡"+u2.getUsername()+"胜利");
                break;
            }
            else if(round>=20) System.out.println("二位已经战斗了"+round+"回合,实力不分伯仲");
            else if(round>=50) System.out.println("历经"+round+"轮战斗"+"二位至尊打到大道都磨灭了");
            round++;
        }


    }

}
