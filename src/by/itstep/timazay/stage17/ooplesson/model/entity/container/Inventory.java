package by.itstep.timazay.stage17.ooplesson.model.entity.container;

import by.itstep.timazay.stage17.ooplesson.model.entity.Ammunition;
import by.itstep.timazay.stage17.ooplesson.model.entity.exception.AmmunitionNotFoundException;
import by.itstep.timazay.stage17.ooplesson.model.entity.exception.DuplicateAmmunitionException;

import java.util.Iterator;


public class Inventory implements Iterable<Ammunition> {
    Container container;


    public Inventory(Ammunition[] ammunition) {
        container = new LinkedListImplementation();
    }


    public Inventory(Container container) {
        this.container = container;
    }


    public int getSize() {
        return container.size();
    }

    public Ammunition get(int index) throws AmmunitionNotFoundException {
        return container.get(index);
    }


    public void add(Ammunition ammunition) throws DuplicateAmmunitionException {
        container.add(ammunition);
    }

    public void remove(Ammunition ammunition) {
        container.remove(ammunition);
    }

    public void remove(int index) {
        container.remove(index);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("List of ammunition:\n");
        for (int i = 0; i < container.size(); i++) {
            try {
                builder.append(container.get(i)).append("\n");
            } catch (AmmunitionNotFoundException e) {
                System.out.println(e);
            }
        }
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
            if (hasNext()) {
                try {
                    return container.get(count++);
                } catch (AmmunitionNotFoundException e) {
                    System.out.println(e);
                }
            }
            return null;
        }
    }

}
