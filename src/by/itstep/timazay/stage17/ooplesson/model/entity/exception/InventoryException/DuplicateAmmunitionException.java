package by.itstep.timazay.stage17.ooplesson.model.entity.exception.InventoryException;

import by.itstep.timazay.stage17.ooplesson.model.entity.exception.InventoryException.InventoryException;

public class DuplicateAmmunitionException extends InventoryException {
    public DuplicateAmmunitionException() {
        super("This ammunition already exists in the inventory.");
    }

    public DuplicateAmmunitionException(String message) {
        super(message);
    }

}
