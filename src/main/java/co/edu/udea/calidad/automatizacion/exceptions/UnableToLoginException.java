package co.edu.udea.calidad.automatizacion.exceptions;

public class UnableToLoginException extends RuntimeException {

    public UnableToLoginException(String message) {
        super(message);
    }

    public UnableToLoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
