package by.itstep.timazay.stage17.ooplesson.model.entity;

import by.itstep.timazay.stage17.ooplesson.model.entity.exception.AmmunitionException.InappropriateСharacteristic;

public class Ammunition  {
    private String name;
    private double price;
    private double weight;


    public Ammunition() {
        name = "Unknown";
        price = 0;
        weight = 0;
    }

    public Ammunition(String name, double price, double weight) {
        this.name = name;
        try {
            if (price > 0) {
                this.price = price;
            } else {
                throw new InappropriateСharacteristic("Incorrect price");
            }
            if (weight > 0) {
                this.weight = weight;
            } else {
                throw new InappropriateСharacteristic("Incorrect weight");
            }

        } catch (InappropriateСharacteristic e) {
            System.err.println(e);
        }

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
        try {
            if (price > 0) {
                this.price = price;
            } else {
                throw new InappropriateСharacteristic("Incorrect price");
            }
        } catch (InappropriateСharacteristic e) {
            System.err.println(e);
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        try {
            if (weight > 0) {
                this.weight = weight;
            } else {
                throw new InappropriateСharacteristic("Incorrect weight");
            }
        } catch (InappropriateСharacteristic e){
            System.err.println(e);
        }
    }

    @Override
    public String toString() {
        return "name = " + name + ", cost = " + price +
                ", weight = " + weight;
    }
}

