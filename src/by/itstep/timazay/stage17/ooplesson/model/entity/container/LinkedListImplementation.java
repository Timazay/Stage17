package by.itstep.timazay.stage17.ooplesson.model.entity.container;

import by.itstep.timazay.stage17.ooplesson.model.entity.Ammunition;
import by.itstep.timazay.stage17.ooplesson.model.entity.exception.DuplicateAmmunitionException;

import java.util.LinkedList;

public class LinkedListImplementation implements Container {

    private LinkedList<Ammunition> linkedList;

    public LinkedListImplementation() {
        this.linkedList = new LinkedList<>();
    }

    @Override
    public void add(Ammunition ammunition) throws DuplicateAmmunitionException {
        if (linkedList.contains(ammunition)) {
            throw new DuplicateAmmunitionException();
        } else {
            linkedList.add(ammunition);
            //   linkedList.add(ammunition);
        }

    }

    @Override
    public void remove(Ammunition ammunition) {
        linkedList.remove(ammunition);
    }

    @Override
    public void remove(int index) {
        linkedList.remove(index);
    }

    @Override
    public Ammunition get(int index) {
        return linkedList.get(index);
    }

    @Override
    public int size() {
        return linkedList.size();
    }
}
