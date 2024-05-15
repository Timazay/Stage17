package by.itstep.timazay.stage17.ooplesson.model.logic;

import by.itstep.timazay.stage17.ooplesson.model.entity.Armor;
import by.itstep.timazay.stage17.ooplesson.model.entity.Knight;
import by.itstep.timazay.stage17.ooplesson.model.entity.Weapon;

public class JoustLogic {
    private static final double PRIZE_FUND = 300;

    public static Knight simulateJoust(Knight first, Knight second) {
        Weapon firstKnight = first.getWeapon();
        Weapon secondKnight = second.getWeapon();

        while (first.getHealth() > 0 && second.getHealth() > 0) {
            receiveDamage(second, firstKnight.getDamage());
            if (second.getHealth() <= 0) break;
            receiveDamage(first, secondKnight.getDamage());
        }

        if (first.isAlive()) {
            first.setWallet(first.getWallet() + PRIZE_FUND);
        } else {
            second.setWallet(second.getWallet() + PRIZE_FUND);
        }
        return (first.isAlive()) ? first : second;
    }

    private static void receiveDamage(Knight knight, double damage) {
        Armor armor = knight.getArmor();

        double actualDmg = Math.max(damage / 2, damage - armor.getDefence());
        knight.setHealth(knight.getHealth() - actualDmg);

    }
}
