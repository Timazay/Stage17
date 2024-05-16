package by.itstep.timazay.stage17.ooplesson.model.logic;

import by.itstep.timazay.stage17.ooplesson.model.entity.Ammunition;
import by.itstep.timazay.stage17.ooplesson.model.entity.Knight;
import by.itstep.timazay.stage17.ooplesson.model.entity.container.Inventory;

public class TradeLogic {
    private static final double COST_PER_UNIT = 2;
    private static final double FIRST_AID_KIT_COST = 50;

    public static boolean sellOrBuyAmmunition(Ammunition ammunition, Knight seller, Knight client) {
        if (ammunition == null || seller == null || seller == client) {
            return false;
        }
        boolean deal = false;
        Inventory trader = seller.getInventory();
        Inventory buyer = client.getInventory();
        double traderWallet = seller.getWallet();
        double buyerWallet = client.getWallet();


        if (buyerWallet >= ammunition.getPrice()) {
            if (trader.contain(ammunition)) {
                buyer.add(ammunition);
                trader.remove(ammunition);
                client.setWallet(buyerWallet - ammunition.getPrice());
                seller.setWallet(traderWallet + ammunition.getPrice());
                deal = true;

            }
        }

        return deal;

    }

    public static boolean buyExtraBackpack(Knight knight, double weight) {
        if (weight <= 0 || knight == null) {
            return false;
        }

        boolean deal = false;
        Inventory inventory = knight.getInventory();
        double wallet = knight.getWallet();

        if (wallet >= weight * COST_PER_UNIT) {
            inventory.setMaxWeight(inventory.getMaxWeight() + weight);
            knight.setWallet(wallet - weight * COST_PER_UNIT);
            deal = false;
        }

        return deal;
    }

    public static boolean buyHeal(Knight knight) {
        if (knight == null){
            return false;
        }
        boolean deal = false;
        if (FIRST_AID_KIT_COST <= knight.getWallet()) {
            knight.setHealth(100);
            knight.setWallet(knight.getWallet() - FIRST_AID_KIT_COST);
            deal = true;
        }

        return deal;
    }

}
