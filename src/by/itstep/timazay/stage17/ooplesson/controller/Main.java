package by.itstep.timazay.stage17.ooplesson.controller;

import by.itstep.timazay.stage17.ooplesson.model.entity.*;
import by.itstep.timazay.stage17.ooplesson.model.entity.container.Inventory;
import by.itstep.timazay.stage17.ooplesson.model.entity.exception.InventoryException.DuplicateAmmunitionException;
import by.itstep.timazay.stage17.ooplesson.model.entity.exception.InventoryException.InventoryIsOverflowing;
import by.itstep.timazay.stage17.ooplesson.model.io.KnightBinaryWorker;
import by.itstep.timazay.stage17.ooplesson.model.logic.JoustLogic;
import by.itstep.timazay.stage17.ooplesson.model.logic.TradeLogic;


public class Main {
    public static void main(String[] args) {
        Armor armor = new Armor("Chest", 34, 2, 32);
        Armor armor1 = new Armor("C", 33, 3, 54);
        Armor leg = new Armor("Leg", 84, 2, 43);
        Armor leg1 = new Armor("Leg2", 24, 3, 54);
        Weapon weapon = new Weapon(Artifact.SWORD_OF_MADNESS);
        Weapon sword = new Weapon(Artifact.FROSTMOURNE);
        Weapon sword2 = new Weapon("Artifact", 3, 4, 55);
        Weapon weapon3 = new Weapon("s", 32, 4, 23);
        Weapon sword4 = new Weapon("d", 49, 3, 489);

        Inventory inventory1 = new Inventory();
        Inventory inventory2 = new Inventory();


        Knight knight = new Knight("Sir Roderic", 60, inventory1);
        Knight knight2 = new Knight("Sir Godric", 40, inventory2);

        inventory1.add(armor1);
        inventory1.add(weapon3);
        inventory1.add(armor);




        knight.equipWeapon(weapon3);
        knight.equipArmor(armor1);
        System.out.println(knight);
        knight.equipArmor(armor);

        System.out.println(knight);


        String str = "C:/Users/Oxxxy/IdeaProjects/knight.bin";

        KnightBinaryWorker.writeKnight(str, knight);

        Knight knight1 = KnightBinaryWorker.readKnight(str);


     System.out.println(knight1);



        //    double[] result = new double[0];
        //    try {
        //        result = KnightLogic.findAmmunitionByDamage(inventory, 20, 300);
        //    } catch (AmmunitionNotFoundException e) {
        //        System.out.println(e);
        //    }

        //    for (double d : result) {
        //        System.out.println(d);
        //    }

        //    System.out.println();

        //    try {
        //        System.out.println(KnightLogic.findMaxDamage(inventory));
        //    } catch (AmmunitionNotFoundException e) {
        //        System.out.println(e);
        //    }

        //    System.out.println();


        //    double[] result2 = KnightLogic.findAmmunitionByPriceRange(inventory, 20, 1000);
        //    for (double d : result2) {
        //        System.out.println(d);
        //    }
        //     System.out.println(KnightLogic.findMostExpensiveAmmunition(inventory));


    }
}
