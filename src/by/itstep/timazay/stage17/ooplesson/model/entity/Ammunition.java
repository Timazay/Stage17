package by.itstep.timazay.stage17.ooplesson.model.entity;

public class Ammunition implements Comparable<Ammunition>{
    private String name;
    private double price;
    private double weight;


    public Ammunition(String name, double price, double weight) {
        this.name = name;
        if (price > 0) {
            this.price = price;
        }

        if (weight > 0) this.weight = weight;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    @Override
    public String toString() {
        return  "name = " + name + ", cost = " + price +
                ", height = " + weight;
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

