package by.itstep.timazay.stage17.ooplesson.controller;

import by.itstep.timazay.stage17.ooplesson.model.entity.*;
import by.itstep.timazay.stage17.ooplesson.model.entity.container.Inventory;
import by.itstep.timazay.stage17.ooplesson.model.entity.container.iterator.AmmunitionImplementation;
import by.itstep.timazay.stage17.ooplesson.model.entity.container.iterator.SecondInventory;
import by.itstep.timazay.stage17.ooplesson.model.logic.KnightLogic;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Armor armor = new Armor("Chest", 34, 53, 32);
        Armor armor1 = new Armor("C", 33, 33, 54);
        Armor leg = new Armor("Leg", 84, 23, 43);
        Armor leg1 = new Armor("Leg2", 24, 323, 54);
        Weapon weapon = new Weapon(Artifact.SWORD_OF_MADNESS);
        Weapon sword = new Weapon(Artifact.FROSTMOURNE);
        Weapon sword2 = new Weapon(Artifact.FROSTMOURNE);
        //    Weapon weapon = new Weapon("s", 32, 4, 23);
        //    Weapon sword = new Weapon("d", 49, 322, 489);


        Ammunition[] ammunitions = {sword, sword2, armor1};
        Armor[] armors = {armor1, leg1, leg, armor};
        Weapon[] weapons = {weapon, sword, sword2};
        SecondInventory inventory2 = new SecondInventory(ammunitions);
        AmmunitionImplementation a = new AmmunitionImplementation();
        Inventory inventory = new Inventory(ammunitions);
        Iterable[] iterable = {inventory2};

        for (int i = 0; i < ammunitions.length; i++) {
            System.out.println(ammunitions[i].toString());
            inventory2.add(ammunitions[i]);
        }
        System.out.println(inventory2.getSize());
        for (Iterable it : iterable) {
            Iterator iterator = inventory2.iterator();
            System.out.println(iterator.hasNext());
            while (iterator.hasNext()) {
                System.out.println(iterator.next() + "");
            }

        }

        //      System.out.println(KnightLogic.findCheapestAmmunition(inventory));
//
        //      System.out.println(KnightLogic.findMostExpensiveAmmunition(inventory));
//
        //      double[] result = KnightLogic.findAmmunitionByPriceRange(inventory, 20, 40);
//
        //      for (double price : result) {
        //          System.out.println(price);
        //      }





//       System.out.println(sword2.toString());
//       System.out.println(KnightLogic.calcTotalCost2(inventory2));
//       System.out.println(inventory2.toString());
//       System.out.println(KnightLogic.calcTotalCost(inventory));
    }
}
