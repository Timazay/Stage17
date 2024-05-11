package by.itstep.timazay.stage17.ooplesson.model.entity.exception.InventoryException;

import by.itstep.timazay.stage17.ooplesson.model.entity.exception.InventoryException.InventoryException;

public class InventoryIsOverflowing extends InventoryException {
    public InventoryIsOverflowing() {
        super("Inventory is full!!! Please, try to remove some ammunition.");
    }

    public InventoryIsOverflowing(String message) {
        super(message);
    }
}
