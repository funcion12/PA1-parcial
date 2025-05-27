package exception;

public class ExceptionNoPuedenExisteDosDocumento extends RuntimeException {
    public ExceptionNoPuedenExisteDosDocumento(String message) {
        super(message);
    }
}
