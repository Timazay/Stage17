package by.itstep.timazay.stage17.ooplesson.model.entity.exception.InventoryException;

import by.itstep.timazay.stage17.ooplesson.model.entity.exception.InventoryException.InventoryException;

public class AmmunitionNotFoundException extends InventoryException {
    public AmmunitionNotFoundException() {
        super("There is no ammunition");
    }

    public AmmunitionNotFoundException(String message) {
        super(message);
    }


}
