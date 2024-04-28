package by.itstep.timazay.stage17.ooplesson.model.entity.container.iterator;

import by.itstep.timazay.stage17.ooplesson.model.entity.Ammunition;

import java.util.Iterator;

public class SecondInventory implements Iterable<Ammunition> {
  //  public static final int DEFAULT_SIZE = 10;
    Container container;


    public SecondInventory(Ammunition[] ammunition) {
        container = new AmmunitionImplementation();
    }

    public SecondInventory(Container container) {
        this.container = container;
    }


    public int getSize() {
        return container.size();
    }

    public Ammunition getAmmunition(int index) {
        return container.get(index);
    }

   public void add(Ammunition ammunition) {
        container.add(ammunition);
    }
    public void remove(Ammunition ammunition) {
        container.remove(ammunition);
    }

    public void remove(int index) {
        container.remove(index);
    }
    public Ammunition get(int index) {
        return container.get(index);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("List of ammunition:\n");
        for (int i = 0; i < container.size(); i++) {
            builder.append(container.get(i)).append("\n");
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
            return container.get(count++);
        }
    }
}
