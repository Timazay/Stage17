package by.itstep.timazay.stage17.ooplesson.model.logic;

import by.itstep.timazay.stage17.ooplesson.model.entity.Ammunition;
import by.itstep.timazay.stage17.ooplesson.model.entity.Armor;
import by.itstep.timazay.stage17.ooplesson.model.entity.Weapon;
import by.itstep.timazay.stage17.ooplesson.model.entity.container.Inventory;
import by.itstep.timazay.stage17.ooplesson.model.entity.exception.InventoryException.AmmunitionNotFoundException;

public class AmmunitionCalculator {
    public static double calcTotalCost(Inventory inventory) {
        if (inventory == null || inventory.getSize() == 0) {
            return -1;
        }

        double totalCost = 0;
        for (Ammunition equipment :
                inventory) {
            totalCost += equipment.getPrice();
        }
        return totalCost;
    }

    public static int calcTotalDefense(Inventory inventory) {
        if (inventory == null || inventory.getSize() == 0) {
            return -1;
        }

        int totalDefense = 0;
        for (int i = 0; i < inventory.getSize(); i++) {
            Ammunition ammunition = inventory.get(i);
            if (ammunition instanceof Armor) {
                totalDefense += ((Armor) ammunition).getDefense();
            }
        }
        return totalDefense;
    }

    public static double calcTotalWeight(Inventory inventory) {
        if (inventory == null || inventory.getSize() == 0) {
            return -1;
        }

        double totalCost = 0;
        for (Ammunition equipment :
                inventory) {
            totalCost += equipment.getWeight();
        }
        return totalCost;
    }

    public static double calcTotalDamage(Inventory inventory) {
        if (inventory == null || inventory.getSize() == 0) {
            return -1;
        }

        int totalDamage = 0;
        for (int i = 0; i < inventory.getSize(); i++) {
            Ammunition ammunition = inventory.get(i);
            if (ammunition instanceof Weapon) {
                totalDamage += ((Weapon) ammunition).getDamage();
            }
        }
        return totalDamage;
    }
}
