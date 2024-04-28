package by.itstep.timazay.stage17.ooplesson.model.entity;

public class Weapon extends Ammunition {
    private double damage;
    private Artifact artifact;

    public Weapon() {
    }

    public Weapon(String name, double cost, double height, double damage) {
        super(name, cost, height);

        if (damage > 0) {
            this.damage = damage;
        }
    }


    public Weapon(Artifact artifact) {

        switch (artifact) {
            case FROSTMOURNE:
                super.setName("Frostmourne");
                super.setCost(666);
                super.setHeight(13);
                damage = 666;
                break;
            case SWORD_OF_MADNESS:
                super.setName("Sword of madness");
                super.setCost(322);
                super.setHeight(6);
                damage = 228;
                break;
            case DEVOURER_OF_WORLDS:
                super.setName("Devourer of worlds");
                super.setCost(1432);
                super.setHeight(24);
                damage = 9999;
                break;

        }


    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public Artifact getArtifact() {
        return artifact;
    }

    @Override
    public String toString() {
        return "Weapon{" + super.toString() +
                "damage=" + damage + '}';
    }
}
