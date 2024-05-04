package by.itstep.timazay.stage17.ooplesson.model.entity;

public class Weapon extends Ammunition {
    public double damage;
    private Artifact artifact;

    public Weapon() {
    }

    public Weapon(String name, double price, double weight, double damage) {
        super(name, price, weight);

        if (damage > 0) {
            this.damage = damage;
        }
    }


    public Weapon(Artifact artifact) {

        switch (artifact) {
            case FROSTMOURNE:
                super.setName("Frostmourne");
                super.setPrice(666);
                super.setWeight(13);
                damage = 666;
                break;
            case SWORD_OF_MADNESS:
                super.setName("Sword of madness");
                super.setPrice(322);
                super.setWeight(6);
                damage = 228;
                break;
            case DEVOURER_OF_WORLDS:
                super.setName("Devourer of worlds");
                super.setPrice(1432);
                super.setWeight(24);
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
        return  super.toString() +
                ", damage=" + damage;
    }
}
