package by.itstep.timazay.stage17.ooplesson.model.entity;

public class Armor extends Ammunition{
    private int protection;

    public Armor(String name, double cost, double height, int protection) {
        super(name, cost, height);
        if (protection > 0) {
            this.protection = protection;
        }
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    @Override
    public String toString() {
        return super.toString() + "protection=" + protection +
                '}';
    }
}
