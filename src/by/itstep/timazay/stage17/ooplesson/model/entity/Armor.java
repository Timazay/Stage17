package by.itstep.timazay.stage17.ooplesson.model.entity;

import by.itstep.timazay.stage17.ooplesson.model.entity.exception.AmmunitionException.InappropriateСharacteristic;

public class Armor extends Ammunition{
    private int defense;

    public Armor() {
        defense = 0;
    }

    public Armor(String name, double price, double weight, int defense) {
        super(name, price, weight);
        try {
            if (defense > 0) {
                this.defense = defense;
            } else {
                throw new InappropriateСharacteristic("Incorrect defense");
            }
        } catch (InappropriateСharacteristic e){
            System.err.println(e);
        }

    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        try {
            if (defense > 0) {
                this.defense = defense;
            } else {
                throw new InappropriateСharacteristic("Incorrect defense");
            }
        } catch (InappropriateСharacteristic e){
            System.err.println(e);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", protection = " + defense;
    }
}
