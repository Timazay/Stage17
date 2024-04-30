package by.itstep.timazay.stage17.ooplesson.model.entity.container;

import by.itstep.timazay.stage17.ooplesson.model.entity.Ammunition;

public class ArrayImplementation implements Container {
    private static final int DEFAULT_SIZE = 10;
    private Ammunition[] ammunitionArray;
    private int size;

    public ArrayImplementation() {
        ammunitionArray = new Ammunition[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public void add(Ammunition ammunition) {
        if (size == ammunitionArray.length) {
            Ammunition[] newArray = new Ammunition[ammunitionArray.length * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = ammunitionArray[i];
            }
            ammunitionArray = newArray;
        }
        ammunitionArray[size] = ammunition;
        size++;
    }

    @Override
    public void remove(Ammunition ammunition) {
        for (int i = 0; i < size; i++) {
            if (ammunitionArray[i].equals(ammunition)) {
                remove(i);
                break;
            }
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            ammunitionArray[i] = ammunitionArray[i + 1];
        }
        size--;
    }

    @Override
    public Ammunition get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return ammunitionArray[index];
    }

    @Override
    public int size() {
        return size;
    }
}
