package by.itstep.timazay.stage17.ooplesson.model.logic;

import by.itstep.timazay.stage17.ooplesson.model.entity.Ammunition;
import by.itstep.timazay.stage17.ooplesson.model.entity.Armor;
import by.itstep.timazay.stage17.ooplesson.model.entity.Weapon;
import by.itstep.timazay.stage17.ooplesson.model.entity.container.Inventory;

public class KnightLogic {
    public static double calcTotalCost(Inventory inventory) {
        if (inventory == null || inventory.getSize() == 0) {
            return -1;
        }

        double totalCost = 0;
        for (Ammunition equipment :
                inventory.getAmmunition()) {
            totalCost += equipment.getCost();
        }
        return totalCost;
    }

    public static double[] findAmmunitionByPriceRange(Inventory inventory, int minPrice, int maxPrice) {
        if (inventory == null || inventory.getSize() == 0) {
            return new double[] {-1};
        }

        int count = 0;
        for (Ammunition item : inventory.getAmmunition()) {
            if (item.getCost() >= minPrice && item.getCost() <= maxPrice) {
                count++;
            }
        }
        double[] result = new double[count];
        int index = 0;
        for (Ammunition item : inventory.getAmmunition()) {
            if (item.getCost() >= minPrice && item.getCost() <= maxPrice) {
                result[index] = item.getCost();
                index++;
            }
        }
        return result;
    }

    public static double findCheapestAmmunition(Inventory inventory) {
        if (inventory == null || inventory.getSize() == 0) {
            return -1;
        }

        Ammunition[] equipment = inventory.getAmmunition();
        double cheapest = equipment[0].getCost();

        for (int i = 1; i < equipment.length; i++) {
            if (equipment[i].getCost() < cheapest) {
                cheapest = equipment[i].getCost();
            }
        }
        return cheapest;
    }

    public static double findMostExpensiveAmmunition(Inventory inventory) {
        if (inventory == null || inventory.getSize() == 0) {
            return -1;
        }

        Ammunition[] equipment = inventory.getAmmunition();
        double mostExpensive = equipment[0].getCost();
        for (int i = 1; i < equipment.length; i++) {
            if (equipment[i].getCost() > mostExpensive) {
                mostExpensive = equipment[i].getCost();
            }
        }
        return mostExpensive;
    }

    public static int calcTotalDefense(Inventory inventory) {
        if (inventory == null || inventory.getSize() == 0) {
            return -1;
        }

        int totalDefense = 0;
        for (Armor defense :
                inventory.getArmors()) {
            totalDefense += defense.getProtection();
        }
        return totalDefense;
    }

    public static double calcTotalHeight(Inventory inventory) {
        if (inventory == null || inventory.getSize() == 0) {
            return -1;
        }

        double totalHeight = 0;
        for (Ammunition height : inventory.getAmmunition()) {
            totalHeight += height.getHeight();
        }
        return totalHeight;
    }

    public static int[] findAmmunitionByDefense(Inventory inventory, int minDefense, int maxDefense) {
        if (inventory == null || inventory.getSize() == 0) {
            return new int[] {-1};
        }

        int count = 0;
        for (Armor item : inventory.getArmors()) {
            if (item.getProtection() >= minDefense && item.getProtection() <= maxDefense) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (Armor item : inventory.getArmors()) {
            if (item.getProtection() >= minDefense && item.getProtection() <= maxDefense) {
                result[index] = item.getProtection();
                index++;
            }
        }
        return result;
    }

    public static int findMinDefense(Inventory inventory) {
        if (inventory == null || inventory.getSize() == 0) {
            return -1;
        }

        Armor[] armors = inventory.getArmors();
        int minDefense = armors[0].getProtection();

        for (int i = 1; i < armors.length; i++) {
            if (armors[i].getProtection() < minDefense) {
                minDefense = armors[i].getProtection();
            }
        }
        return minDefense;
    }

    public static int findMaxDefense(Inventory inventory) {
        if (inventory == null || inventory.getSize() == 0) {
            return -1;
        }

        Armor[] armor = inventory.getArmors();
        int maxDefense = armor[0].getProtection();
        for (int i = 1; i < armor.length; i++) {
            if (armor[i].getProtection() > maxDefense) {
                maxDefense = armor[i].getProtection();
            }
        }
        return maxDefense;
    }


  public static double[] findAmmunitionByHeight(Inventory inventory, int minHeight, int maxHeight) {
      if (inventory == null || inventory.getSize() == 0) {
          return new double[] {-1};
      }

      int count = 0;
      for (Ammunition item : inventory.getAmmunition()) {
          if (item.getHeight() >= minHeight && item.getHeight() <= maxHeight) {
              count++;
          }
      }

       double[] result = new double[count];
       int index = 0;
       for (Ammunition item : inventory.getAmmunition()) {
           if (item.getHeight() >= minHeight && item.getHeight() <= maxHeight){
               result[index] = item.getHeight();
               index++;
           }
       }

       return result;
   }

    public static double calcTotalDamage(Inventory inventory) {
        if (inventory == null || inventory.getSize() == 0) {
            return -1;
        }

        double totalDamage = 0;
        for (Weapon defense :
                inventory.getWeapons()) {
            totalDamage += defense.getDamage();
        }
        return totalDamage;
    }

    public static double[] findAmmunitionByDamage(Inventory inventory, int minHeight, int maxHeight) {
        if (inventory == null || inventory.getSize() == 0) {
            return new double[] {-1};
        }

        int count = 0;
        for (Weapon item : inventory.getWeapons()) {
            if (item.getDamage() >= minHeight && item.getDamage() <= maxHeight) {
                count++;
            }
        }

        double[] result = new double[count];
        int index = 0;
        for (Weapon item : inventory.getWeapons()) {
            if (item.getDamage() >= minHeight && item.getDamage() <= maxHeight){
                result[index] = item.getDamage();
                index++;
            }
        }

        return result;
    }

    public static double findMinDamage(Inventory inventory) {
        if (inventory == null || inventory.getSize() == 0) {
            return -1;
        }

        Weapon[] weapons = inventory.getWeapons();
        double minDefense = weapons[0].getDamage();

        for (int i = 1; i < weapons.length; i++) {
            if (weapons[i].getDamage() < minDefense) {
                minDefense = weapons[i].getDamage();
            }
        }
        return minDefense;
    }

    public static double findMaxDamage(Inventory inventory) {
        if (inventory == null || inventory.getSize() == 0) {
            return -1;
        }

        Weapon[] weapons = inventory.getWeapons();
        double maxDefense = weapons[0].getDamage();
        for (int i = 1; i < weapons.length; i++) {
            if (weapons[i].getDamage() > maxDefense) {
                maxDefense = weapons[i].getDamage();
            }
        }
        return maxDefense;
    }

}


