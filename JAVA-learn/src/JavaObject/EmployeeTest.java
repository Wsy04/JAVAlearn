package JavaObject;

public class EmployeeTest {
    public static void main(String[] args) {
        Manager manager = new Manager("001","wang",1000,100);
        manager.printInfo();
        manager.work();
        Staff staff = new Staff("002","wei",100);
        staff.printInfo();
        staff.work();
        eat(staff);
        eat(manager);
        work(staff);
        work(manager);
    }
    public static void eat(Employee employee){
        employee.eat();
    }
    public static void work(Employee employee){
        employee.work();
    }
}
