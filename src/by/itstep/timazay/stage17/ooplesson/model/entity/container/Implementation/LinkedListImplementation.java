package by.itstep.timazay.stage17.ooplesson.model.entity.container.Implementation;

import by.itstep.timazay.stage17.ooplesson.model.entity.Ammunition;
import by.itstep.timazay.stage17.ooplesson.model.entity.container.Container;

import java.util.LinkedList;

public class LinkedListImplementation implements Container {

    private LinkedList<Ammunition> linkedList;

    public LinkedListImplementation() {
        this.linkedList = new LinkedList<>();
    }

    @Override
    public void add(Ammunition ammunition){
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
    public boolean contain(Ammunition ammunition) {
        return linkedList.contains(ammunition);
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
