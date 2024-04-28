package by.itstep.timazay.stage17.ooplesson.model.entity.container.iterator;

import by.itstep.timazay.stage17.ooplesson.model.entity.Ammunition;
import by.itstep.timazay.stage17.ooplesson.model.entity.container.Inventory;

public interface Container {
    void add(Ammunition ammunition);
    void remove(Ammunition ammunition);
    void remove(int index);
    Ammunition get(int index);
    int size();
}
