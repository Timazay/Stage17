package by.itstep.timazay.stage17.ooplesson.model.entity;

public class Ammunition implements Comparable<Ammunition>{
    private String name;
    private double price;
    private double height;


    public Ammunition(String name, double price, double height) {
        this.name = name;
        if (price > 0) {
            this.price = price;
        }

        if (height > 0) this.height = height;
    }

    public Ammunition() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    @Override
    public String toString() {
        return  "name = " + name + ", cost = " + price +
                ", height = " + height;
    }

    @Override
    public int compareTo(Ammunition ammunition) {
        if (price == ammunition.getPrice() ) {
            return 0;
        }
        if (price < ammunition.getPrice()){
            return -1;
        }

        return 1;
    }
}

