package by.itstep.timazay.stage17.ooplesson.model.entity.exception;

public class DuplicateAmmunitionException extends Exception{
    public DuplicateAmmunitionException() {
        super("This ammunition already exists in the inventory.");
    }

    public DuplicateAmmunitionException(String message) {
        super(message);
    }

    public DuplicateAmmunitionException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateAmmunitionException(Throwable cause) {
        super(cause);
    }
}
