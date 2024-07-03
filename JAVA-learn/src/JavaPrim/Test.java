package JavaPrim;

import java.util.*;

public class Test {

    public static void main(String[] args){
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
        test7();
    }
    public static void swap(int[] arr,int i,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int sum(int[] arr){
        int sum = 0;
        for (int i : arr) {
            sum+=i;
        }
        return sum;
    }
    public static void test1(){
        int[] numbs = new int[10];
        Random r = new Random();
        for (int i = 0; i < numbs.length; i++) {
            numbs[i] = r.nextInt(100);
        }
        for (int num : numbs) {
            System.out.print(num + " ");
        }
        for (int i = 0; i < numbs.length; i++) {
            swap(numbs,i,r.nextInt(numbs.length));
        }
        System.out.println();
        for (int num : numbs) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println(sum(numbs));
    }
    public static void test2(){
        int[] nums = new int[10];
        Random r = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(20)+1;
        }
        travelList(nums);
        System.out.println();
        System.out.println("MaxValue:"+maxOfList(nums));
        System.out.println("15 is Exist? "+isExist(nums,15));
        int[] newarr = copyOfRange(nums,1,5);
        for (int i : newarr) {
            System.out.print(i+" ");
        }
    }
    public static void travelList(int[] arr){
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
    public static int maxOfList(int[] arr){
        int res = arr[0];
        for (int i : arr) {
            if(i>res)
                res = i;
        }
        return res;
    }
    public static boolean isExist(int[] arr,int target){
        for (int i : arr) {
            if(i==target) return true;
        }
        return false;
    }
    public static int[] copyOfRange(int []arr,int from,int to){
        int[] newarr = new int[to-from];
        for (int i = from; i < to; i++) {
            newarr[i-from] = arr[i];
        }
        return newarr;
    }
    public static class rate{
        double top;
        double commecial;
        public void rate(double top,double commecial){
            this.top = top;
            this.commecial = commecial;
        }
        public void setTop(double top){
            this.top = top;
        }
        public void setCommecial(double commecial){
            this.commecial = commecial;
        }
        public double getTop(){
            return top;
        }
        public double getCommecial(){
            return commecial;
        }
    }
    public static void test3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the value of the ticket:");
        int ticket = sc.nextInt();
        System.out.println("Please input the current month:");
        int month = sc.nextInt();
        System.out.println("Please input the status you want to buy 0 means top,1 means commercial:");
        int status = sc.nextInt();
        rate r = new rate();
        if(month>=5&&month<=10){
            r.setTop(0.9);
            r.setCommecial(0.85);
        }
        else{
            r.setTop(0.7);
            r.setCommecial(0.65);
        }
        double value = 0;
        switch (status){
            case 0:
                value = (double) ticket* r.getTop();
                break;
            case 1:
                value = (double) ticket* r.getCommecial();
                break;
            default:
                break;
        }
        System.out.println(value);
    }
    public static void test4(){
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        ArrayList<Integer> arr = PrimeList(start,end);
        System.out.println("There is "+arr.size() +" prime numbers from "+start+" to "+end);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
    public static ArrayList<Integer> PrimeList(int start,int end){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = start;i<=end;i++){
            if(IsPrime(i)) {
                list.add(i);
            }
        }
        return list;
    }
    public static boolean IsPrime(int x){
        if(x<2) return false;
        for(int i=2;i*i<=x;i++){
            if(x%i==0) return false;
        }
        return true;
    }
    public static void test5(){
//        System.out.println(evaluate(6));
        String str = "1983";
        String encrytedStr = encrypt(str);
        System.out.println(encrytedStr);
        String decrytedStr = decrypt(encrytedStr);
        System.out.println(decrytedStr);
    }
    public static String GenerateCode(int len,int pos){
        Random r = new Random();
        char[] letters = new char[52];
        for (int i = 0; i < letters.length; i++) {
            if(i<26) letters[i] = (char)('a'+i);
            else  letters[i] = (char)('A'-26+i);
        }
        String code = "";
        for (int i = 0; i < len; i++) {
            if(i!=pos)
            code+=(letters[r.nextInt(letters.length)]);
            else code+=(r.nextInt(10));
        }
        return code;
    }
    public static int[] randomArray(int len,int left,int right){
        Random r = new Random();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = r.nextInt(right-left+1)+left;
        }
        return arr;
    }
    public static double evaluate(int len){
        int[] arr = randomArray(len,0,100);
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        int min = arr[0];
        int max = min;
        for (int i : arr) {
            if(i>max) max = i;
            if(i<min) min = i;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==max){
                max = i;
                break;
            }

        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==min){
                min = i;
                break;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i==max||i==min) continue;
            sum+=arr[i];
        }
        return (double) sum/(len-2);
    }
    public static String encrypt(String s){
        StringBuilder encryptedString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            encryptedString.append(( s.charAt(i)-'0' + 5)%10);
        }
        return encryptedString.reverse().toString();
    }
    public static String decrypt(String s){
        StringBuilder decryptedString = new StringBuilder(s);
        decryptedString.reverse();
        for (int i = 0; i < s.length(); i++) {
            decryptedString.setCharAt(i,(char) ((decryptedString.charAt(i)-'0'+5)%10+'0'));
        }
        return decryptedString.toString();
    }
    public static void test6(){
        int[] arr = new int[6];
        HashSet<Integer> red = RedSet();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            System.out.println("Please input the number of the "+(i+1)+"th red ball:");
            arr[i] = sc.nextInt();
        }
        System.out.println("Please input the number of the blue ball:");
        int blue = sc.nextInt();
        int prize = doubleColorBall(arr,blue,red);
        System.out.println("prize = "+prize);
    }
    public static HashSet<Integer> RedSet(){
        HashSet<Integer> set = new HashSet<Integer>();
        Random r = new Random();
        for (int i = 0; i < 6;) {
            int ele = r.nextInt(33)+1;
            if(!set.contains(ele)){
                set.add(ele);
                i++;
            }
        }
        System.out.print("red: ");
        for (Integer i : set) {
            System.out.print(i+" ");
        }
        return set;
    }
    public static int doubleColorBall(int[] redArr,int blueBall,HashSet<Integer> set){
        int blue = 10;
        boolean blueRight = (blueBall==blue);
        return getPrize(redArr, set, blueRight);
    }

    private static int getPrize(int[] redArr, HashSet<Integer> set, boolean blueRight) {
        int numRed = 0;
        for (int i : redArr) {
            if(set.contains(i))
                numRed++;
        }
        int prize = 0;
        if(numRed<=2&& blueRight){
            prize = 5;
        }
        else if(numRed==3&& blueRight ||numRed==4&&!blueRight){
            prize = 10;
        }
        else if(blueRight&&numRed==4 ||numRed==5&&!blueRight){
            prize = 200;
        }
        else if(blueRight&&numRed==5 ){
            prize = 3000;
        }
        else if(numRed==6&&!blueRight){
            prize = 5000000;
        }
        else if( blueRight&&numRed==6){
            prize = 10000000;
        }
        return prize;
    }
    public static void test7(){
        int[][] arr1 = {
                {22,66,44},
                {77,33,88},
                {25,45,65}
        };
        for (int[] ints : arr1) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
        int[] arr2 = {4,7,8,9};
        int[] arr3 = {666};
        arr1[0] = arr2;
        for (int[] ints : arr1) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }

    }
}


