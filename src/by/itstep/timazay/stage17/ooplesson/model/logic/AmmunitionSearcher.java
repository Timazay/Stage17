package by.itstep.timazay.stage17.ooplesson.model.logic;

import by.itstep.timazay.stage17.ooplesson.model.entity.Ammunition;
import by.itstep.timazay.stage17.ooplesson.model.entity.Armor;
import by.itstep.timazay.stage17.ooplesson.model.entity.Weapon;
import by.itstep.timazay.stage17.ooplesson.model.entity.container.Inventory;

public class AmmunitionSearcher {
    public static double[] findAmmunitionByPriceRange(Inventory inventory, int minPrice, int maxPrice) {
        if (inventory == null || inventory.getSize() == 0) {
            return new double[]{-1};
        }

            int count = 0;
            for (Ammunition item : inventory) {
                if (item.getPrice() >= minPrice && item.getPrice() <= maxPrice) {
                    count++;
                }
            }

            double[] result = new double[count];
            int index = 0;
            for (Ammunition item : inventory) {
                if (item.getPrice() >= minPrice && item.getPrice() <= maxPrice) {
                    result[index] = item.getPrice();
                    index++;
                }
            }

        return result;
    }


    public static double findCheapestAmmunition(Inventory inventory) {
        if (inventory == null || inventory.getSize() == 0) {
            return -1;
        }

        double minCost = Double.MAX_VALUE;

        for (Ammunition ammunition : inventory) {
            if (ammunition.getPrice() < minCost) {
                minCost = ammunition.getPrice();
            }
        }

        return minCost;
    }


    public static double findMostExpensiveAmmunition(Inventory inventory) {
        if (inventory == null || inventory.getSize() == 0) {
            return -1;
        }

        double maxCost = Double.MIN_VALUE;

        for (Ammunition ammunition : inventory) {
            if (ammunition.getPrice() > maxCost) {
                maxCost = ammunition.getPrice();
            }
        }

        return maxCost;
    }



    public static int[] findAmmunitionByDefense(Inventory inventory, int minDefense, int maxDefense){
        if (inventory == null || inventory.getSize() == 0) {
            return new int[]{-1};
        }

        Inventory ammunitions = inventory;
        int count = 0;
        for (int i = 0; i < ammunitions.getSize(); i++) {
            Ammunition ammunition = ammunitions.get(i);
            if (ammunition instanceof Armor) {
                Armor weapon = (Armor) ammunition;
                if (weapon.getDefence() >= minDefense && weapon.getDefence() <= maxDefense) {
                    count++;
                }
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < ammunitions.getSize(); i++) {
            Ammunition ammunition = ammunitions.get(i);
            if (ammunition instanceof Armor) {
                Armor armor = (Armor) ammunition;
                if (armor.getDefence() >= minDefense && armor.getDefence() <= maxDefense) {
                    result[index] = armor.getDefence();
                    index++;
                }
            }
        }

        return result;
    }

    public static int findMinDefense(Inventory inventory) {
        if (inventory == null || inventory.getSize() == 0) {
            return -1;
        }

        int minDefense = Integer.MAX_VALUE;

        for (int i = 0; i < inventory.getSize(); i++) {
            Ammunition ammunition = inventory.get(i);
            if (ammunition instanceof Armor) {
                Armor armor = (Armor) ammunition;
                int defense = armor.getDefence();
                if (defense < minDefense) {
                    minDefense = defense;
                }
            }
        }

        return minDefense;
    }

    public static int findMaxDefense(Inventory inventory) {
        if (inventory == null || inventory.getSize() == 0) {
            return -1;
        }

        int minDefense = Integer.MIN_VALUE;

        for (int i = 0; i < inventory.getSize(); i++) {
            Ammunition ammunition = inventory.get(i);
            if (ammunition instanceof Armor) {
                Armor armor = (Armor) ammunition;
                int defense = armor.getDefence();
                if (defense > minDefense) {
                    minDefense = defense;
                }
            }
        }

        return minDefense;
    }


    public static double[] findAmmunitionByWeight(Inventory inventory, int minHeight, int maxHeight) {
        if (inventory == null || inventory.getSize() == 0) {
            return new double[]{-1};
        }

        int count = 0;
        for (Ammunition item : inventory) {
            if (item.getWeight() >= minHeight && item.getWeight() <= maxHeight) {
                count++;
            }
        }

        double[] result = new double[count];
        int index = 0;
        for (Ammunition item : inventory) {
            if (item.getWeight() >= minHeight && item.getWeight() <= maxHeight) {
                result[index] = item.getWeight();
                index++;
            }
        }

        return result;
    }

    public static double[] findAmmunitionByDamage(Inventory inventory, int minDamage, int maxDamage) {
        if (inventory == null || inventory.getSize() == 0) {
            return new double[]{-1};
        }

        Inventory ammunitions = inventory;
        int count = 0;
        for (int i = 0; i < ammunitions.getSize(); i++) {
            Ammunition ammunition = ammunitions.get(i);
            if (ammunition instanceof Weapon) {
                Weapon weapon = (Weapon) ammunition;
                if (weapon.getDamage() >= minDamage && weapon.getDamage() <= maxDamage) {
                    count++;
                }
            }
        }

        double[] result = new double[count];
        int index = 0;
        for (int i = 0; i < ammunitions.getSize(); i++) {
            Ammunition ammunition = ammunitions.get(i);
            if (ammunition instanceof Weapon) {
                Weapon weapon = (Weapon) ammunition;
                if (weapon.getDamage() >= minDamage && weapon.getDamage() <= maxDamage) {
                    result[index] = weapon.getDamage();
                    index++;
                }
            }
        }

        return result;
    }


    public static double findMinDamage(Inventory inventory) {
        if (inventory == null || inventory.getSize() == 0) {
            return -1;
        }

        double minDamage = Double.MAX_VALUE;

        for (int i = 0; i < inventory.getSize(); i++) {
            Ammunition ammunition = inventory.get(i);
            if (ammunition instanceof Weapon) {
                Weapon weapon = (Weapon) ammunition;
                double damage = weapon.getDamage();
                if (damage < minDamage) {
                    minDamage = damage;
                }
            }
        }

        return minDamage;
    }

    public static double findMaxDamage(Inventory inventory) {
        if (inventory == null || inventory.getSize() == 0) {
            return -1;
        }

        double maxDamage = Double.MIN_VALUE;

        for (int i = 0; i < inventory.getSize(); i++) {
            Ammunition ammunition = inventory.get(i);
            if (ammunition instanceof Weapon) {
                Weapon weapon = (Weapon) ammunition;
                double damage = weapon.getDamage();
                if (damage > maxDamage) {
                    maxDamage = damage;
                }
            }
        }

        return maxDamage;
    }

}


