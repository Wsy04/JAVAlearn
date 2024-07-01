public class Goods {
    private String id;
    private String name;
    private double price;
    private double capacity;

    public Goods() {
    }

    public Goods(String id, String name, double price, double capacity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.capacity = capacity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getCapacity() {
        return capacity;
    }

    public void printInfo(){
        System.out.println("id:"+this.getId()+" name:"+this.getName()+" " +
                "price:"+this.getPrice()+" capacity:"+this.getCapacity());

    }
}
