package StudentManageSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManage {
    public static void ManageSystem(){
        final String ADD_STUDENT = "1";
        final String DELETE_STUDENT = "2";
        final String UPDATE_STUDENT = "3";
        final String QUERY_STUDENT = "4";
        final String QUIT = "5";
        String chioce;
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        loop:while (true) {
            System.out.println("---------------");
            System.out.println("学生管理系统");
            System.out.println("1:添加学生");
            System.out.println("2:删除学生");
            System.out.println("3:修改学生");
            System.out.println("4:查询学生");
            System.out.println("5:退出");
            chioce = sc.next();
            switch (chioce) {
                case ADD_STUDENT -> addStudent(students);
                case DELETE_STUDENT ->  deleteStudent(students);
                case UPDATE_STUDENT -> updateStudent(students);
                case QUERY_STUDENT -> inquireStudent(students);
                case QUIT -> {
                    break loop;
//                    System.exit(0);
                }
                default -> System.out.println("无此选项,请重新输入");
            }

        }
    }
    public static void addStudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        Student newStudent = new Student();
        String id;
        while (true) {
            System.out.println("输入要添加的学生id");
            id = sc.next();
            if (existStudent(list,id))
            {
                System.out.println("该学生已存在,重新输入");
            }
            else{
                newStudent.setId(id);
                break;
            }
        }
        System.out.println("输入要添加的学生姓名");
        newStudent.setName(sc.next());
        System.out.println("输入要添加的学生年龄");
        newStudent.setAge(sc.nextInt());
        System.out.println("输入要添加的学生家庭住址");
        newStudent.setAddress(sc.next());
        list.add(newStudent);
        System.out.println("添加成功!");

    }
    public static void deleteStudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        String id;
        System.out.println("输入要删除的学生id");
        id = sc.next();
        int index = findStudent(list,id);
        if (index==-1)
        {
            System.out.println("该学生不存在");
        }
        else{
            list.remove(index);
            System.out.println("删除成功!");
        }

    }
    public static void updateStudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        String id;
        System.out.println("输入要修改的学生id");
        id = sc.next();
        int index = findStudent(list,id);
        if (index==-1)
        {
            System.out.println("该学生不存在");
        }
        else{
            Student newStudent = list.get(index);
            System.out.println("输入修改后的学生姓名");
            newStudent.setName(sc.next());
            System.out.println("输入修改后的学生年龄");
            newStudent.setAge(sc.nextInt());
            System.out.println("输入修改后的学生家庭住址");
            newStudent.setAddress(sc.next());
            System.out.println("添加成功!");
        }


    }
    public static void inquireStudent(ArrayList<Student> list){
        if(list.isEmpty()){
            System.out.println("目前没有录入学生信息");
            return;
        }
        System.out.println("id\t\t姓名\t\t年龄\t\t家庭住址");
        for (Student student : list) {
            student.printInfo();
        }
    }
    public static boolean existStudent(ArrayList<Student> list,String id){
        return findStudent(list, id) != -1;
    }

    public static int findStudent(ArrayList<Student> list,String id){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
}
