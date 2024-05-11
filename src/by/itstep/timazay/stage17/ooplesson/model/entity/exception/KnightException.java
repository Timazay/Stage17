package by.itstep.timazay.stage17.ooplesson.model.entity.exception;

public class KnightException extends Exception{
    public KnightException() {
        super("Something wrong with knight");
    }

    public KnightException(String message) {
        super(message);
    }
}
