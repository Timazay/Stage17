package by.itstep.timazay.stage17.ooplesson.model.entity;

public class Armor extends Ammunition{
    private int defense;

    public Armor(String name, double price, double weight, int defense) {
        super(name, price, weight);
        if (defense > 0) {
            this.defense = defense;
        }
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return super.toString() + ", protection = " + defense;
    }
}
