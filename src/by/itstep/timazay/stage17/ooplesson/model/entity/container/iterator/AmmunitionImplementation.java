package by.itstep.timazay.stage17.ooplesson.model.entity.container.iterator;

import by.itstep.timazay.stage17.ooplesson.model.entity.Ammunition;

import java.util.LinkedList;

public class AmmunitionImplementation implements Container {
   // private Ammunition[] ammunitions;
    private LinkedList<Ammunition> linkedList;

    public AmmunitionImplementation() {
        this.linkedList = new LinkedList<>();
    }

    @Override
    public void add(Ammunition ammunition) {
        linkedList.add(ammunition);
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
