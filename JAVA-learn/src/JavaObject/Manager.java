package JavaObject;

public class Manager extends Employee{
    private int managerBonus;

    public Manager() {
    }

    public Manager(String id, String name, int salary, int managerBonus) {
        super(id, name, salary);
        this.managerBonus = managerBonus;
    }

    public int getManagerBonus() {
        return managerBonus;
    }

    public void setManagerBonus(int managerBonus) {
        this.managerBonus = managerBonus;
    }

    @Override
    public void work() {
        System.out.println(super.getName()+"的工作是管理员工");
    }

    public void printInfo(){
        System.out.println(super.getName()+" "+super.getId()+" "+super.getSalary()+" "+getManagerBonus());
    }
}
