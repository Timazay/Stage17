package by.itstep.timazay.stage17.ooplesson.model.entity.container;

import by.itstep.timazay.stage17.ooplesson.model.entity.Ammunition;
import by.itstep.timazay.stage17.ooplesson.model.entity.Armor;
import by.itstep.timazay.stage17.ooplesson.model.entity.Weapon;

public interface Container {
    void add(Ammunition ammunition) ;
    void remove(Ammunition ammunition) ;
    void remove(int index) ;
    boolean contain(Ammunition ammunition);
    Ammunition get(int index);
    int size();

}
