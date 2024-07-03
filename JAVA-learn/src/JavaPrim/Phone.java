package JavaPrim;

public class Phone {
    private String brand;
    private String color;
    private int price;

    public Phone() {
    }

    public Phone(String brand, String color, int price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "JavaPrim.Phone{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
    public void printInfo(){
        String info = this.toString();
        System.out.println(info);
    }
}
