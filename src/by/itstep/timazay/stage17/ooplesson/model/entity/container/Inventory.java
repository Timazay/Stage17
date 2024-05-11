package by.itstep.timazay.stage17.ooplesson.model.entity.container;

import by.itstep.timazay.stage17.ooplesson.model.entity.Ammunition;
import by.itstep.timazay.stage17.ooplesson.model.entity.Knight;
import by.itstep.timazay.stage17.ooplesson.model.entity.container.Implementation.LinkedListImplementation;
import by.itstep.timazay.stage17.ooplesson.model.entity.exception.InventoryException.AmmunitionNotFoundException;
import by.itstep.timazay.stage17.ooplesson.model.entity.exception.InventoryException.DuplicateAmmunitionException;
import by.itstep.timazay.stage17.ooplesson.model.entity.exception.InventoryException.InventoryIsOverflowing;

import java.util.Iterator;


public class Inventory implements Iterable<Ammunition> {
    Container container;
    private Knight owner;
    private double currentWeight;
    private double maxWeight;
    private static final double DEFAULT_MAX_WEIGHT = 100;


    public Inventory(Knight owner) {
        container = new LinkedListImplementation();
        this.owner = owner;
        maxWeight = DEFAULT_MAX_WEIGHT;
    }


    public Inventory(Container container, Knight owner) {
        this.container = container;
        this.owner = owner;
    }

    public Knight getOwner() {
        return owner;
    }

    public int getSize() {
        return container.size();
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Ammunition get(int index)  {
        try {
            if (index > container.size()) {
                throw new AmmunitionNotFoundException();
            }
        } catch (AmmunitionNotFoundException e){
            System.err.println(e);
        }
        return container.get(index);
    }

    public boolean contain(Ammunition ammunition) {
        return container.contain(ammunition);
    }


    public void add(Ammunition ammunition) {
        try {
            if (ammunition.getWeight() < maxWeight) {
                if (!container.contain(ammunition)) {
                    container.add(ammunition);
                    currentWeight += ammunition.getWeight();
                } else {
                    throw new DuplicateAmmunitionException();
                }
            } else {
                throw new InventoryIsOverflowing();
            }
        } catch (DuplicateAmmunitionException | InventoryIsOverflowing e){
            System.out.println(e);
        }
    }


    public void remove(Ammunition ammunition) {
        container.remove(ammunition);
        currentWeight -= ammunition.getWeight();
    }

    public void remove(int index){
        try {
            if (getSize() == index) {
                Ammunition ammunition = container.get(index);
                container.remove(index);
                currentWeight -= ammunition.getWeight();
            } else {
                throw new AmmunitionNotFoundException();
            }
        } catch (AmmunitionNotFoundException e) {
            System.out.println(e);
        }
    }

    public double getCurrentWeight() {
        return currentWeight;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("List ammunition of " + owner.getName() + ":\n");
        for (int i = 0; i < container.size(); i++) {
                builder.append(container.get(i)).append("\n");
        }
        builder.append("Weight: " + currentWeight + "/" + maxWeight);
        return builder.toString();
    }

    @Override
    public Iterator<Ammunition> iterator() {
        return new InventoryIterator();
    }

    private class InventoryIterator implements Iterator<Ammunition> {
        private int count = 0;

        @Override
        public boolean hasNext() {
            return count < container.size();
        }

        @Override
        public Ammunition next() {
            if (!hasNext()) {
                try {
                   throw new AmmunitionNotFoundException("There is no further ammunition");
                } catch (AmmunitionNotFoundException e) {
                    System.out.println(e);
                }
            }
            return container.get(count++);
        }
    }

}
