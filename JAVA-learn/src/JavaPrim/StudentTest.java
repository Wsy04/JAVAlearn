package JavaPrim;

import java.util.Objects;

public class StudentTest {
    public static void main(String[] args){
        Student[] arr = new Student[3];
        Student s1 = new Student("001","wsy",19);
        Student s2 = new Student("002","wsy1",20);
        Student s3 = new Student("003","wsy2",19);
        arr[0] = s1;
        arr[1] = s2;
        arr[2] = s3;
        Student s4 = new Student("006","wsy3",21);
        if (!contains(arr,s4.getId())){
            Student[] newarr = new Student[4];
            System.arraycopy(arr,0,newarr,0,arr.length);
            newarr[3] = s4;
            arr = newarr;
        }
        else System.out.println("id重复,插入失败");
        for (Student student : arr) {
            student.printInfo();
        }
        String id = "004";
        if(contains(arr,id)){
            int index = getIndex(arr,id);
            arr[index] = null;
        }
        else System.out.println("查无此人");
        for (Student student : arr) {
            if (student != null)
                student.printInfo();
        }
        if (contains(arr,"003")){
            arr[getIndex(arr,"003")].setAge(arr[getIndex(arr,"003")].getAge()+1);
        }
        for (Student student : arr) {
            if (student != null)
                student.printInfo();
        }
    }
    public static boolean contains(Student[] arr,String id){
        for (Student student : arr) {
            if(Objects.equals(id, student.getId())) return true;
        }
        return false;
    }

    public static int getIndex(Student[] arr,String id){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getId()==id)
                return i;
        }
        return -1;
    }
}
