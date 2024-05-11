package by.itstep.timazay.stage17.ooplesson.model.entity;


import by.itstep.timazay.stage17.ooplesson.model.entity.container.Inventory;
import by.itstep.timazay.stage17.ooplesson.model.entity.exception.InventoryException.AmmunitionNotFoundException;
import by.itstep.timazay.stage17.ooplesson.model.entity.exception.InventoryException.DuplicateAmmunitionException;
import by.itstep.timazay.stage17.ooplesson.model.entity.exception.KnightException;

public class Knight {
    private String name;
    private double wallet;
    private Armor armor;
    private Weapon weapon;

    public Knight() {
        name = "Unknown";
        wallet = 0.0;
    }

    public Knight(String name, double wallet) {
        this.name = name;
        this.wallet = wallet;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public Armor getArmor() {
        return armor;
    }

    public void equipArmor(Inventory inventory, Armor armor) {
        Knight knight = inventory.getOwner();
        try {
        if (knight == this) {
            try {
                if (inventory.contain(armor)) {
                    this.armor = armor;
                    inventory.remove(armor);
                } else {

                    throw new AmmunitionNotFoundException("There is no such armor in " + inventory);
                }
            } catch (AmmunitionNotFoundException e) {
                System.err.println(e);
            }
        }else {
            throw new KnightException();
        } } catch (KnightException e){
            System.out.println("Wrong Knight owner");
        }

    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void equipWeapon(Inventory inventory, Weapon weapon) {
        Knight knight = inventory.getOwner();
        try {
            if (knight == this && this.weapon == null) {
                try {
                    if (inventory.contain(weapon)) {
                        this.weapon = weapon;
                        inventory.remove(weapon);
                    } else {

                        throw new AmmunitionNotFoundException("There is no such weapon in " + inventory);
                    }
                } catch (AmmunitionNotFoundException e) {
                    System.err.println(e);
                }
            }else {
                throw new KnightException();
            } } catch (KnightException e){
            System.out.println("Wrong Knight owner");
        }
    }

    @Override
    public String toString() {
        return "Knight name = " + name + "\n"
                + ", balance = " + wallet + "\n"
                + ", armor: " + armor + "\n"
                + ", weapon: " + weapon;
    }
}
