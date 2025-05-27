package exception;

public class ExceptionPilotoExiste extends RuntimeException {
  public ExceptionPilotoExiste(String message) {
    super(message);
  }
}
