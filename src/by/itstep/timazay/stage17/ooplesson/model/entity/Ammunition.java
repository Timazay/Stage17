package by.itstep.timazay.stage17.ooplesson.model.entity;

public class Ammunition {
    private String name;
    private double cost;
    private double height;


    public Ammunition(String name, double cost, double height) {
        this.name = name;
        if (cost > 0) {
            this.cost = cost;
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
        return  " + name = " + name + ", cost = " + cost +
                ", height = " + height;
    }
}

