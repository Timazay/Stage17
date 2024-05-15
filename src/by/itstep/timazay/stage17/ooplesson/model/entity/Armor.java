package by.itstep.timazay.stage17.ooplesson.model.entity;

import by.itstep.timazay.stage17.ooplesson.model.entity.exception.AmmunitionException.InappropriateСharacteristic;

public class Armor extends Ammunition{
    private int defence;

    public Armor() {
        super();
        defence = 0;
    }

    public Armor(String name, double price, double weight, int defence) {
        super(name, price, weight);
        try {
            if (defence > 0) {
                this.defence = defence;
            } else {
                throw new InappropriateСharacteristic("Incorrect defense");
            }
        } catch (InappropriateСharacteristic e){
            System.err.println(e);
        }

    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        try {
            if (defence > 0) {
                this.defence = defence;
            } else {
                throw new InappropriateСharacteristic("Incorrect defense");
            }
        } catch (InappropriateСharacteristic e){
            System.err.println(e);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", defence = " + defence;
    }
}
