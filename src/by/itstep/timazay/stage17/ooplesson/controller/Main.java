package by.itstep.timazay.stage17.ooplesson.controller;

import by.itstep.timazay.stage17.ooplesson.model.entity.*;
import by.itstep.timazay.stage17.ooplesson.model.entity.container.Inventory;
import by.itstep.timazay.stage17.ooplesson.model.logic.KnightLogic;

public class Main {
    public static void main(String[] args) {
        Armor armor = new Armor("Chest", 34, 53, 32);
        Armor armor1 = new Armor("C", 33, 33, 54);
        Armor leg = new Armor("Leg", 84, 23, 43);
        Armor leg1 = new Armor("Leg2", 24, 323, 54);


        Ammunition[] chests = {armor1, leg1, leg, armor};
        Inventory inventory = new Inventory(chests);


        System.out.println(KnightLogic.findCheapestAmmunition(inventory));

        System.out.println(KnightLogic.findMostExpensiveAmmunition(inventory));

        double[] result = KnightLogic.findAmmunitionByPriceRange(inventory,20,40);

      for (double price:result) {
          System.out.println(price);
      }
    }
}
