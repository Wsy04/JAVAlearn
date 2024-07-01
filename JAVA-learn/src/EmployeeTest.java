public class EmployeeTest{

    public static void main(String[] args){
        /* 使用构造器创建两个对象 */
        Employee empOne = new Employee("RUNOOB1");
        Employee empTwo = new Employee("RUNOOB2");

        // 调用这两个对象的成员方法
        empOne.empAge(26);
        empOne.empDesignation("高级程序员");
        empOne.empSalary(1000);
        empOne.empLocation("Singapore");
        empOne.printEmployee();
        System.out.println();
        empTwo.empAge(21);
        empTwo.empDesignation("菜鸟程序员");
        empTwo.empSalary(500);
        empOne.empLocation("China");
        empTwo.printEmployee();
    }
}