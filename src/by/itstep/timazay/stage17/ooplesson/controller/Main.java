package by.itstep.timazay.stage17.ooplesson.controller;

import by.itstep.timazay.stage17.ooplesson.model.entity.*;
import by.itstep.timazay.stage17.ooplesson.model.entity.container.Inventory;
import by.itstep.timazay.stage17.ooplesson.model.entity.exception.AmmunitionNotFoundException;
import by.itstep.timazay.stage17.ooplesson.model.entity.exception.DuplicateAmmunitionException;
import by.itstep.timazay.stage17.ooplesson.model.logic.KnightLogic;



public class Main {
    public static void main(String[] args) {
        Armor armor = new Armor("Chest", 34, 53, 32);
        Armor armor1 = new Armor("C", 33, 33, 54);
        Armor leg = new Armor("Leg", 84, 23, 43);
        Armor leg1 = new Armor("Leg2", 24, 323, 54);
        Weapon weapon = new Weapon(Artifact.SWORD_OF_MADNESS);
        Weapon sword = new Weapon(Artifact.FROSTMOURNE);
        Weapon sword2 = new Weapon("Artifact", 3, 4, 55);
        Weapon weapon3 = new Weapon("s", 32, 4, 23);
        Weapon sword4 = new Weapon("d", 49, 322, 489);

        Ammunition[] ammunitions = {sword, sword2, armor1, leg,  armor, sword4, weapon};

        Inventory inventory = new Inventory(ammunitions);


        for (int i = 0; i < ammunitions.length; i++) {
            try {
       //         System.out.println(ammunitions[i].toString());
                inventory.add(ammunitions[i]);
            } catch (DuplicateAmmunitionException exc) {
                System.err.println("" + exc + ammunitions[i]);
            }
        }

        double[] result = new double[0];
        try {
            result = KnightLogic.findAmmunitionByDamage(inventory, 20, 300);
        } catch (AmmunitionNotFoundException e) {
            System.out.println(e);
        }

        for (double d : result) {
            System.out.println(d);
        }

        System.out.println();

        try {
            System.out.println(KnightLogic.findMaxDamage(inventory));
        } catch (AmmunitionNotFoundException e) {
            System.out.println(e);
        }

        System.out.println();


        double[] result2 = KnightLogic.findAmmunitionByPriceRange(inventory, 20, 1000);
        for (double d : result2) {
            System.out.println(d);
        }
         System.out.println(KnightLogic.findMostExpensiveAmmunition(inventory));


    }
}
