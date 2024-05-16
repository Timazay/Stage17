package by.itstep.timazay.stage17.ooplesson.model.entity;


import by.itstep.timazay.stage17.ooplesson.model.entity.container.Inventory;
import by.itstep.timazay.stage17.ooplesson.model.entity.exception.InventoryException.AmmunitionNotFoundException;
import by.itstep.timazay.stage17.ooplesson.model.entity.exception.KnightException;

public class Knight {
    private String name;
    private double wallet;
    private double health;
    private static final double DEFAULT_HEALTH = 100;
    private boolean isAlive;
    private Armor armor;
    private Weapon weapon;
    private Inventory inventory;

    public Knight() {
        name = "Unknown";
        wallet = 0.0;
        health = 0;
        isAlive = false;
    }

    public Knight(String name, double wallet, Inventory inventory) {
        this.name = name;
        try {

            if (wallet >= 0) {
                this.wallet = wallet;
            } else {
                throw new KnightException("Incorrect wallet value");
            }

        } catch (KnightException e) {
            System.out.println(e);
        }
        this.inventory = inventory;
        inventory.setHasOwner(true);
        this.armor = new Armor();
        this.weapon = new Weapon();
        this.health = DEFAULT_HEALTH;
        this.isAlive = true;
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
        try {
            if (wallet >= 0) {
                this.wallet = wallet;
            } else {
                throw new KnightException("Insufficient funds");
            }
        } catch (KnightException e) {
            System.out.println(e);
        }
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        if (health <= 0) {
            isAlive = false;
            this.health = 0;
        } else {
            this.health = health;
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Armor getArmor() {
        return armor;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
        inventory.setHasOwner(true);

    }

    public void equipArmor(Armor armor) {
        Knight knight = this;
        Armor tempArmor = getArmor();
        if (tempArmor == null) {
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
        } else {
            try {
                if (inventory.contain(armor)) {
                    this.armor = armor;
                    inventory.remove(armor);
                    if (!tempArmor.getName().equals("Unknown")) {
                        inventory.add(tempArmor);
                    }
                } else {
                    throw new AmmunitionNotFoundException("There is no such armor in " + inventory);
                }
            } catch (AmmunitionNotFoundException e) {
                System.err.println(e);
            }
        }


    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void equipWeapon(Weapon weapon) {
        Knight knight = this;
        Weapon tempWeapon = getWeapon();

        if (tempWeapon == null) {
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
        } else {
            try {
                if (inventory.contain(weapon)) {
                    this.weapon = weapon;
                    inventory.remove(weapon);
                    if (!tempWeapon.getName().equals("Unknown")) {
                        inventory.add(tempWeapon);
                    }
                } else {
                    throw new AmmunitionNotFoundException("There is no such weapon in " + inventory);
                }
            } catch (AmmunitionNotFoundException e) {
                System.err.println(e);
            }

        }
    }

    @Override
    public String toString() {
        return "Knight name = " + name + "\n"
                + "* balance = " + wallet + "\n"
                + "* armor: " + armor + "\n"
                + "* weapon: " + weapon + "\n"
                + "* health: " + health + "/" + DEFAULT_HEALTH + "\n"
                + "* " + inventory;
    }
}
