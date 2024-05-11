package by.itstep.timazay.stage17.ooplesson.model.logic;

import by.itstep.timazay.stage17.ooplesson.model.entity.Ammunition;
import by.itstep.timazay.stage17.ooplesson.model.entity.Armor;
import by.itstep.timazay.stage17.ooplesson.model.entity.Knight;
import by.itstep.timazay.stage17.ooplesson.model.entity.Weapon;
import by.itstep.timazay.stage17.ooplesson.model.entity.container.Inventory;

public class TradeLogic {
    private static final double COST_PER_UNIT = 2;

    public static boolean sellOrBuyAmmunition(Ammunition ammunition, Inventory seller, Inventory client) {
        if (ammunition == null || seller == null || seller == client) {
            return false;
        }
        boolean deal = false;
        Knight trader = seller.getOwner();
        Knight buyer = client.getOwner();
        double traderWallet = trader.getWallet();
        double buyerWallet = buyer.getWallet();


        if (buyerWallet >= ammunition.getPrice()) {
            if (seller.contain(ammunition)) {
                client.add(ammunition);
                seller.remove(ammunition);
                buyer.setWallet(buyerWallet - ammunition.getPrice());
                trader.setWallet(traderWallet + ammunition.getPrice());
                deal = true;

            }
        }

        return deal;

    }

    public static boolean buyExtraBackpack(Inventory inventory, double weight) {
        if (weight <= 0) {
            return false;
        }

        boolean deal = false;
        Knight knight = inventory.getOwner();
        double wallet = knight.getWallet();

        if (wallet >= weight * COST_PER_UNIT) {
            inventory.setMaxWeight(inventory.getMaxWeight() + weight);
            knight.setWallet(wallet - weight * COST_PER_UNIT);
            deal = false;
        }

        return deal;
    }

}
