package by.itstep.timazay.stage17.ooplesson.model.logic;

import by.itstep.timazay.stage17.ooplesson.model.entity.Ammunition;
import by.itstep.timazay.stage17.ooplesson.model.entity.Armor;
import by.itstep.timazay.stage17.ooplesson.model.entity.container.Inventory;
import by.itstep.timazay.stage17.ooplesson.model.entity.exception.InventoryException.DuplicateAmmunitionException;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class KnightLogicTest {
 //  @Test
 //  public void testCalcTotalPricePositive() {
 //      //arrange
 //      Ammunition[] ammunitions = {new Armor("a", 3.5, 2.0, 3),
 //              new Armor("b", 6.5, 2.0, 3),
 //              new Armor("c", 10, 2.0, 3)};
 //      Inventory inventory = new Inventory(ammunitions);
 //      for (int i = 0; i < ammunitions.length; i++) {
 //          try {
 //              inventory.add(ammunitions[i]);
 //          } catch (DuplicateAmmunitionException exc) {
 //          }
 //      }
 //      double expected = 20.0;

 //      //act
 //      double actual = KnightLogic.calcTotalCost(inventory);

 //      //assert
 //      assertEquals(expected, actual, 0.000);
 //  }

 //  @Test
 //  public void testCalcTotalPriceByNull() {
 //      Inventory inventory = null;
 //      double expected = -1;

 //      double actual = KnightLogic.calcTotalCost(inventory);

 //      assertEquals(expected, actual, 0.0);
 //  }

 //   @Test
 //   public void testCalcTotalPriceByEmptyInventory() {
 //       Inventory inventory = new Inventory();
 //       double expected = -1;
//
 //       double actual = KnightLogic.calcTotalCost(inventory);
//
 //       assertEquals(expected, actual, 0.0);
//
 //   }
 //   @Test
//   public void testCalcAmmunitionPriceRangeByEmptyInventory(){
//       Inventory inventory = new Inventory();
//       double[] expected = {-1};

//       double[] actual = KnightLogic.findAmmunitionByPriceRange(inventory, 3, 4);

//       assertArrayEquals(expected, actual, 0);
//   }

 //  @Test
 //  public void testCalcAmmunitionPriceRangeByPositive(){
 //      Ammunition[] ammunitions = {new Armor("a", 3.5, 2.0, 3),
 //              new Armor("b", 6.5, 2.0, 3),
 //              new Armor("c", 10, 2.0, 3)};
 //      Inventory inventory = new Inventory(ammunitions);

 //      for (int i = 0; i < ammunitions.length; i++) {
 //          try {
 //              inventory.add(ammunitions[i]);
 //          } catch (DuplicateAmmunitionException exc) {}
 //      }

 //      double[] expected = {3.5, 6.5};

 //      //act
 //      double[] actual = KnightLogic.findAmmunitionByPriceRange(inventory,1,7);

 //      //assert
 //      for (double price : actual) {
 //          System.out.println(price);
 //      }
 //      assertArrayEquals(expected, actual, 0.000);
 //  }

 //  @Test
 //  public void testCalcAmmunitionPriceRangeByNull() {
 //      Inventory inventory = null;
 //      double[] expected = {-1};

 //      double[] actual = KnightLogic.findAmmunitionByPriceRange(inventory, 2, 7);

 //      assertArrayEquals(expected, actual, 0.0);
 //  }
}
