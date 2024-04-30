package by.itstep.timazay.stage17.ooplesson.model.entity.exception;

public class AmmunitionNotFoundException extends Exception{
    public AmmunitionNotFoundException() {
        super("There is no ammunition");
    }

    public AmmunitionNotFoundException(String message) {
        super(message);
    }

    public AmmunitionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AmmunitionNotFoundException(Throwable cause) {
        super(cause);
    }

}
