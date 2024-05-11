package by.itstep.timazay.stage17.ooplesson.model.entity.exception.InventoryException;

public class InventoryException extends Exception{
    public InventoryException() {
        super("Something wrong with inventory");
    }

    public InventoryException(String message) {
        super(message);
    }
}
