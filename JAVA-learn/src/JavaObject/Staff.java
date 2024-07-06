package JavaObject;

public class Staff extends Employee{
    public Staff() {
    }

    public Staff(String id, String name, int salary) {
        super(id, name, salary);
    }
    @Override
    public void work(){
        System.out.println(super.getName()+"的工作是听从经理的安排");
    }
    public void printInfo(){
        System.out.println(super.getName()+" "+super.getId()+" "+super.getSalary());
    }
}
