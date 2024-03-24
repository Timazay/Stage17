package by.itstep.timazay.stage17.ooplesson.model.entity.container;

import by.itstep.timazay.stage17.ooplesson.model.entity.Ammunition;
import by.itstep.timazay.stage17.ooplesson.model.entity.Armor;
import by.itstep.timazay.stage17.ooplesson.model.entity.Weapon;

public class Inventory {
    public static final int DEFAULT_SIZE = 10;

    private Ammunition[] ammunition;
    private Armor[] armors;
    private Weapon[] weapons;
    private int size = 0;

    public Inventory() {
        ammunition = new Ammunition[DEFAULT_SIZE];
        armors = new Armor[DEFAULT_SIZE];
        weapons = new Weapon[DEFAULT_SIZE];
    }


    public Inventory(Ammunition[] ammunition) {
        this.ammunition = ammunition;
        size = ammunition.length;
    }

    public Inventory(Armor[] armors) {
        this.armors = armors;
        size = armors.length;
    }

    public Inventory(Weapon[] weapons) {
        this.weapons = weapons;
        size = weapons.length;
    }

    public Ammunition[] getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(Ammunition[] ammunition) {
        this.ammunition = ammunition;
    }

    public Armor[] getArmors() {
        return armors;
    }

    public void setArmors(Armor[] armors) {
        this.armors = armors;
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapon[] weapons) {
        this.weapons = weapons;
    }

    public int getSize() {
        return size;
    }
}
