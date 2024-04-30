package by.itstep.timazay.stage17.ooplesson.model.entity.container;

import by.itstep.timazay.stage17.ooplesson.model.entity.Ammunition;
import by.itstep.timazay.stage17.ooplesson.model.entity.exception.AmmunitionNotFoundException;
import by.itstep.timazay.stage17.ooplesson.model.entity.exception.DuplicateAmmunitionException;

public interface Container {
    void add(Ammunition ammunition) throws DuplicateAmmunitionException;
    void remove(Ammunition ammunition);
    void remove(int index);
    Ammunition get(int index) throws AmmunitionNotFoundException;
    int size();
}
