package by.itstep.timazay.stage17.ooplesson.model.entity;

public class Ammunition extends Object{
    private String name;
    private double cost;
    private double height;


    public Ammunition(String name, double cost, double height) {
        this.name = name;
        this.cost = cost;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    @Override
    public String toString() {
        return "Armour{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", height=" + height;
    }
}

