package by.itstep.timazay.stage17.ooplesson.model.entity.exception.AmmunitionException;

public class AmmunitionException extends Exception{
    public AmmunitionException() {
        super("Something wrong with ammunition");
    }

    public AmmunitionException(String message) {
        super(message);
    }
}
