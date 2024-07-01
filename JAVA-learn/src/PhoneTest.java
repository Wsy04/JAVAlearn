public class PhoneTest {
    public static void main(String[] args){
        Phone[] arr = new Phone[4];
        Phone p1 = new Phone("xiaomi","black",4001);
        Phone p2 = new Phone("apple","white",5001);
        Phone p3 = new Phone("huawei","blue",6002);
        Phone p4 = new Phone("xiaomi","white",4001);
        arr[0] = p1;
        arr[1] = p2;
        arr[2] = p3;
        arr[3] = p4;
        double avg = PhonePriceAvg(arr);
        System.out.println(avg);
        int count = 0;
        for (Phone phone : arr) {
            if (phone.getPrice()<avg){
                count++;
                phone.printInfo();
            }

        }
    }
    public static double PhonePriceAvg(Phone[] arr){
        int len = arr.length;
        int sum = 0;
        for (Phone phone : arr) {
            sum+=phone.getPrice();
        }
        return (double) sum/len;
    }
}
