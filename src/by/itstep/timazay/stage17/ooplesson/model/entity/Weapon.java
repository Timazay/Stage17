package by.itstep.timazay.stage17.ooplesson.model.entity;

public class Weapon extends Ammunition{
    private double damage;

    public Weapon(String name, double cost, double height, double damage) {
        super(name, cost, height);
        this.damage = damage;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }
}
